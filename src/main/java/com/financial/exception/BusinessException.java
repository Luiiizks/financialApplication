package com.financial.exception;


import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage){
        super(errorMessage);
    }

}
