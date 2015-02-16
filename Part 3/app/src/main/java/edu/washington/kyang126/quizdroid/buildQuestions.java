package edu.washington.kyang126.quizdroid;

import java.util.ArrayList;

/**
 * Created by Kevin on 2/11/2015.
 */
public class buildQuestions {

    private ArrayList<Questions> mathChoices;
    private ArrayList<Questions> physicsChoices;
    private ArrayList<Questions> marvelChoices;

    public buildQuestions(){
        mathChoices = new ArrayList<Questions>(3);

               Questions q1;
        String[] answers = new String[4];
        answers[0] = "11";
        answers[1] = "3";
        answers[2] = "42";
        answers[3] = "2";
        String question = "What is 1 + 1?";
        q1 = new Questions(question, answers, "2");

        Questions q2;
        String[] answers2 = new String[4];
        answers2[0] = "9";
        answers2[1] = "4";
        answers2[2] = "15";
        answers2[3] = "7";
        String question2 = "What is 5 + 4?";
        q2 = new Questions(question2, answers2, "9");

        Questions q3;
        String[] answers3 = new String[4];
        answers3[0] = "99";
        answers3[1] = "7";
        answers3[2] = "56";
        answers3[3] = "5";
        String question3 = "What is 10 - 5?";
        q3 = new Questions(question3, answers3, "5");

        mathChoices.add(0,q1);
        mathChoices.add(1,q2);
        mathChoices.add(2,q3);


        physicsChoices = new ArrayList<Questions>(3);

        Questions q4;
        String[] answers4 = new String[4];
        answers4[0] = "3*10^8";
        answers4[1] = "1000000";
        answers4[2] = "3*10^99";
        answers4[3] = "333333";
        String question4 = "C=?";
        q4 = new Questions(question4, answers4, "3*10^8");

        Questions q5;
        String[] answers5 = new String[4];
        answers5[0] = "The answer is 42";
        answers5[1] = "Gravity is the answer";
        answers5[2] = "For every action, there is an equal and opposite reaction";
        answers5[3] = "Nothing is faster than light";
        String question5 = "Definition of Newton's Third Law";
        q5 = new Questions(question5, answers5, "For every action, there is an equal and opposite reaction");

        Questions q6;
        String[] answers6 = new String[4];
        answers6[0] = "e=mc^2";
        answers6[1] = "e=mc";
        answers6[2] = "e=vf";
        answers6[3] = "e=fg";
        String question6 = "What is the conservation of mass energy?";
        q6 = new Questions(question6, answers6, "e=mc^2");

        physicsChoices.add(0,q4);
        physicsChoices.add(1,q5);
        physicsChoices.add(2,q6);


        marvelChoices = new ArrayList<Questions>(3);

        Questions q7;
        String[] answers7 = new String[4];
        answers7[0] = "Magneto";
        answers7[1] = "Dr. Doom";
        answers7[2] = "Silver Surfer";
        answers7[3] = "Green Goblin";
        String question7 = "Who is known as the arch enemy of Professor Xavier?";
        q7 = new Questions(question7, answers7, "Magneto");

        Questions q8;
        String[] answers8 = new String[4];
        answers8[0] = "Captain America";
        answers8[1] = "Human Torch";
        answers8[2] = "Spidey";
        answers8[3] = "Hulk";
        String question8 = "___ SMASH!!!?";
        q8 = new Questions(question8, answers8, "Hulk");

        Questions q9;
        String[] answers9 = new String[4];
        answers9[0] = "Norman Osbourne";
        answers9[1] = "Peter Parker";
        answers9[2] = "Steve Rogers";
        answers9[3] = "Tony Stark";
        String question9 = "Identity of Spider Man";
        q9 = new Questions(question9, answers9, "Peter Parker");

        marvelChoices.add(0,q7);
        marvelChoices.add(1,q8);
        marvelChoices.add(2,q9);


    }

    public ArrayList<Questions> getMathChoices() {return mathChoices;}

    public ArrayList<Questions> getPhysicsChoices() {return physicsChoices;}

    public ArrayList<Questions> getMarvelChoices() {return marvelChoices;}

}
