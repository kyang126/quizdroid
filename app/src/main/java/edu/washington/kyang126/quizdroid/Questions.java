package edu.washington.kyang126.quizdroid;

/**
 * Created by Kevin on 2/3/2015.
 */
public class Questions {
    private String question;
    private String[] a;
    private String answer;


    public Questions(String q, String [] a, String b){
        this.question = q;
        this.a = a;
        this.answer = b;

    }

    public String getQuestion(){
        return this.question;
    }

    public String[] getAnswers(){
        return this.a;
    }

    public String getAnswer(){
        return this.answer;
    }



}
