/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateExercises;
import Application.Menu_Teacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author manonsacre
 */
public class ControllerMenuToCreateExercises implements ActionListener{
    private Menu_Teacher mt;
    private JButton but;
    
    public ControllerMenuToCreateExercises (Menu_Teacher av, JButton button) {
        mt = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            mt.setPanel(new CreateExercises(mt.getMenuFrame()), mt.getMenuFrame());
        }
    }
}