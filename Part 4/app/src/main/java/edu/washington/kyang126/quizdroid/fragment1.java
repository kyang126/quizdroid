package edu.washington.kyang126.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevin on 2/8/2015.
 */
public class fragment1 extends Fragment implements View.OnClickListener {
    Button button;
    Communicator comm;
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = (Button)getActivity().findViewById(R.id.button5);
        button.setOnClickListener(this);
        comm = (Communicator)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        topic = getArguments().getString("topic");
        String description = getArguments().getString("description");
        View v = inflater.inflate(R.layout.fragment_one_layout, container, false);

        TextView tv = (TextView)v.findViewById(R.id.textView6);
        tv.setText("Topic Overview: " + topic);
        TextView desc = (TextView)v.findViewById(R.id.textView7);
        desc.setText("Description: " + description);
        return v;
    }

    @Override
    public void onClick(View v) {
        comm.respond(1, topic);
    }


}
