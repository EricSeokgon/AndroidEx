package com.hadeslee.androidex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


public class MainActivity extends Activity {

    private int[] data = {R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10,
            R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10,
            R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10
    };
    private CustomAdapter adapter = null;
    private GridView gv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter(this, data);

        gv = (GridView) findViewById(R.id.gv_01);
        gv.setAdapter(adapter);

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
