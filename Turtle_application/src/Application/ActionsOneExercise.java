/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Application.CreateOneExercise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionsOneExercise extends JFrame implements ActionListener{
    private CreateOneExercise ceo;
    
    public ActionsOneExercise(CreateOneExercise c){
        ceo = c;
    }
    public void actionPerformed(ActionEvent e)
    {
        ceo.press(e);
    }
}
