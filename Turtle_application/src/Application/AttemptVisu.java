/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import turtle_project_hci.Exercise;
import turtle_project_hci.Attempt;
import turtle_project_hci.RequestSQLite;
/**
 *
 * @author Felix
 */
public class AttemptVisu extends JFrame implements ActionListener{
    private Attempt attemps;
    private Exercise exo; 
    private JButton backward;
    private int numberOfAttempt;
    
    public AttemptVisu () {
        //---General settings-------
        this.setTitle("Attempt visualisation");
        this.setPreferredSize(new Dimension(400, 200));
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
        
        RequestSQLite req = new RequestSQLite();
        numberOfAttempt = req.fetchNumberofAttempt(1);
    
        JLabel[] totalAttemptsLabel = new JLabel[numberOfAttempt];
    
        ArrayList<Attempt> a = new ArrayList<>();
    
        RequestSQLite req2 = new RequestSQLite();
        a = req2.fetchAttemptList(1); // Ici exemple pour l'éleve dont l'id est 1
        
        gbc.gridx = 0; 
        gbc.gridy = 1;
        
        for (int i = 1; i < numberOfAttempt; i++) {
            totalAttemptsLabel[i] = new JLabel();
            totalAttemptsLabel[i].setText(a.get(i).getAnswer());
            
            gbc.gridy += 1;
            this.add(totalAttemptsLabel[i],gbc); 
            
        }
    
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
//        exo.getListAttempt();        
         
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backward) {
            AcceuilPupil acceuil = new AcceuilPupil(); 
            this.dispose();
        }
    } 
}
