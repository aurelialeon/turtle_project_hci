/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionEvaluation extends JFrame implements ActionListener{
    private AccueilEvaluation aev;
    
    public ActionEvaluation(AccueilEvaluation a){
        aev = a;
        
    }
    public void actionPerformed(ActionEvent e){
        aev.press(e);
    }
    
}
