package com.pedro.utils.exception;

import javax.ws.rs.core.Response;

public enum ErrorCode {
    USER_NOT_FOUND("User not found", Response.Status.BAD_REQUEST.getStatusCode()),
    USER_EMAIL_ALREADY_EXISTS("User with email already exists", Response.Status.BAD_REQUEST.getStatusCode()),
    USER_NIF_ALREADY_EXISTS("User with NIF already exists", Response.Status.BAD_REQUEST.getStatusCode()),
    USER_CC_ALREADY_EXISTS("User with CC already exists", Response.Status.BAD_REQUEST.getStatusCode()),
    ANIMAL_NOT_FOUND("Animal not found", Response.Status.BAD_REQUEST.getStatusCode()),
    VALUE_OF_ENUM("Value provided not allowed", Response.Status.BAD_REQUEST.getStatusCode());

    private final String message;
    private final int httpStatusCode;

    ErrorCode(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }


    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
