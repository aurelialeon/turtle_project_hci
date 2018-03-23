/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Application.AttemptVisu;

/**
 *
 * @author manonsacre
 */
public class ActionReattemptExercise implements ActionListener{

    private JButton attempt;
    private AttemptVisu av;
    private int id;
    
    public ActionReattemptExercise(AttemptVisu a, JButton b, int i) {
        av = a;
        attempt = b;
        id = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attempt) {
            //AttemptVisu aV = new AttemptVisu();
        } 
    }
    
}
