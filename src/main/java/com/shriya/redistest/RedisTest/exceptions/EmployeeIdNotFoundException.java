package com.sreeraj.redistest.RedisTest.exceptions;

public class EmployeeIdNotFoundException extends Exception {
    public EmployeeIdNotFoundException(String message) {
        super(message);
    }
}
