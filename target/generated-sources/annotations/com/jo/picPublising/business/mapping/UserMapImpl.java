package com.jo.picPublising.business.mapping;

import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.persistance.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T08:49:25+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapImpl implements UserMap {

    @Override
    public User DtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserName( userDto.getUserName() );
        user.setEmail( userDto.getEmail() );
        user.setAddress( userDto.getAddress() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserDto EntityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.userName( user.getUserName() );
        userDto.email( user.getEmail() );
        userDto.address( user.getAddress() );
        userDto.password( user.getPassword() );

        return userDto.build();
    }
}
