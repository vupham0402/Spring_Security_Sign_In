package com.vupham0402.spring_security_sign_in.exception.advice;

import com.google.gson.Gson;
import com.vupham0402.spring_security_sign_in.exception.DeviceZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.vupham0402.spring_security_sign_in.payload.response.DataResponse;

@ControllerAdvice
public class DeviceZeroAdviceController {
    //Logger logger = LoggerFactory.getLogger(DeviceZeroAdviceController.class);
    private Gson gson = new Gson();
    @ExceptionHandler({DeviceZeroException.class, RuntimeException.class})
    public ResponseEntity<?> handDeviceZeroException(Exception e){
        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        dataResponse.setDesc("Error! " + e.getMessage());

        //logger.error(gson.toJson(dataResponse));

        return new ResponseEntity<>(dataResponse, HttpStatus.ACCEPTED.OK);
    }
}
