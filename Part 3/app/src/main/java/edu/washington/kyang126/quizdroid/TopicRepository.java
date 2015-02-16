package edu.washington.kyang126.quizdroid;
import java.lang.*;
import java.util.List;
//Any number of import statements

public interface TopicRepository
{
    //Any number of final, static fields
    //Any number of abstract method declarations\
    public List<Topic> getTopic();

    public List<Quiz> getQuestions();

    public void loadTopic();

    public void loadQuestion();



}