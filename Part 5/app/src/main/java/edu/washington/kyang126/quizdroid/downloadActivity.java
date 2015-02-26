package edu.washington.kyang126.quizdroid;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class downloadActivity extends Activity implements View.OnClickListener {

    private DownloadManager dm;
    String Download_ID = "DOWNLOAD_ID";
    SharedPreferences preferenceManager;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        preferenceManager = PreferenceManager.getDefaultSharedPreferences(this);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {


                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(preferenceManager.getLong(Download_ID, 0));
                Cursor cursor = dm.query(query);

                if(cursor.moveToFirst()){
                    int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                    int status = cursor.getInt(columnIndex);
                    int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
                    int reason = cursor.getInt(columnReason);

                    if(status == DownloadManager.STATUS_SUCCESSFUL){
                        //Retrieve the saved download id
                        String JSONString = null;
                        JSONObject JSONObject = null;
                        try {
                            File path = Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_DOWNLOADS);
                            File file = new File(path, "quizdata.json");

                            //open the inputStream to the file
                            InputStream inputStream = new FileInputStream(file);

                            int sizeOfJSONFile = inputStream.available();

                            //array that will store all the data
                            byte[] bytes = new byte[sizeOfJSONFile];

                            //reading data into the array from the file
                            inputStream.read(bytes);

                            //close the input stream
                            inputStream.close();

                            JSONString = new String(bytes, "UTF-8");
                            JSONArray questions = new JSONArray(JSONString);
                            String element = questions.getString(0);
                            Log.i("jsontest", element);
                           // Log.i("json", "this succeeded");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        catch (JSONException x) {
                            x.printStackTrace();
                        }

                    }else if(status == DownloadManager.STATUS_FAILED){
                        Toast.makeText(downloadActivity.this,
                                "FAILED!\n" + "reason of " + reason,
                                Toast.LENGTH_LONG).show();
                    }else if(status == DownloadManager.STATUS_PAUSED){
                        Toast.makeText(downloadActivity.this,
                                "PAUSED!\n" + "reason of " + reason,
                                Toast.LENGTH_LONG).show();
                    }else if(status == DownloadManager.STATUS_PENDING){
                        Toast.makeText(downloadActivity.this,
                                "PENDING!",
                                Toast.LENGTH_LONG).show();
                    }else if(status == DownloadManager.STATUS_RUNNING){
                        Toast.makeText(downloadActivity.this,
                                "RUNNING!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    public void onClick(View view) {
        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://tednewardsandbox.site44.com/questions.json"));

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle("quizdata")
                .setDescription("Quiz Data for application")
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
                        "quizdata.json");

        long download_id = dm.enqueue(request);
        //Save the download id
        SharedPreferences.Editor PrefEdit = preferenceManager.edit();
        PrefEdit.putLong(Download_ID, download_id);
        PrefEdit.commit();
    }


    public void showDownload(View view) {
        Intent i = new Intent();
        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
        startActivity(i);
    }
}
