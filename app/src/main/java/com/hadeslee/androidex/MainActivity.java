package com.hadeslee.androidex;

import java.io.*;
import java.util.*;

import org.xmlpull.v1.*;

import android.os.*;
import android.support.v7.app.*;
import android.util.*;
import android.view.*;

public class MainActivity extends ActionBarActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();

    }

    private void parser() {
        Log.i(TAG, "parser()");

        InputStream is = getResources().openRawResource(R.raw.tokenex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;
        try {

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Log.i(TAG, "sb : " + sb.toString());

            String str = sb.toString();
            StringTokenizer tokenizer = new StringTokenizer(str, "|");
            Log.i(TAG, "Token count : " + tokenizer.countTokens());
            while(tokenizer.hasMoreElements()){
                String tokenStr = tokenizer.nextToken();
                Log.i(TAG, "Token string(|) : " + tokenStr);

                StringTokenizer tokenizer2 = new StringTokenizer(tokenStr, ",");
                Log.i(TAG, "Token count : " + tokenizer2.countTokens());
                while (tokenizer2.hasMoreElements()) {
                    String tokenStr2 = tokenizer2.nextToken();
                    Log.i(TAG, "Token string(,) : " + tokenStr2);
                }
                Log.i(TAG, "===============================================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
