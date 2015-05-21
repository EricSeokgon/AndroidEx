package com.hadeslee.androidex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends Activity {

    //ArrayList<String> data = null;
    //ArrayAdapter<String> adapter = null;
    //private WeatherAdapter adapter = null;
    //private ListView lv = null;
    ArrayAdapter<CharSequence> adapter = null;
    Spinner spinner = null;

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

        //setContentView(R.layout.adapter_layout);
        //lv = (ListView) findViewById(R.id.lv_01);

        //lv.setAdapter(adapter);

        // setContentView(R.layout.adapter_layout);
        // adapter = ArrayAdapter.createFromResource(this, R.array.weather, android.R.layout.simple_list_item_checked);

        /*data = new ArrayList<Weather>();
        data.add(new Weather("월", R.drawable.w_icon_01, "맑음"));
        data.add(new Weather("화", R.drawable.w_icon_02, "흐림"));
        data.add(new Weather("수", R.drawable.w_icon_03, "흐림/비"));
        data.add(new Weather("목", R.drawable.w_icon_04, "비"));
        data.add(new Weather("금", R.drawable.w_icon_02, "흐림"));
        data.add(new Weather("토", R.drawable.w_icon_01, "맑음"));
        data.add(new Weather("일", R.drawable.w_icon_03, "흐림/비"));

        adapter = new WeatherAdapter(MainActivity.this, R.layout.custom_layout, data);

        lv = (ListView) findViewById(R.id.lv_weather);
        lv.setAdapter(adapter);*/

        //lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //lv.setDivider(new ColorDrawable(Color.GREEN));
        //lv.setDividerHeight(3);

        /*//ListActivity
        data = new ArrayList<String>();
        data.add("월");
        data.add("화");
        data.add("수");
        data.add("목");
        data.add("금");
        data.add("토");
        data.add("일");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);*/

        setContentView(R.layout.activity_main);

        adapter = ArrayAdapter.createFromResource(this, R.array.travelArea, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.sp_01);
        spinner.setPrompt(getString(R.string.travel_select));
        spinner.setAdapter(adapter);

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
