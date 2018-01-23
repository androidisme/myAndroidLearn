package com.syd.mystudydemo.training_exception;

import android.app.Application;

/**
 * Created by Administrator on 2018/1/22.
 */

public class ExceptionBusinessImpl {
    public static ExceptionBusinessImpl exceptionBusiness;
    Application myApplication;

    private ExceptionBusinessImpl(Application application) {
        this.myApplication = application;
    }

    public static synchronized ExceptionBusinessImpl getInstance() {

        return exceptionBusiness;
    }
}
