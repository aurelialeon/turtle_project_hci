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
public class NewClasse extends JFrame implements ActionListener{

    private JButton addB;
    private JPanel globP, textP;
    private JLabel classNameLab, emptyLab, instruction;
    private JTextField classNameTF;
    
    public NewClasse() {
        
        this.setTitle("Add a new Class");
        
        globP = new JPanel();
        globP.setLayout(new GridLayout(2,0));
        
        textP = new JPanel();
        textP.setLayout(new GridLayout(2,2));
        
        instruction = new JLabel(" Please enter the name of the class. ");
        instruction.setHorizontalAlignment(SwingConstants.CENTER);
        
        classNameLab = new JLabel("Class Name : ");
        classNameLab.setHorizontalAlignment(SwingConstants.CENTER);
        emptyLab = new JLabel("");
        
        classNameTF = new JTextField();
        
        addB = new JButton("Add the class");
        addB.addActionListener(this);
        
        textP.add(classNameLab);
        textP.add(classNameTF);
        textP.add(emptyLab);
        textP.add(addB);
        
        globP.add(instruction);
        globP.add(textP);
        
        this.add(globP);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == addB) {
            Menu_Teacher menu = new Menu_Teacher(); 
            this.dispose();
        } 
        
        
    }
    
}
