package edu.washington.kyang126.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class MainActivity11 extends ActionBarActivity implements View.OnClickListener {
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity11);
        b = (Button) findViewById(R.id.button10);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton29);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton30);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton31);
        final RadioButton r4 = (RadioButton) findViewById(R.id.radioButton32);

        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);

        b.setVisibility(View.INVISIBLE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                Intent nextActivity = new Intent(MainActivity11.this, MainActivity4.class);
                if(r1.isChecked() ||r2.isChecked()||r3.isChecked()||r4.isChecked()) {
                    if (r1.isChecked()){
                        nextActivity.putExtra("answer", 1);
                    }else{
                        nextActivity.putExtra("answer", 0);
                    }
                    nextActivity.putExtra("questionTotal", 2);
                    nextActivity.putExtra("newActivity", 12);
                    startActivity(nextActivity);
                    finish();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        b.setVisibility(View.VISIBLE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity11, menu);
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
