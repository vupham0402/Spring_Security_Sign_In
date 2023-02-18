package com.vupham0402.spring_security_sign_in.security;

import com.vupham0402.spring_security_sign_in.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.vupham0402.spring_security_sign_in.service.LoginService;

import java.util.ArrayList;

@Component
public class CustomAuthentProvider implements AuthenticationProvider {
    @Autowired
    LoginService loginService;

    //@Autowired
    //@Qualifer: define which bean will be get on container
    //PasswordEncoder passwordEncoder;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
//        System.out.println("Username: " + userName + " - Password: " +password);
//        boolean isSuccess = loginService.checkLogin(userName, password);
//        System.out.println("Check " + isSuccess);
//        if(isSuccess){
//            return new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
//        }
//        else {
//            return null;
//        }

        UserEntity userEntity = loginService.checkLogin(userName);

        if(userEntity != null){
            //System.out.println("Username " + userName + " " + "Password " + password + " " + userEntity.getPassword());
            boolean isMatchPassword = passwordEncoder.matches(password, userEntity.getPassword());
            //System.out.println(isMatchPassword);
            if(isMatchPassword){
                return new UsernamePasswordAuthenticationToken(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
            }
            else{
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
