/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author manonsacre
 */
public class NewPupil extends JFrame implements ActionListener{

    private JSplitPane splitT;
    private JButton addPB;
    private JPanel mainP, textP;
    private JLabel fNamePLab, namePLab, classPLab, emptyLab, instruction;
    private JTextField fNamePTF, namePTF, classPTF;
    
    public NewPupil() {
        
        this.setTitle("Add a new pupil");
        
        mainP = new JPanel();
        mainP.setLayout(new GridLayout(2,0));
        
        textP = new JPanel();
        textP.setLayout(new GridLayout(4,2));
        
        instruction = new JLabel(" Please enter the firstname, lastname and the class of the pupil. ");
        instruction.setHorizontalAlignment(SwingConstants.CENTER);
        
        fNamePLab = new JLabel("FirstName : ");
        fNamePLab.setHorizontalAlignment(SwingConstants.CENTER);
        namePLab = new JLabel("Name : ");
        namePLab.setHorizontalAlignment(SwingConstants.CENTER);
        classPLab = new JLabel("Class : ");
        classPLab.setHorizontalAlignment(SwingConstants.CENTER);
        emptyLab = new JLabel("");
        
        fNamePTF = new JTextField();
        namePTF = new JTextField();
        classPTF = new JTextField();
        
        addPB = new JButton("Add the pupil ");
        addPB.addActionListener(this);
        
        textP.add(fNamePLab);
        textP.add(fNamePTF);
        textP.add(namePLab);
        textP.add(namePTF);
        textP.add(classPLab);
        textP.add(classPTF);
        textP.add(emptyLab);
        textP.add(addPB);
        
        mainP.add(instruction);
        mainP.add(textP);
        
        //splitT = new JSplitPane();
        //splitT.setOneTouchExpandable(true);
        //splitT.setContinuousLayout(true);
        
        this.add(mainP);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == addPB) {
            Menu_Teacher menu = new Menu_Teacher(); 
            this.dispose();
        } 
        
        
    }
    
}
