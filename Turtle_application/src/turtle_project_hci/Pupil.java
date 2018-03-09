
package turtle_project_hci;

import turtle_project_hci.Class;
import java.util.ArrayList;

/**
 * This class creates a profile for a pupil
 * @version 01/03/18
 * @author Group4
 */
public class Pupil extends Person{
    
    private String id; // this is the id necessary to the pupil to be connected to the application
    private Class classTeacher; // this is the class managed by the teacher
    private ArrayList<Attempt> listAttempt; // this is the list of exercises attempts of the pupil
    
    /**
     * This is the constructor of the pupil Class
     * @param namePupil is the last name of the pupil
     * @param firstNamePupil is the first name of the pupil
     */
    public Pupil(String namePupil, String firstNamePupil){
        super(namePupil, firstNamePupil); // Pupil is a subclass of the Person class
        setIdSpecific(namePupil, firstNamePupil); // creates an Id for each pupil
    }

    /**
     * This method is a setter for the id 
     * @param id is the id of the pupil
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method allows to set an id to each pupil of the class
     * @param n: last name of the student
     * @param fN: fisrt name of the student
     */
    public final void setIdSpecific(String n, String fN) {
        String newId = n + fN;
        for (String idInList : super.getListId()){
            if (idInList.equals(newId)){
                newId += super.getCount();
                super.setCount(super.getCount()+1);
            }
        }
        super.addIdInList(newId);
        setId(newId); 
    }

    /**
     * This method sets a teacher for the pupil
     * @param classTeacher is the teacher who manages this pupil
     */
    public void setClassTeacher(Class classTeacher) {
        this.classTeacher = classTeacher;
    }

    /**
     * This method is a setter for the list of attempts made by the pupil
     * @param listAttempt is the list of attempts performed
     */
    public void setListAttempt(ArrayList<Attempt> listAttempt) {
        this.listAttempt = listAttempt;
    }

    /**
     * This method is a getter for the Id
     * @return the id of the pupil
     */
    public String getId() {
        return id;
    }
    
    /**
     * This method is a getter for the teacher of the pupil
     * @return the teacher of the pupil
     */
    public Class getClassTeacher() {
        return classTeacher;
    }

    /**
     * This method is used to add a pupil in the list of a class
     * @param p: this is the pupil to add in the list
     */
    public void addAttempt(Attempt a){
        this.listAttempt.add(a);
    }
    
    /**
     * This method is a getter for the list of attempts of the pupil
     * @return the list of attempts
     */
    public ArrayList<Attempt> getListAttempt() {
        return listAttempt;
    }
    
    public String getPFName() {
        return super.getFirstName();
    }
    
    public String getPName() {
        return super.getName();
    }
    
}
