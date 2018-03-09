/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Interface.CreateExercise;
import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import turtle_project_hci.Exercise;

/**
 *
 * @author Julie
 */
public class CreateExercises extends JFrame implements ActionListener
{
    private JLabel titre, nameEx,instruction; 
    //Fields that teachers fill out for exercise name and instructions
    private JTextField nameExo, consigne; 
    private JPanel panel1,panel2,panel3,paneltot;
    // Boutton to create the draw
    private JButton exo;
    private TortueG tortueR, tortueC,tortueN;
    //Buttons to choose the mode of the eercice
    private JRadioButton check1, check2, check3;
    private Exercise myExercise;
   
            
/**
 * Constructor of CreateExerciseClass
 */
    public CreateExercises() {
        
        myExercise = new Exercise();
        
        tortueR = new TortueG();
        tortueC = new TortueG();
        tortueN = new TortueG();
        
        titre = new JLabel("Creation exercise", JLabel.CENTER);
        this.add(titre, BorderLayout.NORTH);
        
        panel1 = new JPanel();
        

        panel1.setLayout(new GridLayout(1,1));
        nameEx= new JLabel("Enter the name of the exercise");
        nameExo = new JTextField();
        
        panel1.add(nameEx, BorderLayout.SOUTH);
        panel1.add(nameExo, BorderLayout.SOUTH);
        
        panel2 =new JPanel();
        panel2.setLayout(new GridLayout(1,3));
        check1 = new JRadioButton("classical turtle");
        check2 = new JRadioButton("color turtle");
        check3 = new JRadioButton("speed turtle");
        panel2.add(check1);
        panel2.add(check2);
        panel2.add(check3);
        
        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,1));
        instruction= new JLabel("Enter the instructions of the exercise");
        consigne = new JTextField();
        exo =new JButton();
        exo.setText("Create the draw");
        exo.addActionListener(this);
        panel3.add(instruction);
        panel3.add(consigne);
        panel3.add(exo);
        
        
        paneltot= new JPanel();
        paneltot.setLayout(new BorderLayout());
        paneltot.add(panel1,BorderLayout.NORTH);
        paneltot.add(panel2,BorderLayout.CENTER);
        paneltot.add(panel3,BorderLayout.SOUTH);
        this.add(paneltot);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }
    /**
     * Getter that return the name of the exercise
     * @return JTextField
     */
        public JTextField getNameExo(){
            return nameExo;
        }
        /**
        * Getter that return the instruction of the exercise
        * @return JTextField
        */
        public JTextField getInstruction(){
            return consigne;
        }
        
        /**
         * Method that allow to make action depending on the button. 
         * @param e 
         */
        public void actionPerformed(ActionEvent e)
    {
        if (check1.isSelected()){
            myExercise.setMode(tortueN);
            if (e.getSource()== exo){
                TortueG tg = new TortueG();
                CreateExercise cE = new CreateExercise(tg);
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                this.dispose();
            }
        } else if (check2.isSelected()){
            myExercise.setMode(tortueC);
            if (e.getSource()== exo){
                TortueCouleur tc = new TortueCouleur("blue");
                CreateExercise cE = new CreateExercise(tc);
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                this.dispose();
            }
        }
        else if (check3.isSelected()){
            myExercise.setMode(tortueR);
            if (e.getSource()== exo){
                TortueRapide tr = new TortueRapide();
                CreateExercise cE = new CreateExercise(tr);
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                this.dispose();
            }
        } 
    }
     
}
