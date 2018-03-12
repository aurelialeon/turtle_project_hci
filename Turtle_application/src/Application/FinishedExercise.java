/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Felix
 */
public class FinishedExercise extends JFrame implements ActionListener{
    private JButton retry, goToMainPage;
    
    public FinishedExercise () {
                //---General settings-------
        this.setTitle("Exercise list");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        retry = new JButton("Retry");
        myContainer.add(retry, gbc);
        retry.addActionListener(this);
        
        //---Grid O, 1 -------------
        gbc.gridy = 1;
        goToMainPage = new JButton("Submit and go to main page");
        myContainer.add(goToMainPage, gbc);
        goToMainPage.addActionListener(this);
        
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible 
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == retry) {
            AttemptAnExercise retry = new AttemptAnExercise(); 
            this.dispose();
        } else if (e.getSource() == goToMainPage) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }
    }
}
    

