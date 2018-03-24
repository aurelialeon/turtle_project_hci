/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.ResultVisu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Julie
 */
public class ControllerMenuPupilResult implements ActionListener{
    
    private AcceuilPupil acceuilpupil;
    private JButton resultVisuBtn;

    public ControllerMenuPupilResult(AcceuilPupil acceuilpup, JButton resultVisBtn) {
        acceuilpupil = acceuilpup;
        resultVisuBtn = resultVisBtn;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resultVisuBtn) {
            acceuilpupil.setPanel(new ResultVisu(acceuilpupil.getJfra()), acceuilpupil.getJfra());
        }
    }
    
}
