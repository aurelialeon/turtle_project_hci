/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AttemptVisu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author cleme
 */

public class ActionReattemptExercise implements ActionListener {
    
        private AttemptVisu att; 
        private JButton but; 
        private int ex;
        
    public ActionReattemptExercise (AttemptVisu av, JButton button, int idExo) {
        att = av; 
        but = button;
        ex = idExo;
    }
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == but) {
            System.out.println("affiche");
        }
    }
}
