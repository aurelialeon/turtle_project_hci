/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.ExercisePupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionExercisePupil extends JFrame implements ActionListener{
    private ExercisePupil aep;
    
    public ActionExercisePupil(ExercisePupil a){
        aep = a;
    }
    
    public void actionPerformed(ActionEvent e){
        aep.press(e);
    }
    
}