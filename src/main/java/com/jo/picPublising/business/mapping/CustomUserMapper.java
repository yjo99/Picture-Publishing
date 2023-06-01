package com.jo.picPublising.business.mapping;

import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.exception.ObjectNotFoundException;
import com.jo.picPublising.persistance.models.ERoles;
import com.jo.picPublising.persistance.models.Roles;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.persistance.repo.RolesRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Data
@RequiredArgsConstructor
public class CustomUserMapper {
    private final RolesRepo rolesRepo;


    public User DtoToUser(UserDto userDto){

        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());

        Set<Roles> roles = new HashSet();



        for(String x : userDto.getRoles()){
            ERoles eroles = ERoles.valueOf(x);
            Roles role = rolesRepo.findRolesByRole(eroles).orElseThrow(() -> new ObjectNotFoundException("Role Not found"));
            roles.add(role);
        }

        user.setRoles(roles);

        return user;

    };


}
