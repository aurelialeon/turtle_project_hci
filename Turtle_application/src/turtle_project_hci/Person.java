
package turtle_project_hci;

import java.util.ArrayList;

/**
 * This class creates a person. It can be a teacher or a pupil
 * @version 01/03/18
 * @author Group4
 */
public class Person {
    
    private String name;
    private String firstName;
    private ArrayList<String> listId; //list of all the existing id
    private int count = 1; // this is a counter to create the Id of the pupils for homonyms


    /**
     * This is the constructor of the class Person
     * @param name: last name of the person who is connected on the application
     * @param firstName: first name of the person who is connected to the application
     */
    public Person(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
        this.listId = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
     
    /**
     * This method is a getter for the list of Id of the pupils
     * @return the list of Ids
     */
    public ArrayList<String> getListId() {
        return listId;
    }
    
    /**
     * This method allows to add the new created id in a list of Ids to check homonyms
     * @param id is the id to add
     */
    public void addIdInList(String id){
        this.listId.add(id);
    }
    
}
