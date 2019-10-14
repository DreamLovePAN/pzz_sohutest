package com.sohu.test.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户名不存在！");
    }
}
