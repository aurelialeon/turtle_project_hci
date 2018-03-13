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
import RequestSQLite.
/**
 *
 * @author manonsacre
 */
public class NewTeacher extends JFrame implements ActionListener{

    private JSplitPane splitT;
    private JButton save;
    private JPanel bigP, textP;
    private JLabel fNameLab, nameLab, loginLab, pswLab, emptyLab, instruction;
    private JTextField fNameTF, nameTF, loginTF, pswTF;
    
    public NewTeacher() {
        
        this.setTitle("New teacher registration");
        
        bigP = new JPanel();
        bigP.setLayout(new GridLayout(2,0));
        
        textP = new JPanel();
        textP.setLayout(new GridLayout(5,2));
        
        instruction = new JLabel("<html> Welcome new teacher :) <br> Please enter your firstname, lastname, login and password. <br> You need a login and a password to access and save your data for the next time. </html>");
        instruction.setHorizontalAlignment(SwingConstants.CENTER);
        
        fNameLab = new JLabel("FirstName : ");
        fNameLab.setHorizontalAlignment(SwingConstants.CENTER);
        nameLab = new JLabel("Name : ");
        nameLab.setHorizontalAlignment(SwingConstants.CENTER);
        loginLab = new JLabel("Login : ");
        loginLab.setHorizontalAlignment(SwingConstants.CENTER);
        pswLab = new JLabel("Password : ");
        pswLab.setHorizontalAlignment(SwingConstants.CENTER);
        emptyLab = new JLabel("");
        
        fNameTF = new JTextField();
        nameTF = new JTextField();
        loginTF = new JTextField();
        pswTF = new JTextField();
        
        save = new JButton("Save information");
        save.addActionListener(this);
        
        textP.add(fNameLab);
        textP.add(fNameTF);
        textP.add(nameLab);
        textP.add(nameTF);
        textP.add(loginLab);
        textP.add(loginTF);
        textP.add(pswLab);
        textP.add(pswTF);
        textP.add(emptyLab);
        textP.add(save);
        
        bigP.add(instruction);
        bigP.add(textP);
        
        //splitT = new JSplitPane();
        //splitT.setOneTouchExpandable(true);
        //splitT.setContinuousLayout(true);
        
        this.add(bigP);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == save) {
            Menu_Teacher menu = new Menu_Teacher(); 
            this.dispose();
        } 
        
        
    }

    public JTextField getfNameTF() {
        return fNameTF;
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getLoginTF() {
        return loginTF;
    }

    public JTextField getPswTF() {
        return pswTF;
    }
}
