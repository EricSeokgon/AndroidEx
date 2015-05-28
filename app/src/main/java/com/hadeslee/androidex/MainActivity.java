package com.hadeslee.androidex;

import java.io.*;
import java.util.*;

import org.json.*;

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

        parser2();

    }

    private void parser() {
        Log.i(TAG, "parser()");

        InputStream is = getResources().openRawResource(R.raw.jsonex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Log.i(TAG, "sb : " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            String name = jsonObject.getString("name");
            Log.i(TAG, "name : " + name);
            int age = jsonObject.getInt("age");
            Log.i(TAG, "age : " + age);
            JSONArray jsonArray = jsonObject.getJSONArray("hobbys");
            for (int i = 0; i < jsonArray.length(); i++) {
                String hobby = jsonArray.getString(i);
                Log.i(TAG, "hobbys[" + i + "] : " + hobby);
            }
            JSONObject jsonObject2 = jsonObject.getJSONObject("info");
            int no = jsonObject2.getInt("no");
            Log.i(TAG, "no : " + no);
            String id = jsonObject2.getString("id");
            Log.i(TAG, "id : " + id);
            int pw = jsonObject2.getInt("pw");
            Log.i(TAG, "pw : " + pw);

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

    private void parser2() {
        Log.i(TAG, "parser()2");

        InputStream is = getResources().openRawResource(R.raw.jsonex2);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Log.i(TAG, "sb : " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                Log.i(TAG, "name : " + name);
                int age = jsonObject1.getInt("age");
                Log.i(TAG, "age : " + age);
                JSONArray jsonArray2 = jsonObject1.getJSONArray("hobbys");
                for (int j = 0; j < jsonArray2.length(); j++) {
                    String hobby = jsonArray2.getString(j);
                    Log.i(TAG, "hobbys[" + j + "] : " + hobby);
                }
                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                Log.i(TAG, "no : " + no);
                String id = jsonObject2.getString("id");
                Log.i(TAG, "id : " + id);
                int pw = jsonObject2.getInt("pw");
                Log.i(TAG, "pw : " + pw);
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
