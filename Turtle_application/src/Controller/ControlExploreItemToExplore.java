/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateExercises;
import Application.Exploration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author manonsacre
 */
public class ControlExploreItemToExplore implements ActionListener{
    private Exploration exp;
    private JMenuItem it;
    
    public ControlExploreItemToExplore (Exploration av, JMenuItem item) {
        exp = av; 
        it = item;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == it) { 
            //exp.setPanel(new Exploration(exp.getExploreFrame()), exp.getExploreFrame());
        }
    }
}