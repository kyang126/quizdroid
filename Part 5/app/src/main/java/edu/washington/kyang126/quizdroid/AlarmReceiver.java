package edu.washington.kyang126.quizdroid;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Kevin on 2/22/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String url = intent.getStringExtra("url");


        Toast.makeText(context, url, Toast.LENGTH_SHORT).show();



    }
}
