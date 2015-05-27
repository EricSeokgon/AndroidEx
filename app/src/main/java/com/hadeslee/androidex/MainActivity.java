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


    TextView tv;
    Button btn01;
    NewAsyncTask newAsynTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_01);
        btn01 = (Button) findViewById(R.id.bt_01);
        btn01.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_01:
                    newAsynTask = new NewAsyncTask(MainActivity.this, tv);
                    newAsynTask.execute(100, 50);
                    break;

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
