package com.vupham0402.spring_security_sign_in.service;

import com.vupham0402.spring_security_sign_in.entity.UserEntity;

public interface LoginService {
    boolean checkLogin(String email, String password);
    UserEntity checkLogin(String email);
}
