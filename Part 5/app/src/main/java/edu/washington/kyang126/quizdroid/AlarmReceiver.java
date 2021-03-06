package edu.washington.kyang126.quizdroid;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kevin on 2/22/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {
    private DownloadManager dm;
    String Download_ID = "DOWNLOAD_ID";
    SharedPreferences preferenceManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        final String url = intent.getStringExtra("url");

        Toast.makeText(context, url, Toast.LENGTH_SHORT).show();
        preferenceManager = PreferenceManager.getDefaultSharedPreferences(context);
        final Context c= context;
        try{
            dm = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                    | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle("quizdatatest3.json")
                    .setDescription("Quiz Data for application")
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
                            "quizdatatest3.json");

            long download_id = dm.enqueue(request);
            //Save the download id
            SharedPreferences.Editor PrefEdit = preferenceManager.edit();
            PrefEdit.putLong(Download_ID, download_id);
            PrefEdit.commit();
            Log.i("alarm", "it works");


            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(preferenceManager.getLong(Download_ID, 0));
            Cursor cursor = dm.query(query);




            if(cursor.moveToFirst()){
                int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int status = cursor.getInt(columnIndex);
                int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
                int reason = cursor.getInt(columnReason);


                if(status == DownloadManager.STATUS_SUCCESSFUL){



                }else if(status == DownloadManager.STATUS_FAILED){
                    Toast.makeText(context,
                            "FAILED!\n" + "reason of " + reason,
                            Toast.LENGTH_LONG).show();
                }else if(status == DownloadManager.STATUS_PAUSED){
                    Toast.makeText(context,
                            "PAUSED!\n" + "reason of " + reason,
                            Toast.LENGTH_LONG).show();
                }else if(status == DownloadManager.STATUS_PENDING){
                    Toast.makeText(context,
                            "PENDING!",
                            Toast.LENGTH_LONG).show();
                }else if(status == DownloadManager.STATUS_RUNNING){
                    Toast.makeText(context,
                            "RUNNING!",
                            Toast.LENGTH_LONG).show();
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(context,
                    "Make sure it is a valid URL",
                    Toast.LENGTH_LONG).show();
        }

    }

}
