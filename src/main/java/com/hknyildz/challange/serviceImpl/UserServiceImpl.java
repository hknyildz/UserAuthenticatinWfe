package com.hknyildz.challange.serviceImpl;

import com.hknyildz.challange.Entity.UserEntity;
import com.hknyildz.challange.dao.IUserDao;
import com.hknyildz.challange.dto.UserDto;
import com.hknyildz.challange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserEntity createUser(UserDto userDto) throws Exception {

        UserEntity userEntity = null;
        if (userDao.findByEmail(userDto.getEmail()) == null) {
            userEntity = new UserEntity();
            userEntity.setFirstName(userDto.getFirstName());
            userEntity.setLastName(userDto.getLastName());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setRole("USER");
            userEntity.setPassword(userDto.getPassword());

            String password = userDto.getPassword();

            userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
        } else {
            throw new Exception("This email is already exist");
        }

        return userDao.createUser(userEntity);
    }
}
