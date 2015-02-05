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

import java.util.ArrayList;


public class summaryView extends ActionBarActivity {
    static final String STATE_q1 = "quiz1";
    private int totalScore;
    private static int[] answerTotal = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        Intent launchedMe = getIntent();
        int score = launchedMe.getIntExtra("answer", 0);
        int questions = launchedMe.getIntExtra("questionTotal", 0);
        final int q = questions;
        Log.i("check sum: ", ""+answerTotal.length);
        if(savedInstanceState != null){
            totalScore = savedInstanceState.getInt(STATE_q1);
        } else {
            answerTotal[q-1] = score;
        }

        totalScore = 0;

        for (int i = 0; i < q; i++){

            totalScore += answerTotal[i];
        }

        String correctAnswer =launchedMe.getStringExtra("correct");
        String selectedAnswer =launchedMe.getStringExtra("selected");
        final String topic =launchedMe.getStringExtra("topic");

        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText("You have " + totalScore + " out of " + questions + " correct");
        TextView selected = (TextView)findViewById(R.id.textView14);
        selected.setText("Selected answer: " + selectedAnswer);
        TextView correct = (TextView)findViewById(R.id.textView15);
        correct.setText("Correct answer: " + correctAnswer);
        final Button b = (Button) findViewById(R.id.button4);
        if (q == 3) {
            b.setText("Finish");
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            Intent nextActivity = new Intent(summaryView.this, questionView.class);
            if (q == 1){
                nextActivity.putExtra("order", "second");
            } else if (q == 2){
                nextActivity.putExtra("order", "third");
            } else if (q == 3){
                nextActivity = new Intent(summaryView.this, selectQuizView.class);
            }
            nextActivity.putExtra("topic", topic);
            startActivity(nextActivity);
            //finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_q1, totalScore);
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
