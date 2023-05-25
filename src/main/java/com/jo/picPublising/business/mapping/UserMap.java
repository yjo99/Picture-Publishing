package com.jo.picPublising.business.mapping;


import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.persistance.models.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring" )
@Component
public interface UserMap {
    public User DtoToEntity(UserDto userDto);
    public UserDto EntityToDto(User user);
}
