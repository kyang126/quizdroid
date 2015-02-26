package edu.washington.kyang126.quizdroid;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.ArrayMap;
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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class selectQuizView extends ActionBarActivity {
    ListView myList;
    private Toolbar toolbar;
    private SimpleAdapter sa;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        QuizApp app = (QuizApp)getApplication();
        final List<Topic> topics = MySingleton.getInstance().getData();

        HashMap<String,String> item;
        String[][] StatesAndCapitals =
                {{topics.get(0).getTitle(),topics.get(0).getShortDesc()},

                        {topics.get(1).getTitle(),topics.get(1).getShortDesc()},

                        {topics.get(2).getTitle(),topics.get(2).getShortDesc()}};
        for(int i=0;i<StatesAndCapitals.length;i++){

            item = new HashMap<String,String>();

            item.put( "line1", StatesAndCapitals[i][0]);

            item.put( "line2", StatesAndCapitals[i][1]);

            list.add( item );

        }

        sa = new SimpleAdapter(this, list,android.R.layout.two_line_list_item , new String[] { "line1","line2" }, new int[] {android.R.id.text1, android.R.id.text2});

        myList = (ListView)findViewById(R.id.listView);
        myList.setAdapter(sa);

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
        if (id == R.id.preferences) {
            startActivity(new Intent(this, preferences.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

