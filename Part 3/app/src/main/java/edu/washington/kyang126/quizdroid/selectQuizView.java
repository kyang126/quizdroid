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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class selectQuizView extends ActionBarActivity {
    ListView myList;
    protected QuizApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = (ListView)findViewById(R.id.listView);

        String [] myQuizArray = {"Math", "Physics", "Marvel Super Heroes"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myQuizArray);
        myList.setAdapter(myAdapter);
        final List<Topic> topics = MySingleton.getInstance().getTopic();
        AdapterView.OnItemClickListener quizItemClicked = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent nextActivity = new Intent(selectQuizView.this, fragScreens.class);
                String topic= topics.get(position).getTitle();
                String desc = topics.get(position).getLongDesc();
                nextActivity.putExtra("topic", topic);
                nextActivity.putExtra("description", desc);

                startActivity(nextActivity);
                //finish();
            }
        };

        myList.setOnItemClickListener(quizItemClicked);


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

