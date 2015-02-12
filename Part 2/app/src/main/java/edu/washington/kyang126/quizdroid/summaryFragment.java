package edu.washington.kyang126.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Kevin on 2/11/2015.
 */
public class summaryFragment extends Fragment implements View.OnClickListener {
    Button button;
    Communicator comm;
    int questionNumber;
    String topic;
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
        View v = inflater.inflate(R.layout.fragment_summary_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        questionNumber = getArguments().getInt("questionNumber");
        int pointTotal = getArguments().getInt("points");
        String selectedA = getArguments().getString("selected");
        String answer = getArguments().getString("answer");
        topic = getArguments().getString("topic");

        TextView tv = (TextView)getView().findViewById(R.id.textView13);
        tv.setText("You have " + pointTotal + " out of " + questionNumber + " correct");
        TextView selected = (TextView)getView().findViewById(R.id.textView11);
        selected.setText("Selected answer: " + selectedA);
        TextView correct = (TextView)getView().findViewById(R.id.textView12);
        correct.setText("Correct answer: " + answer);

        button = (Button)getActivity().findViewById(R.id.button3);

        if (questionNumber == 3){
            button.setText("Finish");
        }

        button.setOnClickListener(this);
        comm = (Communicator)getActivity();
    }

    @Override
    public void onClick(View v) {
        if (questionNumber == 3){
            Intent nextActivity = new Intent(getActivity(), selectQuizView.class);
            startActivity(nextActivity);
        } else {
            comm.respond(questionNumber + 1, topic);
        }
    }
}
