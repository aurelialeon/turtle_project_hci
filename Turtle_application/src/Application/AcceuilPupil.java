/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author Felix
 */
public class AcceuilPupil extends JFrame implements ActionListener{
    
    private JButton exerciceBtn, attemptVisuBtn, resultVisuBtn;
    
    public AcceuilPupil() {
        
        //---General settings-------
        this.setTitle("Tableau de bord");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.BLACK);
        //Instantiate the grid
        GridBagConstraints gbc = new GridBagConstraints();
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        //---1er case du grid---------------------------------------------------
        exerciceBtn = new JButton("Exercices");
        myContainer.add(exerciceBtn, gbc);
        exerciceBtn.addActionListener(this);
        
        //---2eme case----------------------------------------------------------
        gbc.gridy = 1;
        attemptVisuBtn = new JButton("Visualiser vos tentatives");
        myContainer.add(attemptVisuBtn, gbc);
        attemptVisuBtn.addActionListener(this);
        
        //---3eme case----------------------------------------------------------
        gbc.gridy = 2;
        resultVisuBtn = new JButton("Visualiser vos résultats");
        myContainer.add(resultVisuBtn, gbc);
        resultVisuBtn.addActionListener(this);
        


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == exerciceBtn) {
            ExercicePupil exoPupil = new ExercicePupil(); 
            this.dispose();
        } else if (e.getSource() == attemptVisuBtn) {
            AttemptVisu aV = new AttemptVisu();
            this.dispose();
        } else if (e.getSource() == resultVisuBtn) {
            ResultVisu rV = new ResultVisu();
            this.dispose();
        } 
    }
}
