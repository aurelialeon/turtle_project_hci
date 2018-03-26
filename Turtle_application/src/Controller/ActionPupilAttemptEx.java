/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AccueilExPupil;
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
public class ActionPupilAttemptEx implements ActionListener {
    private AccueilExPupil acc; 
    private JButton butt;
    private int idExo; 
    private Exercise exo;
    
    public ActionPupilAttemptEx (AccueilExPupil aep, JButton btn, int id) {
        acc = aep; 
        butt = btn;
        idExo = id;
    }
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == butt) {
            // créer un nouvel objet Exercice à partir de l'id de l'exercice
            RequestSQLite req = new RequestSQLite();
            exo = new Exercise();
            exo = req.createExerciseFromId(idExo);
            
            // diriger l'utilisateur vers le JPanel d'exercice correspondant
            acc.setPanel(new ExercisePupil(exo), acc.getFrameAEP());
            
        }
    }
}
