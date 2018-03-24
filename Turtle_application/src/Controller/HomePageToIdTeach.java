/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author manonsacre
 */
public class HomePageToIdTeach implements ActionListener{

    private HomePage hp;
    private JButton butt;
    
    public HomePageToIdTeach(HomePage acc, JButton b) {
        hp = acc;
        butt = b;
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == butt) {
            hp.setPanel(new Identification_Teacher(hp.getHomePage()), hp.getHomePage()); 
        }
    }
    
}
