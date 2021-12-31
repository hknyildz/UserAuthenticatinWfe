package com.hknyildz.challange.daoImpl;

import com.hknyildz.challange.Entity.UserEntity;
import com.hknyildz.challange.dao.IUserDao;
import com.hknyildz.challange.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements IUserDao {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
}
