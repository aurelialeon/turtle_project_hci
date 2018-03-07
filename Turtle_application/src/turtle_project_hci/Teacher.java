
package turtle_project_hci;

import java.util.ArrayList;

/**
 * This class creates a teacher
 * @version 01/03/18
 * @author Utilisateur
 */
public class Teacher extends Person{
    
    private String login; // id of the teacher
    private String password; // password of the account of the teacher
    private ArrayList<Exercise> listExercise; // list of exercises created by the teacher
    private ArrayList<Class> listClass;
    
    /**
     * This is the constructor of the Teacher
     * @param nameTeacher is the last name of the teacher
     * @param firstNameTeacher is the first name of the teacher
     */
    public Teacher(String nameTeacher, String firstNameTeacher){
        super(nameTeacher, firstNameTeacher);
        this.listExercise = new ArrayList<>();
        this.listClass = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    /**
     * This method allows to set an id for the teacher
     * @param n: last name of the teacher
     * @param fN: fisrt name of the teacher
     */
    public final void setIdSpecific(String n, String fN) {
        String newLogin = n + fN;
        for (String idInList : super.getListId()){
            if (idInList.equals(newLogin)){
                newLogin += super.getCount();
                super.setCount(super.getCount()+1);
            }
        }
        super.addIdInList(newLogin);
        setLogin(newLogin); 
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Exercise> getListExercise() {
        return listExercise;
    }

    public void setListExercise(ArrayList<Exercise> listExercise) {
        this.listExercise = listExercise;
    }
    
    /**
     * This method allows the Teacher to create an exercise and add it to the list of existing 
     * exercises into the application
     * @param e: this is the exercise that the teacher is creating
     */
    public void addExercise(Exercise e){
        this.listExercise.add(e);
    }
    
    public void addClass(Class s){
        this.listClass.add(s);
    }

    public ArrayList<Class> getListClass() {
        return listClass;
    }
    
    public String getFName() {
        return super.getFirstName();
    }
    
    public String getTName() {
        return super.getName();
    }
    
}
