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
public class ActionExPupil extends JFrame implements ActionListener{
    private ExercicePupil ep;
    
    public ActionExPupil(ExercicePupil ex){
        ep = ex;
    }
    public void actionPerformed(ActionEvent e)
    {
        ep.press(e);
    }
    
}
