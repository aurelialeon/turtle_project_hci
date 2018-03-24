/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.HomePage;
import Application.Identification_Teacher;
import Application.PupilInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author manonsacre
 */
public class HPToPupInt implements ActionListener{

    private HomePage hp;
    private JButton butt;
    
    public HPToPupInt(HomePage acc, JButton b) {
        hp = acc;
        butt = b;
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == butt) {
            hp.setPanel(new PupilInterface(hp.getHomePage()), hp.getHomePage());  
        }
    }
    
}

