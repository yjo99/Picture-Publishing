package com.jo.picPublising.business.serivceImp;

import com.jo.picPublising.business.dto.request.LogInDto;
import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.dto.response.ResponseDto;
import com.jo.picPublising.business.mapping.CustomUserMapper;
import com.jo.picPublising.business.service.Auth;
import com.jo.picPublising.exception.ObjectNotFoundException;
import com.jo.picPublising.persistance.models.ERoles;
import com.jo.picPublising.persistance.models.Roles;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.persistance.repo.RolesRepo;
import com.jo.picPublising.persistance.repo.UserRepo;
import com.jo.picPublising.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationImp implements Auth {


    public final CustomUserMapper customUserMapper;
    public final UserRepo userRepo;
    public final RolesRepo rolesRepo;
    public final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;
    public final UserDetailsService userDetailsService;
    public final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public ResponseDto SignUp(UserDto userDto) {
        String message = "";
        Object data = null;

        if(userRepo.existsUserByEmail(userDto.getEmail())){
            message = "User is Already Exist";
        }else{
            User user = customUserMapper.DtoToUser(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Set<Roles> roles = new HashSet<>();
            Roles newRole =rolesRepo.findRolesByRole(ERoles.ROLE_USER).orElseThrow(() -> new ObjectNotFoundException("Roles not found"));
            roles.add(newRole);
            user.setRoles(roles);
            userRepo.save(user);
            message = "User Saved Successfully";
            data = userDto;
        }
        return new ResponseDto(200,message,data,true);
    }

    @Override
    public ResponseDto Login(LogInDto logInDto) {
        String message = "";
        Object data = null;

        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInDto.getEmail(),
                        logInDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        data = jwtService.generateToken(userDetailsService.loadUserByUsername(logInDto.getEmail()));
        message = "User Login Successfully";
        return new ResponseDto(200,message, data,true);
    }
}
