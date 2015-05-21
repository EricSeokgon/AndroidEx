package com.hadeslee.androidex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    private int[] data = {R.drawable.s01, R.drawable.s02,
            R.drawable.s03, R.drawable.s04, R.drawable.s05};

    private CustomAdapter adapter = null;
    private GridView gv;

    private LinearLayout ll;
    private ImageView[] ivs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter(this, data);
        gv = (GridView) findViewById(R.id.gv_01);
        gv.setAdapter(adapter);

        ll = (LinearLayout) findViewById(R.id.ll_01);
        ivs = new ImageView[5];

        for (int i = 0; i < 5; i++) {
            ivs[i] = new ImageView(this);
            ivs[i].setImageResource(data[i]);
            ll.addView(ivs[i]);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
