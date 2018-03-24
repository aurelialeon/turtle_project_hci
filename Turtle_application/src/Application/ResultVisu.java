/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.ResultVisuBackAccueil;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Felix
 */
public class ResultVisu extends JPanel {

    private JButton backward;
    private JFrame resultFrame;
    
    public ResultVisu (JFrame fra){
        //---General settings-------
        resultFrame = fra;
        
        //this.setTitle("Results visualisation");
        this.setSize(1200,800);
        
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        backward = new JButton("Back");
        ResultVisuBackAccueil rvba = new ResultVisuBackAccueil(this, backward);
        this.add(backward, gbc);
        backward.addActionListener(rvba);
        
        //---Settings de fin--------
        this.setVisible(true); // Setting the frame visible
    }
    
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }

    public JFrame getResultFrame() {
        return resultFrame;
    }
    
}
