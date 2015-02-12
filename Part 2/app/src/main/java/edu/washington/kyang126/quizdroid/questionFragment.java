package edu.washington.kyang126.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevin on 2/10/2015.
 */
public class questionFragment extends Fragment implements View.OnClickListener {

    RadioButton checkedRadioButton;
    Button button;
    Communicator comm;
    String topic;
    int questionNumber;

    static final String STATE_q1 = "quiz1";
    ArrayList<Questions> qChoices;
    @Override
    public void onAttach (Activity activity){
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question_layout, container, false);

        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topic = getArguments().getString("topic");
        questionNumber = getArguments().getInt("questionNumber");
        buildQuestions bQ = new buildQuestions();
        qChoices = new ArrayList<Questions>();
        if (topic.equals("Math")) {
            qChoices = bQ.getMathChoices();
        } else if (topic.equals("Physics")) {
            qChoices = bQ.getPhysicsChoices();
        } else if (topic.equals("Marvel Super Heroes")) {
            qChoices = bQ.getMarvelChoices();
        }
        qChoices.get(questionNumber-1).getQuestion();
        ((fragScreens) getActivity())
                .setActionBarTitle("Question " + questionNumber);
        String question = qChoices.get(questionNumber-1).getQuestion();
        String answer1 = qChoices.get(questionNumber-1).getAnswers() [0];
        String answer2 = qChoices.get(questionNumber-1).getAnswers() [1];
        String answer3 = qChoices.get(questionNumber-1).getAnswers() [2];
        String answer4 = qChoices.get(questionNumber-1).getAnswers() [3];
        TextView tv = (TextView) getActivity().findViewById(R.id.textView9);
        RadioButton r1 = (RadioButton) getActivity().findViewById(R.id.radioButton5);
        RadioButton r2 = (RadioButton) getActivity().findViewById(R.id.radioButton6);
        RadioButton r3 = (RadioButton) getActivity().findViewById(R.id.radioButton7);
        RadioButton r4 = (RadioButton) getActivity().findViewById(R.id.radioButton8);
        tv.setText("Question " + questionNumber + ": " + question);
        r1.setText(answer1);
        r2.setText(answer2);
        r3.setText(answer3);
        r4.setText(answer4);
        button = (Button)getActivity().findViewById(R.id.button6);
        button.setVisibility(View.INVISIBLE);
        final RadioGroup choiceGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup2);
        choiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup rGroup, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton)rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked){
                    button.setVisibility((View.VISIBLE));
                }
            }
        });
        button.setOnClickListener(this);
        comm = (Communicator)getActivity();
    }

    @Override
    public void onClick(View v) {
        int answerPoint = 0;
        String answer = "";
        answer = qChoices.get(questionNumber-1).getAnswer();
        if (checkedRadioButton.getText().toString().equals(answer)) {
            answerPoint = 1;
        }

        comm.respondSummary(questionNumber, answerPoint, checkedRadioButton.getText().toString(), answer);
    }
}
