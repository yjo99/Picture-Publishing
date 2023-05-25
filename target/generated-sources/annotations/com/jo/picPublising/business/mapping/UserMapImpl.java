package com.jo.picPublising.business.mapping;

import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.persistance.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T11:41:30+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapImpl implements UserMap {

    @Override
    public User DtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userName( userDto.getUserName() );
        user.email( userDto.getEmail() );
        user.address( userDto.getAddress() );
        user.password( userDto.getPassword() );

        return user.build();
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
