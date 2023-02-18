package com.vupham0402.spring_security_sign_in.service;

import com.vupham0402.spring_security_sign_in.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vupham0402.spring_security_sign_in.repository.UserRepository;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkLogin(String email, String password) {

        List<UserEntity> users = userRepository.findByEmailAndPassword(email, password);
        return users.size() > 0;
    }

    @Override
    public UserEntity checkLogin(String email) {
        List<UserEntity> users = userRepository.findByEmail(email);
        return users.size() > 0 ? users.get(0) : null;
    }
}
