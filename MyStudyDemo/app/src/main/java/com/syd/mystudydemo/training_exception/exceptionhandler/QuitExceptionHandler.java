package com.syd.mystudydemo.training_exception.exceptionhandler;

/**
 * Created by Administrator on 2017/12/21.
 */

public class QuitExceptionHandler extends RuntimeException {
    public QuitExceptionHandler(String message) {
        super(message);
    }
}
