package com.hadeslee.androidex;

import java.util.*;

import android.content.*;
import android.view.*;
import android.widget.*;

public class WeatherAdapter extends BaseAdapter{

	private Context mContext = null;
	private int layout = 0;
	private ArrayList<Weather> data = null;
	private LayoutInflater inflater = null;
	
	public WeatherAdapter(Context c, int l, ArrayList<Weather> d) {
		this.mContext = c;
		this.layout = l;
		this.data = d;
		this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position).getDay();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null) {
			convertView = inflater.inflate(this.layout, parent, false);
		}
		
		TextView tv_day = (TextView) convertView.findViewById(R.id.tv_day);
		ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_weather);
		TextView tv_comment = (TextView) convertView.findViewById(R.id.tv_comment);
		Button bt_select = (Button) convertView.findViewById(R.id.bt_select);
		
		tv_day.setText(data.get(position).getDay() + " | ");
		iv_icon.setImageResource(data.get(position).getIcon());
		tv_comment.setText(data.get(position).getComment());
		
		if((position%2) == 1) {
			convertView.setBackgroundColor(0x5000ff00);
		} else {
			convertView.setBackgroundColor(0x2000ff00);
		}
		
		return convertView;
	}
	
}
