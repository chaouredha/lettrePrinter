package com.rcfactory.lp.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = BAD_REQUEST)
public class LPException extends RuntimeException {
    public LPException(String message) {
        super(message);
    }
}
