package com.airlinemanagementsystem.exception;

public class UnAuthorisedAdminException extends Exception{
    public UnAuthorisedAdminException() {
        super();
    }

    public UnAuthorisedAdminException(String message) {
        super(message);
    }
}
