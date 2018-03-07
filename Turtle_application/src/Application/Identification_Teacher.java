/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

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

/**
 *
 * @author manonsacre
 */
public class Identification_Teacher extends JFrame implements ActionListener{

    private JPanel identif, globalP;
    private JLabel loginLabel, passwordLabel, title;
    private JTextField loginText, passwordText;
    private JSplitPane splitId;
    private JButton go;
    
    public Identification_Teacher() {
        
        this.setTitle("Identification Page");
        
        identif = new JPanel();
        identif.setLayout(new GridLayout(2,1));
        
        globalP = new JPanel();
        
        go = new JButton("Let's go !");
        go.addActionListener(this);
        
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
        this.add(title, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == go) {
            Menu_Teacher menu = new Menu_Teacher(); 
            this.dispose();
        } 
    }
}
