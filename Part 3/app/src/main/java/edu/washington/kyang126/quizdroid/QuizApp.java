package edu.washington.kyang126.quizdroid;

/**
 * Created by Kevin on 2/14/2015.
 */
import android.app.Application;
import android.util.Log;

public class QuizApp extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();

        Log.i("Testing on load", "This is working");
        // Initialize the singletons so their instances
        // are bound to the application process.
        initSingletons();
    }

    protected void initSingletons()
    {
        // Initialize the instance of MySingleton
       MySingleton.initInstance();
    }

    public void customAppMethod()
    {
        // Custom application method
    }

}
