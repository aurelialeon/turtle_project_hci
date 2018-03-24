/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.AccueilExPupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionAccueilExPupil implements ActionListener{
    private AccueilExPupil ep;
    private JButton but;
    
    public ActionAccueilExPupil (AccueilExPupil av, JButton button) {
        ep = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            ep.setPanel(new AcceuilPupil(ep.getFrameAEP()), ep.getFrameAEP());
        }
    }
    
}
