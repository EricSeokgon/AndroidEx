package com.hadeslee.androidex;

import android.os.*;


/**
 * Created by sklee on 2015-05-27.
 */
public class NewThread extends Thread {
    final static int NEWTHREAD_WHAT = 0;

    private Handler mHandler;
    private int secondNum;

    public NewThread(Handler h, int sn) {
        this.mHandler = h;
        this.secondNum = sn;
    }

    @Override
    public void run() {

        while (true) {
            secondNum++;
            Message msg = Message.obtain();
            msg.what = NEWTHREAD_WHAT;
            msg.arg1 = secondNum;
            mHandler.sendMessage(msg);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

    }
}

