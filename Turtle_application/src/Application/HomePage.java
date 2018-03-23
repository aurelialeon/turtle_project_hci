/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.HPToPupInt;
import Controller.HomePageToIdTeach;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author manonsacre
 */
public class HomePage extends JFrame {
    
    private JButton pup, teach;
    private HomePageToIdTeach a;
    private HPToPupInt cd;
    private JPanel globalPanel;

    public HomePage() {
        
        this.setTitle("Application");
        
        this.setLayout(new BorderLayout());
        //this.add(globalPanel, BorderLayout.CENTER);
        this.setPanel(getGlobalPan());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setSize(3000, 3000);
        this.pack();
        this.setSize(1200,800);
        this.setVisible(true);
    }
   
    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
        this.revalidate();
    }
    
    public JPanel getGlobalPan(){
        pup = new JButton("Start Exercice");
        cd = new HPToPupInt(this, pup);
        //pup.setPreferredSize(new Dimension(40,40));
        pup.addActionListener(cd);
        
        teach = new JButton("Teacher");
        a = new HomePageToIdTeach(this, teach);
        teach.addActionListener(a);  
        
        globalPanel = new JPanel(new GridLayout(2,1));
        globalPanel.add(teach);
        globalPanel.add(pup);
        
        return globalPanel;
    }
    
    public JFrame getHomePage(){
        return this;
    }
}
