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
public class HomePage {
    
    private JButton pup, teach;
    private HomePageToIdTeach a;
    private HPToPupInt cd;
    private JPanel globalPanel;
    private JFrame myFrame;

    public HomePage() {
        
        myFrame = new JFrame();
        myFrame.setTitle("Application");
        
        myFrame.setLayout(new BorderLayout());
        //this.add(globalPanel, BorderLayout.CENTER);
        setPanel(getGlobalPan(), myFrame);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(true);
        //this.setSize(3000, 3000);
    }
   
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
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
        return myFrame;
    }
}
