package com.financial.exception;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage, Throwable err){
        super(errorMessage,err);
    }

}
