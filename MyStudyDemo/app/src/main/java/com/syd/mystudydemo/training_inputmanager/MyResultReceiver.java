package com.syd.mystudydemo.training_inputmanager;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by sydMobile on 2018/5/3.
 */

public class MyResultReceiver extends ResultReceiver {
    private Receiver mReceiver;

    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public MyResultReceiver(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        if (mReceiver != null) {

            mReceiver.onReceiveResult(resultCode, resultData);
        }

    }

    public void setmReceiver(Receiver receiver) {
        this.mReceiver = receiver;
    }

    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }
}
