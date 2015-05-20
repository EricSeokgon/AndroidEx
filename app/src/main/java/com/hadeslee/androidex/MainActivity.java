package com.hadeslee.androidex;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<String> arrayList = null;
    ArrayAdapter<CharSequence> adapter = null;
    ListView lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_relative_layout);
        //setContentView(R.layout.activity_frame_layout);
        //setContentView(R.layout.activity_table_layout);
        //setContentView(R.layout.calulator_layout);
        //CustomView customView = new CustomView(MainActivity.this);
        //setContentView(customView);
        //Toast.makeText(MainActivity.this,"First Toast", Toast.LENGTH_SHORT).show();

       /* setContentView(R.layout.adapter_layout);

        arrayList = new ArrayList<String>();
        arrayList.add("월");
        arrayList.add("화");
        arrayList.add("수");
        arrayList.add("목");
        arrayList.add("금");
        arrayList.add("토");
        arrayList.add("일");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        lv = (ListView) findViewById(R.id.lv_01);

        lv.setAdapter(adapter);*/

        setContentView(R.layout.adapter_layout);
        adapter = ArrayAdapter.createFromResource(this, R.array.weather, android.R.layout.simple_list_item_checked);

        lv = (ListView) findViewById(R.id.lv_01);
        lv.setAdapter(adapter);

        //lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setDivider(new ColorDrawable(Color.GREEN));
        lv.setDividerHeight(3);

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
