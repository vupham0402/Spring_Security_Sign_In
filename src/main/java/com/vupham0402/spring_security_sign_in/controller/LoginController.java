package com.vupham0402.spring_security_sign_in.controller;

import com.google.gson.Gson;
import com.vupham0402.spring_security_sign_in.jwt.JwtTokenHelper;
import com.vupham0402.spring_security_sign_in.payload.response.DataTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.vupham0402.spring_security_sign_in.payload.request.SignInRequest;
import com.vupham0402.spring_security_sign_in.payload.response.DataResponse;
import com.vupham0402.spring_security_sign_in.service.LoginService;

import javax.validation.Valid;

@RestController
@RequestMapping("/signin")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    //Define logger
    //Logger logger = LoggerFactory.getLogger(LoginController.class);

    private long expiredDate = 8 * 60 * 60 * 1000;
    private long refreshExpiredDate = 80 * 60 * 60 * 1000;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @PostMapping("")
    public ResponseEntity<?> signin(@Valid @RequestBody SignInRequest request) {
        Gson gson = new Gson();
        //logger.info(gson.toJson(request));
        //boolean isSuccess = loginService.checkLogin(request.getEmail(), request.getPassword());
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication auth = authenticationManager.authenticate(authRequest);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);

        String token = jwtTokenHelper.generateToken(request.getEmail(),"authen", expiredDate);
        String refreshToken = jwtTokenHelper.generateToken(request.getEmail(),"refresh", refreshExpiredDate);
        String decodeToken = jwtTokenHelper.decodeToken(token);
        DataTokenResponse dataTokenResponse = new DataTokenResponse();
        dataTokenResponse.setToken(token);
        dataTokenResponse.setRefreshToken(refreshToken);

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatus(HttpStatus.OK.value());
        dataResponse.setSuccess(true);
        dataResponse.setDesc("");
        dataResponse.setDesc(decodeToken);
        //dataResponse.setData(token);
        dataResponse.setData(dataTokenResponse);
        //dataResponse.setData("");

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
