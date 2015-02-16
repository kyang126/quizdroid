package edu.washington.kyang126.quizdroid;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kevin on 2/15/2015.
 */
public class Topic extends Application implements Serializable {

    private String title;
    private String shortDesc;
    private String longDesc;
    private ArrayList<Quiz> questions;

    public void Topic(){}

    public void setTitle(String t){
        this.title = t;
    }

    public String getTitle(){
        return this.title;
    }

    public void setShortDesc(String t){
        this.shortDesc = t;
    }

    public String getShortDesc(){
        return this.shortDesc;
    }

    public void setLongDesc(String t){
        this.longDesc = t;
    }

    public String getLongDesc(){
        return this.longDesc;
    }

    public void setQuestions(Collection<Quiz> q){
        this.questions = (ArrayList) q;
    }

    public ArrayList<Quiz> getQuestions(){
        return this.questions;
    }



}
