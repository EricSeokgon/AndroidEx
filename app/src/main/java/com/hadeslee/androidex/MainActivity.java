package com.hadeslee.androidex;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        InputStream is = getResources().openRawResource(R.raw.xmlex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;

        XmlPullParserFactory factory = null;
        XmlPullParser xmlPullParser = null;
        try {

            factory = XmlPullParserFactory.newInstance();
            xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(reader);

            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.i(TAG, "Start Document");
                        break;

                    case XmlPullParser.START_TAG:
                        Log.i(TAG, "Start TAG : " + xmlPullParser.getName());

                        if (xmlPullParser.getName().equals("member")) {
                            int count = xmlPullParser.getAttributeCount();
                            for (int i = 0; i < count; i++) {
                                Log.i(TAG, "Start TAG AttributeName(" + i + ") : "
                                        + xmlPullParser.getAttributeName(i));
                                Log.i(TAG, "Start TAG AttributeValue(" + i + ") : "
                                        + xmlPullParser.getAttributeValue(i));
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        Log.i(TAG, "End TAG : " + xmlPullParser.getName());
                        break;

                    case XmlPullParser.TEXT:
                        Log.i(TAG, "TEXT : " + xmlPullParser.getText());
                        break;
                }

                eventType = xmlPullParser.next();

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
