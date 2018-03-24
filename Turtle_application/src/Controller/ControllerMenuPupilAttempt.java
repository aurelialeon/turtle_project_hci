/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.AttemptVisu;
import Application.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


/**
 *
 * @author Julie
 */
public class ControllerMenuPupilAttempt implements ActionListener{
        private AcceuilPupil acceuilpup;
        private JButton attemptVisuBtn;
    
public ControllerMenuPupilAttempt (AcceuilPupil acceuilpup, JButton attemptVisuBtn ) {
	this.acceuilpup = acceuilpup;
        this.attemptVisuBtn = attemptVisuBtn;
    }
    
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == attemptVisuBtn) {
                acceuilpup.setPanel(new AttemptVisu(acceuilpup.getJfra()), acceuilpup.getJfra());  
            }
    }
}
