package edu.washington.kyang126.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class questionView extends ActionBarActivity {
    private RadioButton answer;
    private static int qCounter;
    private static ArrayList<Questions> qList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        final Button b = (Button) findViewById(R.id.button2);
        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r4 = (RadioButton) findViewById(R.id.radioButton4);

        b.setVisibility(View.INVISIBLE);
        Intent launchedMe = getIntent();
        final String topic =launchedMe.getStringExtra("topic");
        answer = (RadioButton) findViewById(R.id.radioButton);
        final String order =launchedMe.getStringExtra("order");

        qList = getQuestions(topic, order);

        settingText(r1, r2, r3, r4);

        answer = getCorrectAnswer(r1, r2, r3, r4);

        qCounter++;

        final RadioGroup choiceGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        choiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup rGroup, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked){
                    b.setVisibility((View.VISIBLE));
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = choiceGroup.getCheckedRadioButtonId();
                RadioButton cButton = (RadioButton)findViewById(selectedId);
                    //code here
                Intent nextActivity = new Intent(questionView.this, summaryView.class);

                if (answer.isChecked()) {
                    nextActivity.putExtra("answer", 1);
                } else {
                    nextActivity.putExtra("answer", 0);
                }
                nextActivity.putExtra("correct", answer.getText());
                nextActivity.putExtra("selected", cButton.getText());
                nextActivity.putExtra("questionTotal", qCounter);
                nextActivity.putExtra("topic", topic);
                if (qCounter == 3){
                    qCounter = 0;
                }
                startActivity(nextActivity);
            }
        });
    }
@Override
public void onBackPressed(){

}

    private void settingText(RadioButton r1, RadioButton r2, RadioButton r3, RadioButton r4){
        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setText(qList.get(0).getQuestion());
        r1.setText(qList.get(0).getAnswers()[0]);
        r2.setText(qList.get(0).getAnswers()[1]);
        r3.setText(qList.get(0).getAnswers()[2]);
        r4.setText(qList.get(0).getAnswers()[3]);

    }

    private RadioButton getCorrectAnswer(RadioButton r1, RadioButton r2, RadioButton r3, RadioButton r4){
        RadioButton a = r1;
        if (qList.get(0).getAnswer().equals(r1.getText())){
            a = r1;
        } else if (qList.get(0).getAnswer().equals(r2.getText())){
            a = r2;
        } else if (qList.get(0).getAnswer().equals(r3.getText())){
            a = r3;
        } else if (qList.get(0).getAnswer().equals(r4.getText())){
            a = r4;
        }
        return a;
    }


    private ArrayList<Questions> getQuestions(String topic, String order){
        ArrayList<Questions> qChoices = new ArrayList<Questions>(3);
        Questions q;
        Questions q1;
        Questions q2;
        Log.i("tesing topic: ", "" + topic);
        if(topic.equals("Math")) {
            if (order.equals("first")) {
                String[] answers = new String[4];
                answers[0] = "11";
                answers[1] = "3";
                answers[2] = "42";
                answers[3] = "2";
                String question = "What is 1 + 1?";
                q = new Questions(question, answers, "2");
                qChoices.add(0, q);
            } else  if (order.equals("second")) {
                String[] answers1 = new String[4];
                answers1[0] = "9";
                answers1[1] = "20";
                answers1[2] = "42";
                answers1[3] = "1";
                String question2 = "What is 5 + 4?";
                q1 = new Questions(question2, answers1, "9");
                qChoices.add(0, q1);
            }else if (order.equals("third")) {
                String[] answers2 = new String[4];
                answers2[0] = "3";
                answers2[1] = "9";
                answers2[2] = "6";
                answers2[3] = "0";
                String question3 = "What is 3!?";
                q2 = new Questions(question3, answers2, "6");
                qChoices.add(0, q2);
            }
        } else if (topic.equals("Physics")){
            if (order.equals("first")) {
                String[] answers = new String[4];
                answers[0] = "3*10^6";
                answers[1] = "3*10^8";
                answers[2] = "1000000";
                answers[3] = "2343245";
                String question = "C=?";
                q = new Questions(question, answers, "3*10^8");
                qChoices.add(0, q);
            } else if (order.equals("second")) {
                String[] answers1 = new String[4];
                answers1[0] = "For every action, there is an equal and opposite reaction";
                answers1[1] = "Force is mass times weight";
                answers1[2] = "Relativity is associated with speed";
                answers1[3] = "Nothing is faster than light";
                String question2 = "Definition of Newton's Third Law?";
                q1 = new Questions(question2, answers1, "For every action, there is an equal and opposite reaction");
                qChoices.add(0, q1);
            } else if (order.equals("third")) {
                String[] answers2 = new String[4];
                answers2[0] = "e=vf";
                answers2[1] = "e=mc^2";
                answers2[2] = "e=wg";
                answers2[3] = "e=mg";
                String question3 = "What is the conservation of mass energy?";
                q2 = new Questions(question3, answers2, "e=mc^2");
                qChoices.add(0, q2);
            }

        } else if (topic.equals("Marvel Super Heroes")){
            if (order.equals("first")) {
                String[] answers = new String[4];
                answers[0] = "Hulk";
                answers[1] = "Captain America";
                answers[2] = "Iron Man";
                answers[3] = "Thor";
                String question = "Who is the Strongest Super Hero?";
                q = new Questions(question, answers, "Hulk");
                qChoices.add(0, q);
            } else if (order.equals("second")) {
                String[] answers1 = new String[4];
                answers1[0] = "Dr. Doom";
                answers1[1] = "Magneto";
                answers1[2] = "Galactus";
                answers1[3] = "Green Goblin";
                String question2 = "Who is the best villain?";
                q1 = new Questions(question2, answers1, "Magneto");
                qChoices.add(0, q1);
            } else if (order.equals("third")) {
                String[] answers2 = new String[4];
                answers2[0] = "Avengers";
                answers2[1] = "Spiderman";
                answers2[2] = "Captain America";
                answers2[3] = "Iron Man";
                String question3 = "Best Marvel Movie?";
                q2 = new Questions(question3, answers2, "Captain America");
                qChoices.add(0, q2);
            }
        }
        return qChoices;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
