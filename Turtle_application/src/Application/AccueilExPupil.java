/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import Controller.ActionAccueilExPupil;
import Controller.ActionPupilAttemptEx;
import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import turtle_project_hci.Exercise;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import turtle_project_hci.Attempt;
import turtle_project_hci.RequestSQLite;




/**
 * @author Felix
 */
public final class AccueilExPupil extends JPanel
{

//    private Exercise myExercise;

    private JButton backward, doExo;
    private JLabel text;
    private JFrame frameAEP;
    private JPanel tableAttempt;

    
/**
 * Constructor of ExercicePupil
 */
    public AccueilExPupil (JFrame frame) {
        ActionPupilAttemptEx apae;
        frameAEP = frame;
        int numb;
        
        //Exercise myExercise;
        int idExo;
        
        //Container myContainer = frameOne.getContentPane();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        backward = new JButton("Back");
        backward.setFont(new Font("Serif", Font.PLAIN, 26));
        ActionAccueilExPupil ep = new ActionAccueilExPupil(this, backward);
        this.add(backward, gbc);
        backward.addActionListener(ep);
        
        //---Grid 0, 3 -------------
        gbc.gridy = 1;
        text = new JLabel("Choose an exercise !");
        text.setFont(new Font("Serif", Font.PLAIN, 26));

        this.add(text, gbc);

        ArrayList<Exercise> p = new ArrayList<>();
        RequestSQLite req = new RequestSQLite();
        p = req.fetchAllExerciseName();
        numb = p.size();
        
        gbc.gridy = 2;
        this.add(createExerciseList(p,numb),gbc);

        //---Settings de fin--------
        this.setVisible(true); // Setting the frame visible   
    }


    private JPanel createExerciseList(ArrayList<Exercise> ex, int len) {
        ActionPupilAttemptEx apae; 
        int idExo;
        
        tableAttempt = new JPanel();
        GridLayout table = new GridLayout(len,1);
        tableAttempt.setLayout(table);
        JLabel nameExercise; 
        
        if (tableAttempt != null) tableAttempt.removeAll();
        
        for (Exercise exo : ex) {
            nameExercise = new JLabel(exo.getNameExercise(), SwingConstants.CENTER);
            nameExercise.setFont(new Font("Serif", Font.PLAIN, 28));
            idExo = exo.getIdEx();
            doExo = new JButton("Let's go !");
            doExo.setFont(new Font("Serif", Font.PLAIN, 26));
            apae = new ActionPupilAttemptEx(this,doExo,idExo);
            doExo.addActionListener(apae);
            
            tableAttempt.remove(nameExercise);
            tableAttempt.add(nameExercise);
            tableAttempt.remove(doExo);
            tableAttempt.add(doExo);
            tableAttempt.revalidate();
            tableAttempt.repaint();
        }
        return(tableAttempt);  
        
    }
    
    public JFrame getFrameAEP() {
        return frameAEP;
    }
    
   public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }
    
}
