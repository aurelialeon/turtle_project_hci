/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.FinishedExToAccPupil;
import Controller.FinishedExToAttemptAnEx;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Felix
 */
public class FinishedExercise extends JPanel {
    private JButton retry, goToMainPage;
    private JFrame frameFinished;
    
    public FinishedExercise (JFrame fra) {
        //---General settings-------
        
        frameFinished = fra;
                
        //this.setTitle("Exercise list");
        this.setSize(1200,800);
        
        
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        retry = new JButton("Retry");
        this.add(retry, gbc);
        FinishedExToAttemptAnEx fetaae = new FinishedExToAttemptAnEx(this, retry);
        retry.addActionListener(fetaae);
        
        //---Grid O, 1 -------------
        gbc.gridy = 1;
        goToMainPage = new JButton("Submit and go to main page");
        this.add(goToMainPage, gbc);
        FinishedExToAccPupil fetap = new FinishedExToAccPupil(this, goToMainPage);
        goToMainPage.addActionListener(fetap);
        
        //---Settings de fin--------
        this.setVisible(true); // Setting the frame visible 
    }
    
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }

    public JFrame getFrameFinished() {
        return frameFinished;
    }
    
}
    

