
package turtle_project_hci;

import java.util.ArrayList;

/**
 * This class creates a new class managed by a teacher
 * @version 01/03/18
 * @author Group4
 */
public class Class {
    
    private String nameClass; // this is the name of the class which has just been created
    private Teacher teacher; // this is the teacher who manages the pupil's class
    private ArrayList<Pupil> pupils; // this is the list of pupils who make part of the class
    
    /**
     * This is the constructor of the class Class
     * @param teacher is the teacher who manages the class
     * @param nameClass is the name of the class
     */
    public Class(Teacher teacher, String nameClass){
        this.teacher = teacher;
        this.nameClass = nameClass;
        this.pupils = new ArrayList<>(); // creation of the list of pupils
    }

    /**
     * This method is a getter for the name of the class
     * @return the name of the class
     */
    public String getNameClass() {
        return nameClass;
    }

    /**
     * This method is a setter for the name of the class
     * @param nameClass is the string of the name of the class
     */
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    /**
     * This method is a getter for the Teacher
     * @return the teacher who manages the class
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * This method is a setter to change the teacher who is in charge of the class
     * @param teacher is the teacher who manages the class
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * This method allows to get the list of the pupils of the class
     * @return the pupils of the class
     */
    public ArrayList<Pupil> getPupils() {
        return pupils;
    }

    /**
     * This method is used to add a pupil in the list of a class
     * @param p: this is the pupil to add in the list
     */
    public void addPupils(Pupil p){
        this.pupils.add(p);

    }
    
}
