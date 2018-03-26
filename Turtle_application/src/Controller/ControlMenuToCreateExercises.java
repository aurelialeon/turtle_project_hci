/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateOneExercise;
import Application.Identification_Teacher;
import Application.Menu_Teacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import turtle_project_hci.Exercise;

/**
 *
 * @author Utilisateur
 */
public class ControlMenuToCreateExercises implements ActionListener{
    private Menu_Teacher mt;
    private JButton but;
    
    public ControlMenuToCreateExercises (Menu_Teacher av, JButton button) {
        mt = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            mt.setPanel(new CreateOneExercise(mt.getMenuFrame()), mt.getMenuFrame());
        }
    }
    
}
