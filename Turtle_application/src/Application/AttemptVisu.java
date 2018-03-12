/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import turtle_project_hci.Exercise;
import turtle_project_hci.Attempt;
/**
 *
 * @author Felix
 */
public class AttemptVisu extends JFrame implements ActionListener{
    private Attempt attemps;
    private Exercise exo; 
    private JButton backward;
    
    public AttemptVisu () {
        //---General settings-------
        this.setTitle("Attempt visualisation");
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
        
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
        exo.getListAttempt();        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backward) {
            AcceuilPupil acceuil = new AcceuilPupil(); 
            this.dispose();
        }
    }
    
}
