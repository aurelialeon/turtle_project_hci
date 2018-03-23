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
import Controller.ControllerMenuPupuilEx;
import Controller.ControllerMenuPupilResult;
import Controller.ControllerMenuPupilAttempt;
/**
 *
 * @author Felix
 */
public class AcceuilPupil extends JFrame{
    private JButton exerciceBtn, attemptVisuBtn, resultVisuBtn;
    private ControllerMenuPupuilEx controlE;
    private ControllerMenuPupilResult controlR;
    private ControllerMenuPupilAttempt controlA;
    
    public AcceuilPupil() {
        
        //---General settings-------
        this.setTitle("Tableau de bord");
        this.setPreferredSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.WHITE);
        //Instantiate the grid
        GridBagConstraints gbc = new GridBagConstraints();
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        //---1er case du grid---------------------------------------------------
        exerciceBtn = new JButton("Exercices");
        myContainer.add(exerciceBtn, gbc);
        controlE = new ControllerMenuPupuilEx(this, exerciceBtn);
        exerciceBtn.addActionListener(controlE);
        
        //---2eme case----------------------------------------------------------
        gbc.gridy = 1;
        attemptVisuBtn = new JButton("Visualiser vos tentatives");
        myContainer.add(attemptVisuBtn, gbc);
        controlA = new ControllerMenuPupilAttempt(this,attemptVisuBtn);
        attemptVisuBtn.addActionListener(controlA);
        
        //---3eme case----------------------------------------------------------
        gbc.gridy = 2;
        resultVisuBtn = new JButton("Visualiser vos résultats");
        myContainer.add(resultVisuBtn, gbc);
        controlR = new ControllerMenuPupilResult(this,resultVisuBtn);
        resultVisuBtn.addActionListener(controlR);
        
        //---Setting de fin-----------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
    }
}
