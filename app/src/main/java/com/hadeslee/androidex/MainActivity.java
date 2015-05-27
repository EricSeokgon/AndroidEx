package com.hadeslee.androidex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

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

        //NewThread newThread = new NewThread();
        SecondRunnable runnable = new SecondRunnable();
        Thread newThread = new Thread(runnable);
        newThread.setDaemon(true);
        newThread.start();

        tvMain.setText("mainNum : " + mainNum);
        tvSecond.setText("secondNum : " + secondNum);

    }

    class SecondRunnable implements Runnable {
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
    }

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
