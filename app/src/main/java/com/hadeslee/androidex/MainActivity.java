package com.hadeslee.androidex;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends ActionBarActivity {

	final static int USER_INFO = 0;
	
	TextView tv = null;
	Button btnGoSecond = null;
	Button btnGoThird = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.tv_main);
		btnGoSecond = (Button) findViewById(R.id.bt_go_second);
		btnGoSecond.setOnClickListener(listener);

		btnGoThird = (Button) findViewById(R.id.bt_go_third);
		btnGoThird.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = null;
			
			switch (v.getId()) {
			case R.id.bt_go_second:

				intent = new Intent(MainActivity.this,
						SecondActivity.class);
				intent.putExtra("u_id", "abc");
				intent.putExtra("u_pw", 1234);
				startActivity(intent);
				break;

			case R.id.bt_go_third:

				intent = new Intent(MainActivity.this,
						ThirdActivity.class);
				intent.putExtra("u_id", "abcd");
				intent.putExtra("u_pw", 1234);
				startActivityForResult(intent, MainActivity.USER_INFO);
				break;
			}
			
		}
	};

	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {
		case MainActivity.USER_INFO:
			if (resultCode == ThirdActivity.LOG_IN_OK) {
				tv.setText("LogIn Success!, " + intent.getStringExtra("user_info"));
			} else if (resultCode == ThirdActivity.LOG_IN_NG){
				tv.setText("LogIn Fail!, " + intent.getStringExtra("user_info"));
			}
			break;
		}
	};
	
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
