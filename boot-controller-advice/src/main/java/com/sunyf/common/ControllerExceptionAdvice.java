package com.sunyf.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * @Description: 统一异常处理切面
 * @Author: sunyf
 * @Date: 2020/1/12 22:22
 */
@RestControllerAdvice("com.sunyf")
public class ControllerExceptionAdvice {
    final static Logger LOG = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        LOG.error("", e);
        return CommonResponse.serverError();
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object exceptionHandler(BindException e){
        //LOG.error("", e);
        String errorMessage = "";
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(";");
            }
            errorMessage = msgBuilder.toString();
            if(errorMessage.length()>1){
                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
            }
            LOG.error("参数校验异常:{}",errorMessage);
        }
        return CommonResponse.parameterError(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object exceptionHandler(MethodArgumentNotValidException e){
        //LOG.error("", e);
        String errorMessage = "";
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(";");
            }
            errorMessage = msgBuilder.toString();
            if(errorMessage.length()>1){
                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
            }
            LOG.error("参数校验异常:{}",errorMessage);
        }
        return CommonResponse.parameterError(errorMessage);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object exceptionHandler(BusinessException e){
        LOG.error("", e);
        return CommonResponse.setCodeAndMsg(e.getCode(), e.getMessage());
    }






}
