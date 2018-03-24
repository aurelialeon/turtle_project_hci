/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.AttemptAnExercise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author manonsacre
 */
public class ControllerAttemptAnExerciseBackAcc implements ActionListener{
    private AttemptAnExercise ep;
    private JButton but;
    
    public ControllerAttemptAnExerciseBackAcc (AttemptAnExercise av, JButton button) {
        ep = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            ep.setPanel(new AcceuilPupil(ep.getAttExFrame()), ep.getAttExFrame());
        }
    }
}
