/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.FinishedExercise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author manonsacre
 */
public class FinishedExToAccPupil implements ActionListener{
    private FinishedExercise ep;
    private JButton but;
    
    public FinishedExToAccPupil (FinishedExercise av, JButton button) {
        ep = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            ep.setPanel(new AcceuilPupil(ep.getFrameFinished()), ep.getFrameFinished());
        }
    }
}
