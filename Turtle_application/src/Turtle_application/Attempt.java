
package Turtle_application;

import java.util.Date;

/**
 * This class creates an attempt for an exercise
 * @version 01/03/18
 * @author Group4
 */
public class Attempt {
    
    //private int nbAttempt; // this is the number of attempts that have been performed on a specific exercise
    private Date dateAttempt; // this is the date corresponding to each attempt
    //private Exercise exo; // this is the exercise corresponding to the attempt performed
    private String answer; // this is the answer given by the pupil
    
    /**
     * This is the constructor of the attempt Class
     */
    public Attempt(){
        Date d = new Date(); // every time an attempt is performed, the date checked is the actual one
        dateAttempt = d;

    }
    
    /**
     * This method is a getter for the date of the attempt
     * @return the date of the attempt performed
     */
    public Date getDateAttempt() {
        return dateAttempt;
    }

    /**
     * This method sets the answer of the pupil during the attempt
     * @param answer : this is the answer of the pupil to the exercise
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * This method is a getter for the answer of the pupil to the exercise
     * @return the answer of the pupil
     */
    public String getAnswer() {
        return answer;
    }

    
}
