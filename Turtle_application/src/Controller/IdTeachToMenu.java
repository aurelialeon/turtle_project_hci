/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.HomePage;
import Application.Identification_Teacher;
import Application.Menu_Teacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import turtle_project_hci.RequestSQLite;
import turtle_project_hci.Teacher;

/**
 *
 * @author manonsacre
 */
public class IdTeachToMenu implements ActionListener{

    private Identification_Teacher id;
    private JButton butt;
    private Teacher currentTeacher;
    
    public IdTeachToMenu(Identification_Teacher acc, JButton b) {
        id = acc;
        butt = b;
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == butt) {
            String login = id.getLoginText().getText();
            String pwd = id.getPasswordText().getText();
            boolean authentificationTeacher;
            RequestSQLite req = new RequestSQLite();
            authentificationTeacher = req.authentificationTeacher(login, pwd);
            currentTeacher = req.fetchTeacher(login, pwd);
            
            if (authentificationTeacher == true) {
                Menu_Teacher menu = new Menu_Teacher(currentTeacher); 
            }
           
        }
    }
    
}