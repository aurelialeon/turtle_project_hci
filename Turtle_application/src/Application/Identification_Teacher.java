/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.IdTeachToMenu;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import turtle_project_hci.RequestSQLite;
import turtle_project_hci.Teacher;

/**
 *
 * @author manonsacre
 */
public class Identification_Teacher extends JPanel{

    private JPanel identif, globalP, upPanel;
    private JLabel loginLabel, passwordLabel, title;
    private JTextField loginText, passwordText;
    private JSplitPane splitId;
    private JButton go;
    private Teacher currentTeacher;
    private IdTeachToMenu controller;
    
    public Identification_Teacher(JFrame hp) {
        
        //this.setTitle("Identification Page");
        
        identif = new JPanel();
        identif.setLayout(new GridLayout(2,1));
        
        globalP = new JPanel();
        upPanel = new JPanel();
        
        upPanel.setLayout(new GridLayout(2,1));
        
        go = new JButton("Let's go !");
        controller = new IdTeachToMenu(this, go);
        go.addActionListener(controller);
        
        splitId = new JSplitPane();
        splitId.setOneTouchExpandable(true);
        splitId.setContinuousLayout(true);
        globalP.add(splitId);
        
        loginLabel = new JLabel("Login");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        title = new JLabel("Identification");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        upPanel.add(title);
        
        loginText = new JTextField();
        passwordText = new JTextField();
        
        identif.add(loginLabel);
        identif.add(loginText);
        identif.add(passwordLabel);
        identif.add(passwordText);
        
        splitId.setLeftComponent(identif);
        splitId.setRightComponent(go);
        
        this.setLayout(new BorderLayout());
        this.add(globalP, BorderLayout.CENTER);
        this.add(upPanel, BorderLayout.NORTH);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(true);
        //this.pack();
        this.setVisible(true);
    }
    

    public JTextField getLoginText() {
        return loginText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public Teacher getCurrentTeacher() {
        return currentTeacher;
    }
    
}
