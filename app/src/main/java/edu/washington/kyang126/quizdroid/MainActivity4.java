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


public class MainActivity4 extends ActionBarActivity {
    static final String STATE_q1 = "quiz1";
    private static int answerSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);
        Intent launchedMe = getIntent();
        int score =launchedMe.getIntExtra("answer", 0);

        if(savedInstanceState != null){
            answerSum = savedInstanceState.getInt(STATE_q1);;
        } else{
            answerSum += score;
        }

        int questions =launchedMe.getIntExtra("questionTotal", 0);
        String correctAnswer =launchedMe.getStringExtra("correct");
        String selectedAnswer =launchedMe.getStringExtra("selected");
        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText("You have " + answerSum + " out of " + questions + " correct");
        TextView selected = (TextView)findViewById(R.id.textView14);
        selected.setText("Selected answer: " + selectedAnswer);
        TextView correct = (TextView)findViewById(R.id.textView15);
        correct.setText("Correct answer: " + correctAnswer);
        final int newA = launchedMe.getIntExtra("newActivity", 0);
        final Button b = (Button) findViewById(R.id.button4);
        if (newA == 7 || newA == 10 || newA == 13) {
            answerSum = 0;
            b.setText("Finish");
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            Intent nextActivity = new Intent(MainActivity4.this, MainActivity5.class);
            if (newA == 5) {
                nextActivity = new Intent(MainActivity4.this, MainActivity5.class);
            } else if (newA == 6){
                nextActivity = new Intent(MainActivity4.this, MainActivity6.class);
            } else if (newA == 8){
                nextActivity = new Intent(MainActivity4.this, MainActivity8.class);
            }else if (newA == 9){
                nextActivity = new Intent(MainActivity4.this, MainActivity9.class);
            } else if (newA == 11){
                nextActivity = new Intent(MainActivity4.this, MainActivity11.class);
            } else if (newA == 12){
                nextActivity = new Intent(MainActivity4.this, MainActivity12.class);
            } else if (newA == 7 || newA == 10 || newA == 13){

                nextActivity = new Intent(MainActivity4.this, MainActivity.class);
            }
            nextActivity.putExtra("questionTotal", 1);
            startActivity(nextActivity);
            finish();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_q1, answerSum);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
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
