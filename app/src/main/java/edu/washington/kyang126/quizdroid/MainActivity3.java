package edu.washington.kyang126.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;


public class MainActivity3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        Intent launchedMe = getIntent();
        final String topic =launchedMe.getStringExtra("topic");

        String description =launchedMe.getStringExtra("description");
        TextView tv = (TextView)findViewById(R.id.secondScreen);
        tv.setText("Topic Overview: " + topic);
        TextView desc = (TextView)findViewById(R.id.textView);
        desc.setText("Description: " + description);

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            Intent nextActivity = new Intent(MainActivity3.this, MainActivity2.class);
            if(topic.equals("Math")) {
                nextActivity.putExtra("topic", "Math");
            } else if (topic.equals("Physics")){
                nextActivity.putExtra("topic", "Physics");
            } else if (topic.equals("Marvel Super Heroes")){
                nextActivity.putExtra("topic", "Marvel Super Heroes");
            }
             nextActivity.putExtra("order", "first");
            startActivity(nextActivity);
            finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
