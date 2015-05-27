package com.hadeslee.androidex;

import android.app.Activity;
import android.os.*;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    final static String TAG = "MainActivity";

    private int mainNum;
    private int secondNum;
    private TextView tvMain, tvSecond;
    private Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tv_main_thead);
        tvSecond = (TextView) findViewById(R.id.tv_second_thread);
        btnStart = (Button) findViewById(R.id.bt_start);

        btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startNum();
            }
        });
    }

    private void startNum() {
        mainNum++;
        tvMain.setText("mainNum : " + mainNum);

        NewThread newThread = new NewThread(mainHandler, secondNum);
        newThread.setDaemon(true);
        newThread.start();

    }

    Handler mainHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == NewThread.NEWTHREAD_WHAT) {
                secondNum = msg.arg1;
                tvSecond.setText("secondNum : " + secondNum);
                Log.i(TAG, "secondNum in handler : " + secondNum);
            }
        }
    };

/*    class NewThread extends Thread {
        @Override
        public void run() {
            while (true) {
                secondNum++;
                Log.i(TAG, "secondNum in handler : " + secondNum);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvSecond.setText("secondNum : " + secondNum);
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
*//*                Message msg = Message.obtain();
                msg.what = 0;
                msg.arg1 = 0;
                msg.arg2 = 0;
                msg.obj = null;
                mainHandler.sendMessage(msg);*//*

            }
        }
    }*/

/*    class SecondRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                secondNum++;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        }
    }*/

/*    class NewThread extends Thread {
        @Override
        public void run() {
            while (true) {
                secondNum++;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
