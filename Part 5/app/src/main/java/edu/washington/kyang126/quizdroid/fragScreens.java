package edu.washington.kyang126.quizdroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class fragScreens extends ActionBarActivity implements Communicator  {
    String topic;
    private int totalScore;
    private static int[] answerTotal = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_screens);
        Intent launchedMe = getIntent();
        topic =launchedMe.getStringExtra("topic");

        String description =launchedMe.getStringExtra("description");
        Bundle bundle = new Bundle();
        bundle.putString("topic", topic);
        bundle.putString("description", description);

        // set Fragmentclass Arguments
        Fragment fragobj = new fragment1();
        fragobj.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
       // ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        ft.add(R.id.frag2, fragobj);
        //ft.replace(R.id.frag2, fragobj);
        ft.commit();
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frag_screens, menu);
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

    @Override
    public void respond(int questionNumber, String topic) {
        setContentView(R.layout.activity_frag_screens);
        Bundle bundle = new Bundle();
        bundle.putInt("questionNumber", questionNumber);
        bundle.putString("topic", topic);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragobj = new questionFragment();
        fragobj.setArguments(bundle);
        ft.add(R.id.frag2, fragobj);
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        ft.commit();
    }

    @Override
    public void respondSummary(int questionNumber, int points, String selected, String answer) {
        setContentView(R.layout.activity_frag_screens);

        totalScore = 0;
        answerTotal[questionNumber-1] = points;
        for (int i = 0; i < questionNumber; i++){
            totalScore += answerTotal[i];
        }

        Bundle bundle = new Bundle();
        bundle.putInt("questionNumber", questionNumber);
        bundle.putInt("points", totalScore);

        bundle.putString("topic", topic);
        bundle.putString("selected", selected);
        bundle.putString("answer", answer);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragobj = new summaryFragment();
        fragobj.setArguments(bundle);
        ft.add(R.id.frag2, fragobj);
        ft.commit();
    }
}
