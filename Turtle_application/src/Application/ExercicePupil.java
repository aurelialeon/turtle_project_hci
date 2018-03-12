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
import java.util.ArrayList;
import turtle_project_hci.Attempt;
import turtle_project_hci.Exercise;

 
/**
 * @author Felix
 */
public final class ExercicePupil extends JFrame implements ActionListener {
    private Exercise exo;
    private JButton draw, backward;
    private JLabel text;
    
    public ExercicePupil () {
        
        //---General settings-------
        this.setTitle("Exercise list");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        backward = new JButton("Back");
        myContainer.add(backward, gbc);
        backward.addActionListener(this);
        
        //---Grid 0, 3 -------------
        gbc.gridy = 3;
        text = new JLabel("Choose an exercise it is time to exercise !");
        this.add(text, gbc);
        
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
    }
    
    /*
    public void exerciceList () {
        exo.setListAttempt(ArrayList<Attempt> listAttempt);
    }*/
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backward) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }
}
}