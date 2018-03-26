/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateOneExercise;
import Interface.TortueG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Utilisateur
 */
public class ActionCheck1 implements ActionListener{
    private CreateOneExercise coe;
    private JRadioButton butt;
    private JButton speedUp, slowDown;
    
    public ActionCheck1(CreateOneExercise c, JRadioButton b, JButton su, JButton sd){
        coe = c;
        butt = b;
        speedUp = su;
        slowDown = sd;
        
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==butt){
            coe.setNewTurtle(new TortueG());
            coe.getEx().setModeC(null);
            coe.getEx().setModeG(new TortueG());
            coe.getEx().setModeR(null);
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            coe.getNewTurtle().reset();
            coe.setResult("");
        }
    }
}