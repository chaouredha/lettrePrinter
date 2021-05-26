package com.rcfactory.lp.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = BAD_REQUEST)
public class LPMendatoryDataException extends RuntimeException {
    public LPMendatoryDataException(String message) {
        super(message);
    }
}
