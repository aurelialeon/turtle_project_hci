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
public final class ExercicePupil extends JFrame implements ActionListener
{
    private JButton backward, thisExercise;
    private JLabel text;
    private TortueG tortueR, tortueC,tortueN;
    private Exercise myExercise;
    
/**
 * Constructor of ExercicePupil
 */
    public ExercicePupil () {
               
        //---General settings-------
        this.setTitle("Exercises");
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
        thisExercise = new JButton("Exercise");
        myContainer.add(thisExercise, gbc);
        thisExercise.addActionListener(this);
        
        myExercise = new Exercise();
        tortueR = new TortueG();
        tortueC = new TortueG();
        tortueN = new TortueG();
        
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
        /*
        if (e.getSource() == thisExercise) {
            TheExercisePupil theExo = new TheExercisePupil();
            this.dispose();
        }*/
    }
}
        /*
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
}*/

}
