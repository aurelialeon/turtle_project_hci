/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AttemptVisu;
import Application.ExercisePupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import turtle_project_hci.Exercise;
import turtle_project_hci.RequestSQLite;

/**
 *
 * @author cleme
 */

public class ActionReattemptExercise implements ActionListener {
    
        private AttemptVisu att; 
        private JButton but; 
        private int ex;
        private Exercise exo;
        
    public ActionReattemptExercise (AttemptVisu av, JButton button, int idExo) {
        att = av; 
        but = button;
        ex = idExo;
    }
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == but) {
            // créer un nouvel objet Exercice à partir de l'id de l'exercice
            RequestSQLite req = new RequestSQLite();
            exo = new Exercise();
            exo = req.createExerciseFromId(ex);
            
            // diriger l'utilisateur vers le JPanel d'exercice correspondant
            att.setPanel(new ExercisePupil(exo), att.getFrameAtt());
        }
    }
}
