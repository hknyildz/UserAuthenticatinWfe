package com.hknyildz.challange.service;

import com.hknyildz.challange.Entity.UserEntity;
import com.hknyildz.challange.dto.UserDto;

public interface IUserService {
    UserEntity createUser(UserDto userDto) throws Exception;
}
