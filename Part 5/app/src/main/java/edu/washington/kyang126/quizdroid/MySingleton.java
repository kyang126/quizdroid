package edu.washington.kyang126.quizdroid;

import android.app.DownloadManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.*;


/**
 * Created by Kevin on 2/15/2015.
 */
public class MySingleton implements TopicRepository{

    private static MySingleton instance;

    public String customVar;

    public static void initInstance()
    {
        if (instance == null)
        {
            instance = new MySingleton();
        }
    }

    public static MySingleton getInstance()
    {
        // Return the instance
        return instance;
    }

    private MySingleton()
    {
        // Constructor hidden because this is a singleton
    }

    public void customSingletonMethod()
    {
        // Custom method
    }

    @Override
    public List<Topic> getData() {

        List<Topic> topics = new ArrayList<Topic>();
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS);
        File file = new File(path, "quizdata.json");

    try {
        String json = "";
        InputStream is = new FileInputStream(file);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        json = new String(buffer, "UTF-8");
        JSONObject obj = new JSONObject(json);
        JSONObject math = obj.getJSONObject("Math");
        Topic mathematics = loadQuiz(math);
        JSONObject physics = obj.getJSONObject("Physics");
        Topic physicsTopic = loadQuiz(physics);
        JSONObject marvel = obj.getJSONObject("Marvel Super Heroes");
        Topic marvelTopic = loadQuiz(marvel);
        topics.add(mathematics);
        topics.add(physicsTopic);
        topics.add(marvelTopic);
    } catch (Exception e) {
        e.printStackTrace();
    }
        return topics;
    }

   private Topic loadQuiz(JSONObject topic){
       Topic general = new Topic();
       try {
           List<Quiz> questions1 = new ArrayList<Quiz>();
           JSONArray Questions = topic.getJSONArray("questions");
           String longdesc = topic.getString("longdesc");
           String shortdesc = topic.getString("shortdesc");
           String title = topic.getString("title");
           for (int i = 0; i < Questions.length(); i++) {
               Quiz q1 = new Quiz();
               JSONObject c = Questions.getJSONObject(i);

               String question = c.getString("question");
               int correct = Integer.parseInt(c.getString("correct"));
               String answer1 = c.getString("answer1");
               String answer2 = c.getString("answer2");
               String answer3 = c.getString("answer3");
               String answer4 = c.getString("answer4");
               q1.setAnswer1(answer1);
               q1.setAnswer2(answer2);
               q1.setAnswer3(answer3);
               q1.setAnswer4(answer4);
               q1.setQuestion(question);
               q1.setCorrect(correct);
               questions1.add(i, q1);
           }
           general.setTitle(title);
           general.setShortDesc(shortdesc);
           general.setLongDesc(longdesc);
           general.setQuestions(questions1);
       }
       catch (JSONException x) {
           x.printStackTrace();
       }
       return general;
   }



}
