package edu.washington.kyang126.quizdroid;

/**
 * Created by Kevin on 2/10/2015.
 */
public interface Communicator {
    public void respond(int questionNumber, String topic);

    public void respondSummary(int questionNumber, int points, String selected, String answer);

}
