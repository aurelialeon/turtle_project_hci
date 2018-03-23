/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AttemptVisu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author cleme
 */
public class ActionsAttemptVisu extends JFrame implements ActionListener {
    
    private AttemptVisu va;
    
    public ActionsAttemptVisu (AttemptVisu a) {
        va = a;
    }
    
    public void actionPerformed (ActionEvent ae) {
        va.press(ae);
    }
}
