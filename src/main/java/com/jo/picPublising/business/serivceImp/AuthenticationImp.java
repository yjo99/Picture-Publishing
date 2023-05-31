package com.jo.picPublising.business.serivceImp;

import com.jo.picPublising.business.dto.request.LogInDto;
import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.dto.response.ResponseDto;
import com.jo.picPublising.business.mapping.UserMap;
import com.jo.picPublising.business.service.Authentication;
import com.jo.picPublising.exception.ObjectNotFoundException;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.persistance.repo.UserRepo;
import com.jo.picPublising.security.jwt.JwtService;
import com.jo.picPublising.security.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationImp implements Authentication {

    public final UserMap userMap;
    public final UserRepo userRepo;
    public final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;
    public final UserDetailsService userDetailsService;
    public final AuthenticationManager authenticationManager;

    @Override
    public ResponseDto SignUp(UserDto userDto) {
        String message = "";
        Object data = null;

        if(userRepo.existsUserByEmail(userDto.getEmail())){
            message = "User is Already Exist";
        }else{
            User user = userMap.DtoToEntity(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInDto.getEmail(),
                        logInDto.getPassword()
                )
        );

        data = jwtService.generateToken(userDetailsService.loadUserByUsername(logInDto.getEmail()));
        message = "User Login Successfully";
        return new ResponseDto(200,message, data,true);
    }
}
