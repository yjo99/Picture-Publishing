package com.jo.picPublising.business.service;

import com.jo.picPublising.business.dto.request.LogInDto;
import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.dto.response.ResponseDto;

public interface Authentication {

     ResponseDto SignUp(UserDto userDto);
     ResponseDto Login(LogInDto logInDto);

}
