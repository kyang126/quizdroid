package edu.washington.kyang126.quizdroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class preferences extends ActionBarActivity {

    private int count;
    private PendingIntent pendingIntent;
    private int time;
    private boolean alarmUp;
    private EditText getUrl;
    private EditText getTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        getUrl = (EditText) this.findViewById(R.id.editText);
        getTime = (EditText) this.findViewById(R.id.editText2);
        loadSavedPreferences();

        final Button startButton = (Button) this.findViewById(R.id.button);
        count = 0;
        /* Retrieve a PendingIntent that will perform a broadcast */
        final Intent alarmIntent = new Intent(preferences.this, AlarmReceiver.class);

        alarmUp = (PendingIntent.getBroadcast(preferences.this, 0, alarmIntent,PendingIntent.FLAG_NO_CREATE) != null);

        if (alarmUp)
        {
            startButton.setText("Stop");
        }

      startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!getTime.getText().toString().matches("") && !getUrl.getText().toString().matches("")){

                    try {
                        time = Integer.parseInt(getTime.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Please input a valid numbers", Toast.LENGTH_SHORT).show();
                    }

                }

                if (time > 0 || alarmUp ) {
                    count++;
                    //create the toast object, set display duration,
                    alarmIntent.putExtra("url", getUrl.getText().toString());
                    pendingIntent = PendingIntent.getBroadcast(preferences.this, 0, alarmIntent, 0);

                    startButton.setText("Stop");

                    if (count == 1 && time > 0 && !alarmUp){

                        start();
                    }else if (count == 2 || alarmUp){
                        cancel();
                        count = 0;
                        startButton.setText("Start");
                        alarmUp = false;
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "Check your input values again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        getUrl.setText(sharedPreferences.getString("getUrl",""));
        getTime.setText(sharedPreferences.getString("getTime",""));

    }
    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public void saveData(){
        savePreferences("getUrl", getUrl.getText().toString());
        savePreferences("getTime", getTime.getText().toString());
    }
    @Override
    public void onBackPressed(){
        saveData();
        super.onBackPressed();
    }




    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = time * 1000 * 60;
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();

    }


    public void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        pendingIntent.cancel();
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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
        if (id == R.id.preferences) {
            startActivity(new Intent(this, preferences.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
