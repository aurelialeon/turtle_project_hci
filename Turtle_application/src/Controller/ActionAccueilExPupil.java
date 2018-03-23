/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AccueilExPupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionAccueilExPupil extends JFrame implements ActionListener{
    private AccueilExPupil ep;
    
    public ActionAccueilExPupil(AccueilExPupil ex){
        ep = ex;
    }
    public void actionPerformed(ActionEvent e)
    {
        ep.press(e);
    }
    
}
