/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle_project_hci;

import turtle_project_hci.Teacher;
import turtle_project_hci.Pupil;
import turtle_project_hci.Class;
import java.util.ArrayList;

/**
 *
 * @author manonsacre
 */
public class Donnees {

    private Teacher teach1, teach2, teach3;
    private Class class1, class2, class3, class4;
    private Pupil pupil1, pupil2, pupil3, pupil4, pupil5, pupil6, pupil7, pupil8;
    
    public Donnees() {

        teach1 = new Teacher("Aurélia", "LEON");
        teach2 = new Teacher("Felix", "SALLES");
        teach3 = new Teacher("Manon", "SACRÉ");
        
        class1 = new Class(teach1, "CE2");
        class2 = new Class(teach2, "CM1");
        class3 = new Class(teach3, "CM2");
        class4 = new Class(teach1, "CM1");

        pupil1 = new Pupil ("Lievre","Clemence"); 
        pupil2 = new Pupil("Dupont","Paul");
        pupil3 = new Pupil ("Naulleau","Julie");
        pupil4 = new Pupil ("Blabla","Toto");
        pupil5 = new Pupil("Durand","Alex");
        pupil6 = new Pupil ("Graton","Helene");
        pupil7 = new Pupil ("Jacques","Kelly");
        pupil8 = new Pupil ("Lol","Matt");
        
    
        class1.addPupils(pupil4);
        class1.addPupils(pupil5);
        class2.addPupils(pupil3);
        class2.addPupils(pupil2);
        class3.addPupils(pupil6);
        class3.addPupils(pupil1);
        class4.addPupils(pupil7);
        class4.addPupils(pupil8);

    }

    public Teacher getTeach1() {
        return teach1;
    }

    public Teacher getTeach2() {
        return teach2;
    }

    public Teacher getTeach3() {
        return teach3;
    }
    
    
    
}
