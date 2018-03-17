/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import turtle_project_hci.Exercise;
import turtle_project_hci.Attempt;
import turtle_project_hci.RequestSQLite;
/**
 *
 * @author Felix
 */
public class AttemptVisu extends JFrame implements ActionListener{
    private Attempt attemps;
    private Exercise exo; 
    private JButton backward;
    private int numberOfAttempt;
    private JPanel tableAttempt;
    
    public AttemptVisu () {
        //---General settings-------
        this.setTitle("Attempt visualisation");
        this.setPreferredSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        backward = new JButton("Back");
        myContainer.add(backward, gbc);
        backward.addActionListener(this);
        
        //--------------Affichage des essais de l'élève --------------\\
        RequestSQLite req = new RequestSQLite();
        numberOfAttempt = req.fetchNumberofAttempt(1); // on récupère le nombre d'essai pour l'élève dont l'id correspond
        
        RequestSQLite req2 = new RequestSQLite();
        ArrayList<Attempt> a = new ArrayList<>();
        a = req2.fetchAttemptList(1); // on récupère la liste des essais pour l'élève dont l'id correspond
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(createAttemptList(a),gbc);
        
    
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
//        exo.getListAttempt();        
         
    }
    
    
    
    /**
     * Create the gridLayout containing the list of attempt for a pupil
     * @return tableAttempt
     */
    private JPanel createAttemptList(ArrayList<Attempt> a) {
        tableAttempt = new JPanel();
        GridLayout table = new GridLayout(2,1);
        tableAttempt.setLayout(table);
        if (tableAttempt != null) tableAttempt.removeAll();
        
        for (Attempt att : a) {
            //JLabel nameExercise = new JLabel();
            JLabel attemptLabel = new JLabel(att.getAnswer());
            JButton reattempt = new JButton("Recommencer");
            reattempt.addActionListener(this);
            tableAttempt.remove(attemptLabel);
            tableAttempt.add(attemptLabel);
            tableAttempt.remove(reattempt);
            tableAttempt.add(reattempt);
            tableAttempt.revalidate();
            tableAttempt.repaint();
        }
        return(tableAttempt);   
    }
    
    /**
     * Sets the responses for every action listener
     * @param e 
     */
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backward) {
            AcceuilPupil acceuil = new AcceuilPupil(); 
            this.dispose();
        }
    } 
}
