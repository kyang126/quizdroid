package edu.washington.kyang126.quizdroid;
import android.app.Application;

import java.io.Serializable;

/**
 * Created by Kevin on 2/15/2015.
 */
public class Quiz extends Application implements Serializable {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correct;

    public Quiz() {}

    public void setQuestion(String q){
        this.question = q;
    }

    public String getQuestion(){
        return this.question;
    }

    public void setAnswer1(String a){
        this.answer1 = a;
    }

    public String getAnswer1(){
        return this.answer1;
    }

    public void setAnswer2(String a){
        this.answer2 = a;
    }

    public String getAnswer2(){
        return this.answer2;
    }

    public void setAnswer3(String a){
        this.answer3 = a;
    }

    public String getAnswer3(){
        return this.answer3;
    }

    public void setAnswer4(String a){
        this.answer4 = a;
    }

    public String getAnswer4(){
        return this.answer4;
    }

    public void setCorrect(int a){
        this.correct = a;
    }

    public int getCorrect(){
        return this.correct;
    }




}
