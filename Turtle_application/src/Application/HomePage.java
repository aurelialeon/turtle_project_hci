/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author manonsacre
 */
public class HomePage extends JFrame implements ActionListener{
    
    private JButton pup, teach;

    public HomePage(String s) {
        
        this.setTitle(s);
        
        pup = new JButton("Start Exercice");
        //pup.setPreferredSize(new Dimension(40,40));
        pup.addActionListener(this);
        
        teach = new JButton("Teacher");
        teach.addActionListener(this);
        
        this.setLayout(new BorderLayout());
        this.add(pup, BorderLayout.CENTER);
        this.add(teach, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(3000, 3000);
        this.pack();
        this.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == pup) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        } else if (e.getSource() == teach) {
            Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        }
    }
    
    
}
