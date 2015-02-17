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
import java.util.Collection;
import java.util.List;

/**
 * Created by Kevin on 2/10/2015.
 */
public class questionFragment extends Fragment implements View.OnClickListener {

    RadioButton checkedRadioButton;
    Button button;
    Communicator comm;
    String topic;
    int questionNumber;
    ArrayList<Quiz> questions;
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
        List<Topic> topics = MySingleton.getInstance().getData();
        questions = new ArrayList<>();
        if (topic.equals("Math")) {
            questions = topics.get(0).getQuestions();

        } else if (topic.equals("Physics")) {
            questions = topics.get(1).getQuestions();
        } else if (topic.equals("Marvel Super Heroes")) {
            questions = topics.get(2).getQuestions();
        }

        ((fragScreens) getActivity())
                .setActionBarTitle("Question " + questionNumber);
        String question = questions.get(questionNumber-1).getQuestion();
        String answer1 = questions.get(questionNumber-1).getAnswer1();
        String answer2 = questions.get(questionNumber-1).getAnswer2();
        String answer3 = questions.get(questionNumber-1).getAnswer3();
        String answer4 = questions.get(questionNumber-1).getAnswer4();
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
        int correctIndex = questions.get(questionNumber-1).getCorrect();

        if (correctIndex == 1) {
            answer = questions.get(questionNumber-1).getAnswer1();
        }
        if (correctIndex == 2) {
            answer = questions.get(questionNumber-1).getAnswer2();
        }
        if (correctIndex == 3) {
            answer = questions.get(questionNumber-1).getAnswer3();
        }
        if (correctIndex == 4) {
            answer = questions.get(questionNumber-1).getAnswer4();
        }
        if (checkedRadioButton.getText().toString().equals(answer)) {
            answerPoint = 1;
        }
        comm.respondSummary(questionNumber, answerPoint, checkedRadioButton.getText().toString(), answer);
    }
}
