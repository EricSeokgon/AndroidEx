package com.hadeslee.androidex;

import android.app.*;
import android.content.*;
import android.content.DialogInterface.OnClickListener;
import android.database.CursorJoiner.Result;
import android.os.*;
import android.util.*;
import android.widget.*;

/**
 * Created by sklee on 2015-05-27.
 */
public class NewAsyncTask extends AsyncTask<Integer, String, Integer> {

    final static String TAG = "NewAsyncTask";

    Context mContext = null;
    TextView mTv = null;
    ProgressDialog dialog = null;
    boolean cancelFlag = false;

    public NewAsyncTask(Context c, TextView t) {
        this.mContext = c;
        this.mTv = t;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("Dialog");
        dialog.setMessage("work start");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                cancelFlag = true;
                cancel(true);
            }
        });
        dialog.setProgress(0);
        dialog.show();
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        // TODO Auto-generated method stub
        Log.i(TAG, "doInBackground()");
        Log.i(TAG, "params[0] : " + params[0]);
        Log.i(TAG, "params[1] : " + params[1]);

        for (int i = 0; i < params[0]; i++) {
            publishProgress(String.valueOf(i));
            try { Thread.sleep(200); } catch (Exception e) {}
            if(cancelFlag) break;
        }

        return params[0];
    }

    @Override
    protected void onProgressUpdate(String... values) {
        // TODO Auto-generated method stub
        Log.i(TAG, "onProgressUpdate()");

        int i = Integer.parseInt(values[0]);
        dialog.setProgress(i);
        mTv.setText(String.valueOf(i));
    }

    @Override
    protected void onPostExecute(Integer result) {
        // TODO Auto-generated method stub
        Log.i(TAG, "onPostExecute()");
        Log.i(TAG, "result : " + result);

        mTv.setText(String.valueOf(result));
        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onCancelled()");
        mTv.setText("Cancelled");
        dialog.dismiss();
    }

}
