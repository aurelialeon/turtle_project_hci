/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.ExercisePupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import turtle_project_hci.Exercise;

/**
 *
 * @author Julie
 */
public class ControllerMenuPupuilEx implements ActionListener{
    private AcceuilPupil acceuilpup;
    private JButton exerciceBtn;
    private Exercise exo;
    
public ControllerMenuPupuilEx(AcceuilPupil acceuilpup, JButton exerciceBtn ) {
		acceuilpup = acceuilpup;
                exerciceBtn = exerciceBtn;
	}
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exerciceBtn) {
            exo = new Exercise();
            ExercisePupil exoPupil = new ExercisePupil(exo);
        }
    }
    
}
