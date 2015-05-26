package com.hadeslee.androidex;



import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

import com.hadeslee.androidex.util.Constant;

public class ThirdActivity extends Activity {

	final static String TAG = "ThirdActivity";
	
	final static int LOG_IN_OK = 0;
	final static int LOG_IN_NG = 1;
	
	TextView tv = null;
	Button btn = null;
	
	boolean loginFlag = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		tv = (TextView) findViewById(R.id.tv_third);
		btn = (Button) findViewById(R.id.bt_go_main);
		btn.setOnClickListener(listener);
		
		Intent intent = getIntent();
		String u_id = intent.getStringExtra("u_id");
		int u_pw = intent.getIntExtra("u_pw", 0);
		if(Constant.DEBUG_MODE) {
			Log.i(TAG, "u_id : " + u_id);
			Log.i(TAG, "u_pw : " + u_pw);
		}
		
		tv.setText("u_id : " + u_id + ", u_pw : " + u_pw);
		
		if(u_id.equals("abc") && u_pw == 1234) {
			loginFlag = true;
		} else {
			loginFlag = false;
		}
		if(Constant.DEBUG_MODE) Log.i(TAG, "loginFlag : " + loginFlag);
		
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.bt_go_main:
				
				Intent intent = new Intent();
				intent.putExtra("user_info", tv.getText().toString());
				if(loginFlag) {
					setResult(ThirdActivity.LOG_IN_OK, intent);
				} else {
					setResult(ThirdActivity.LOG_IN_NG, intent);
				}
				finish();
				
				break;
			}
		}
	};
	
}
