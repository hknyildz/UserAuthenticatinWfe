package com.hknyildz.challange.dao;

import com.hknyildz.challange.Entity.UserEntity;

public interface IUserDao {
    UserEntity findByEmail(String email);

    UserEntity createUser(UserEntity user);
}
