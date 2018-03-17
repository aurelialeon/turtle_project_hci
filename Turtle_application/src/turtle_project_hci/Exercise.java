
package turtle_project_hci;

import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.util.ArrayList;


/**
 * @version 01/03/18
 * @author Group4
 */
public class Exercise {
    
    private static int count = 0; // used to count the number of exercises already existing
    private int idEx; // this is the number of the exercise
    private String nameExercise; // the is the name that the teacher gives to the exercise
    private String instruction; // instruction that will be given by the teacher to his pupils to do the exercise
    private String codeExercise; // this is the code generated by the creation of an exercise by the teacher, converted from clicks with the mouse
    private TortueG modeG; // mode of the exercise: normal, fast or color
    private TortueCouleur modeC;
    private TortueRapide modeR;
    private int nbAttempt = 0;// this is the number of attempts that have been performed on a specific exercise
    private ArrayList<Attempt> listAttempt;
    
    /**
     * This is the constructor of the Exercise class
     * @param attempt
     */
    public Exercise(){
        modeG = null;
        modeC = null;
        modeR = null;
    }

    /**
     * This method is a getter for the name of the exercise
     * @return the name of the exercise
     */
    public String getNameExercise() {
        return nameExercise;
    }

    /**
     * This method is a getter for the instructions of the exercise, given by the teacher
     * @return the instructions for the exercise
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * This method is a getter for the code of the exercise
     * @return the code of the exercise
     */
    public String getCodeExercise() {
        return codeExercise;
    }

    /**
     * This method is a getter for the mode of the exercise
     * @return the exercise's mode
     */
    public TortueG getModeG() {
        return modeG;
    }

    /**
     * This method is a getter for the number of the exercise
     * @return the number of the exercise
     */
    public int getIdEx() {
        return idEx;
    }

    /**
     * This method is a setter for the number of the exercise
     * @param idEx is the number of the exercise
     */
    public void setIdEx(int idEx) {
        this.idEx = idEx; // the Id is generated automatically in the constructor
    }

    /**
     * This method is a setter for the instruction of the teacher for the exercise
     * @param instruction is the instruction of the teacher for the exercise
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * This method is a setter for the code of the exercise that the teacher will set
     * @param codeExercise is the code that will be generated by the teacher at the creation of the exercise
     */
    public void setCodeExercise(String codeExercise) {
        this.codeExercise = codeExercise;
    }

    /**
     * This method allows to set the graphical mode of the exercise
     * @param mode is the turtle mode that will be set for the exercise
     */
    public void setModeG(TortueG modeG) {
        this.modeG = modeG;
    }

    /**
    * This method is a setter for the name of the exercise
    * @param nameExercise this is the name that the teacher gives to the exercise
    */
    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }

    public int getNbAttempt() {
        return nbAttempt;
    }

    public void setNbAttempt(int nbAttempt) {
        this.nbAttempt = nbAttempt;
    }
    
    /**
     * This method allows the teacher to create an exercice
     * @param nameEx is the name that the teacher gives to the exercise
     * @param instr is the instruction given by the teacher for the exercise
     * @param modeEx is the mode of the exercise
     * @param code is the code produced from the graphical interface by the creation of the exercise
     */
    public void createEx(String nameEx, String instr, TortueG modeEx, String code){
        setIdEx(++count); // it allows the autoincrementation of the Id of the exercises
        setNameExercise(nameEx);
        setInstruction(instr);
        setModeG(modeEx);
        setCodeExercise(code);
    }
    
    /**
     * This method allows a pupil to perform an exercise
     * @param answer is the answer given by the pupil
     */
    public void performAttempt(String answer){
        setNbAttempt(++nbAttempt); // increments the number of attempts for this exercise
        //attempt.setAnswer(answer);
    }

    public ArrayList<Attempt> getListAttempt() {
        return listAttempt;
    }

    public void setListAttempt(ArrayList<Attempt> listAttempt) {
        this.listAttempt = listAttempt;
    }

    public TortueCouleur getModeC() {
        return modeC;
    }

    public void setModeC(TortueCouleur modeC) {
        this.modeC = modeC;
    }

    public TortueRapide getModeR() {
        return modeR;
    }

    public void setModeR(TortueRapide modeR) {
        this.modeR = modeR;
    }
    
    public void addAttempt(Attempt e){
        this.listAttempt.add(e);
    }
    
    
}
