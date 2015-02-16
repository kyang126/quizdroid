package edu.washington.kyang126.quizdroid;

import java.util.ArrayList;
import java.util.List;

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
            // Create the instance
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
    public List<Topic> getTopic() {
       List<Topic> topics = new ArrayList<Topic>();


        List<Quiz> questions1 = new ArrayList<Quiz>();
        Quiz q1 = new Quiz();
        q1.setAnswer1("11");
        q1.setAnswer2("3");
        q1.setAnswer3("42");
        q1.setAnswer4("2");
        q1.setQuestion("What is 1 + 1?");
        q1.setCorrect(4);

        Quiz q2 = new Quiz();
        q2.setAnswer1("9");
        q2.setAnswer2("4");
        q2.setAnswer3("15");
        q2.setAnswer4("7");
        q2.setQuestion("What is 5 + 4?");
        q2.setCorrect(1);

        Quiz q3 = new Quiz();
        q3.setAnswer1("99");
        q3.setAnswer2("7");
        q3.setAnswer3("56");
        q3.setAnswer4("5");
        q3.setQuestion("What is 10 - 5?");
        q3.setCorrect(4);

        questions1.add(0, q1);
        questions1.add(1, q2);
        questions1.add(2, q3);

        Topic math = new Topic();
        math.setTitle("Math");
        math.setShortDesc("This quiz will be asking 3 questions testing your knowledge on Math");
        math.setLongDesc("This quiz will have 3 questions testing all the knowledge you have gained about Math");
        math.setQuestions(questions1);

        List<Quiz> questions2 = new ArrayList<Quiz>();
        Quiz q4 = new Quiz();
        q4.setAnswer1("3*10^8");
        q4.setAnswer2("1000000");
        q4.setAnswer3("3*10^99");
        q4.setAnswer4("333333");
        q4.setQuestion("C=?");
        q4.setCorrect(1);

        Quiz q5 = new Quiz();
        q5.setAnswer1("The answer is 42");
        q5.setAnswer2("Gravity is the answer");
        q5.setAnswer3("For every action, there is an equal and opposite reaction");
        q5.setAnswer4("Nothing is faster than light");
        q5.setQuestion("Definition of Newton's Third Law");
        q5.setCorrect(3);

        Quiz q6 = new Quiz();
        q6.setAnswer1("e=mc^2");
        q6.setAnswer2("e=mc");
        q6.setAnswer3("e=vf");
        q6.setAnswer4("e=fg");
        q6.setQuestion("What is the conservation of mass energy?");
        q6.setCorrect(1);

        questions2.add(0, q4);
        questions2.add(1, q5);
        questions2.add(2, q6);

        Topic physics = new Topic();
        physics.setTitle("Physics");
        physics.setShortDesc("This quiz will be asking 3 questions testing your knowledge on Physics");
        physics.setLongDesc("This quiz will have 3 questions testing all the knowledge you have gained about Physics");
        physics.setQuestions(questions2);

        List<Quiz> questions3 = new ArrayList<Quiz>();

        Quiz q7 = new Quiz();
        q7.setAnswer1("Magneto");
        q7.setAnswer2("Dr. Doom");
        q7.setAnswer3("Silver Surfer");
        q7.setAnswer4("Green Goblin");
        q7.setQuestion("Who is known as the arch enemy of Professor Xavier?");
        q7.setCorrect(1);

        Quiz q8 = new Quiz();
        q8.setAnswer1("Captain America");
        q8.setAnswer2("Human Torch");
        q8.setAnswer3("Spidey");
        q8.setAnswer4("Hulk");
        q8.setQuestion("___ SMASH!!!?");
        q8.setCorrect(4);

        Quiz q9 = new Quiz();
        q9.setAnswer1("Norman Osbourne");
        q9.setAnswer2("Peter Parker");
        q9.setAnswer3("Steve Rogers");
        q9.setAnswer4("Tony Stark");
        q9.setQuestion("Identity of Spider Man");
        q9.setCorrect(2);

        questions3.add(0, q7);
        questions3.add(1, q8);
        questions3.add(2, q9);

        Topic marvel = new Topic();
        marvel.setTitle("Marvel Super Heroes");
        marvel.setShortDesc("This quiz will be asking 3 questions testing your knowledge on Marvel Superheroes");
        marvel.setLongDesc("This quiz will have 3 questions testing all the knowledge you have gained about Marvel Super Heroes");
        marvel.setQuestions(questions3);

        topics.add(0, math);
        topics.add(1, physics);
        topics.add(2, marvel);

        return topics;
    }

    @Override
    public List<Quiz> getQuestions() {
        List<Quiz> questions = new ArrayList<Quiz>();

        Quiz q1 = new Quiz();
        q1.setAnswer1("11");
        q1.setAnswer2("3");
        q1.setAnswer3("42");
        q1.setAnswer4("2");
        q1.setQuestion("What is 1 + 1?");
        q1.setCorrect(4);

        Quiz q2 = new Quiz();
        q2.setAnswer1("9");
        q2.setAnswer2("4");
        q2.setAnswer3("15");
        q2.setAnswer4("7");
        q2.setQuestion("What is 5 + 4?");
        q2.setCorrect(1);

        Quiz q3 = new Quiz();
        q3.setAnswer1("99");
        q3.setAnswer2("7");
        q3.setAnswer3("56");
        q3.setAnswer4("5");
        q3.setQuestion("What is 10 - 5?");
        q3.setCorrect(4);

        Quiz q4 = new Quiz();
        q4.setAnswer1("3*10^8");
        q4.setAnswer2("1000000");
        q4.setAnswer3("3*10^99");
        q4.setAnswer4("333333");
        q4.setQuestion("C=?");
        q4.setCorrect(1);

        Quiz q5 = new Quiz();
        q5.setAnswer1("The answer is 42");
        q5.setAnswer2("Gravity is the answer");
        q5.setAnswer3("For every action, there is an equal and opposite reaction");
        q5.setAnswer4("Nothing is faster than light");
        q5.setQuestion("Definition of Newton's Third Law");
        q5.setCorrect(3);

        Quiz q6 = new Quiz();
        q6.setAnswer1("e=mc^2");
        q6.setAnswer2("e=mc");
        q6.setAnswer3("e=vf");
        q6.setAnswer4("e=fg");
        q6.setQuestion("What is the conservation of mass energy?");
        q6.setCorrect(1);

        Quiz q7 = new Quiz();
        q7.setAnswer1("Magneto");
        q7.setAnswer2("Dr. Doom");
        q7.setAnswer3("Silver Surfer");
        q7.setAnswer4("Green Goblin");
        q7.setQuestion("Who is known as the arch enemy of Professor Xavier?");
        q7.setCorrect(1);

        Quiz q8 = new Quiz();
        q8.setAnswer1("Captain America");
        q8.setAnswer2("Human Torch");
        q8.setAnswer3("Spidey");
        q8.setAnswer4("Hulk");
        q8.setQuestion("___ SMASH!!!?");
        q8.setCorrect(4);

        Quiz q9 = new Quiz();
        q9.setAnswer1("Norman Osbourne");
        q9.setAnswer2("Peter Parker");
        q9.setAnswer3("Steve Rogers");
        q9.setAnswer4("Tony Stark");
        q9.setQuestion("Identity of Spider Man");
        q9.setCorrect(2);

        questions.add(0, q1);
        questions.add(1, q2);
        questions.add(2, q3);
        questions.add(3, q4);
        questions.add(4, q5);
        questions.add(5, q6);
        questions.add(6, q7);
        questions.add(7, q8);
        questions.add(8, q9);

        return questions;
    }

    @Override
    public void loadTopic() {

    }

    @Override
    public void loadQuestion() {

    }
}
