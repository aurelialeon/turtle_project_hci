/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import Controller.ActionReattemptExercise;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import turtle_project_hci.Exercise;
import turtle_project_hci.Attempt;
import turtle_project_hci.RequestSQLite;

/**
 *
 * @author Felix
 */
public class AttemptVisu extends JPanel {
    private Attempt attempt;
    private Exercise exo; 
    private JButton backward,reattempt;
    private int numberOfAttempt;
    private JPanel tableAttempt;
    
    public AttemptVisu () {
        //ActionsAttemptVisu aav = new ActionsAttemptVisu(this);        
        
        //---General settings-------
        this.setPreferredSize(new Dimension(400, 200));
        this.setLayout(new BorderLayout());
               
        backward = new JButton("Back");
        this.add(backward, BorderLayout.NORTH);
        backward.setFont(new Font("Serif", Font.PLAIN, 28));
        //backward.addActionListener(aav);
        
        //--------------Affichage des essais de l'élève --------------\\
        RequestSQLite req = new RequestSQLite();
        numberOfAttempt = req.fetchNumberofAttempt(1); // on récupère le nombre d'essai pour l'élève dont l'id correspond
        
        RequestSQLite req2 = new RequestSQLite();
        ArrayList<Attempt> a = new ArrayList<>();
        a = req2.fetchAttemptList(1); // on récupère la liste des essais pour l'élève dont l'id correspond
        
        this.add(createAttemptList(a,numberOfAttempt),BorderLayout.CENTER);
           
        //---Settings de fin--------
        this.setVisible(true); // Setting the frame visible   
    }
    
    /**
     * Create the gridLayout containing the list of attempt for a pupil
     * @return tableAttempt
     */
    private JPanel createAttemptList(ArrayList<Attempt> a, int numb) {
        ActionReattemptExercise are;
        int idexo;
        
        tableAttempt = new JPanel();
        GridLayout table = new GridLayout(numb,1);
        tableAttempt.setLayout(table);
        RequestSQLite req = new RequestSQLite();
        JLabel nameExercise; 
        JLabel attemptLabel;
         
        if (tableAttempt != null) tableAttempt.removeAll();
            
        for (Attempt att : a) {
            nameExercise = new JLabel(att.getExo().getNameExercise(), SwingConstants.CENTER);
            nameExercise.setFont(new Font("Serif", Font.PLAIN, 28));
            attemptLabel = new JLabel(att.getAnswer(), SwingConstants.CENTER);
            attemptLabel.setFont(new Font("Serif", Font.PLAIN, 26));
            idexo = req.fetchAttemptExId(att.getExo().getNameExercise());
            reattempt = new JButton("Start again");
            reattempt.setFont(new Font("Serif", Font.PLAIN, 26));
            are = new ActionReattemptExercise(this, reattempt, idexo); // Ici il faut récupérer l'objet exo à partir de la commande sql
            
            tableAttempt.remove(nameExercise);
            tableAttempt.add(nameExercise);
            tableAttempt.remove(attemptLabel);
            tableAttempt.add(attemptLabel);
            tableAttempt.remove(reattempt);
            tableAttempt.add(reattempt);
            tableAttempt.revalidate();
            tableAttempt.repaint();
        }
        return(tableAttempt);   
    }
     
}
