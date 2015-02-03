package edu.washington.kyang126.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity6 extends ActionBarActivity {
private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6);

        b = (Button) findViewById(R.id.button5);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton11);
        final RadioGroup choiceGroup = (RadioGroup) findViewById(R.id.radioGroup3);

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


        b.setVisibility(View.INVISIBLE);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                int selectedId = choiceGroup.getCheckedRadioButtonId();
                RadioButton cButton = (RadioButton) findViewById(selectedId);

                //code here
                Intent nextActivity = new Intent(MainActivity6.this, MainActivity4.class);
                //nextActivity.putExtra("timestamp", new Date().toString());
                //nextActivity.putExtra()

                if (r1.isChecked()) {
                    nextActivity.putExtra("answer", 1);
                } else {
                    nextActivity.putExtra("answer", 0);
                }
                nextActivity.putExtra("correct", r1.getText());
                nextActivity.putExtra("selected", cButton.getText());
                nextActivity.putExtra("questionTotal", 3);
                nextActivity.putExtra("newActivity", 7);
                startActivity(nextActivity);
                finish();


            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity6, menu);
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
