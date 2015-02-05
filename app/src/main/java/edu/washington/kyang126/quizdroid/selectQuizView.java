package edu.washington.kyang126.quizdroid;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class selectQuizView extends ActionBarActivity {
GridView myGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGrid = (GridView)findViewById(R.id.gridView);

        String [] myQuizArray = {"Math", "Physics", "Marvel Super Heroes"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myQuizArray);
        myGrid.setAdapter(myAdapter);

        AdapterView.OnItemClickListener quizItemClicked = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent nextActivity = new Intent(selectQuizView.this, topicView.class);
                if (position == 0) {
                    nextActivity.putExtra("topic", "Math");
                    nextActivity.putExtra("description", "This quiz will be asking questions testing your knowledge on Math");
                }
                if (position == 1) {
                    nextActivity.putExtra("topic", "Physics");
                    nextActivity.putExtra("description", "This quiz will be asking questions testing your knowledge on Physics");
                }
                if (position == 2) {
                    nextActivity.putExtra("topic", "Marvel Super Heroes");
                    nextActivity.putExtra("description", "This quiz will be asking questions testing your knowledge on Marvel Super Heroes");
                }
                startActivity(nextActivity);
                //finish();
            }
        };

        myGrid.setOnItemClickListener(quizItemClicked);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

