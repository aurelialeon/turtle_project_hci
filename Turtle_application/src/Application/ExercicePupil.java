/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import turtle_project_hci.Exercise;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import turtle_project_hci.Exercise;

/**
 *
 * @author Felix
 */
public final class ExercicePupil extends JFrame implements ActionListener {
    
    private Exercise exo1;
    
    public ExercicePupil () {
        
        //---General settings-------
        this.setTitle("Tableau de bord");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        /*if (e.getSource() == enterSubmitBtn) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }*/
    } 
}
