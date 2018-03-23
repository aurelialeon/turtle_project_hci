/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import turtle_project_hci.Attempt;
import turtle_project_hci.Evaluation;
import turtle_project_hci.Exercise;
import turtle_project_hci.Grade;
import turtle_project_hci.RequestSQLite;

/**
 *
 * @author Utilisateur
 */
public class AccueilEvaluation {
    private Attempt att;
    private JButton correct, correctExercise, backward, save;
    private TortueG newTurtle, tortueN;
    private TortueCouleur tortueC;
    private TortueRapide tortueR;
    private JLabel instruLabel, textLabel, yourCodeLabel, pupilCodeLabel, gradeLabel, commentaryLabel;
    private JFrame myFrame, frameOne, frameTwo;
    private JPanel canvTeacher, canvPupil, panelLeft;
    private JTextField textCommentary;
    private JRadioButton acq, prog, not;
    private ButtonGroup groupGrade;
    
    private Exercise ex;
    private Attempt attEvaluated;
    
    public AccueilEvaluation(Exercise ex, Attempt att){
        ActionEvaluation aev = new ActionEvaluation(this);
        
        this.ex = ex;
        this.attEvaluated = att;
        
        frameOne = new JFrame();
        frameOne.setTitle("Exercises");
        frameOne.setSize(1200,800);
        frameOne.setLocationRelativeTo(null);
        frameOne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container myContainer = frameOne.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---Grid 0, 0 -------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        backward = new JButton("Back");
        myContainer.add(backward, gbc);
        backward.addActionListener(aev);
        
        //---Grid 0, 3 -------------
        gbc.gridy = 1;
        textLabel = new JLabel("Here is the exercise that you created!");

        frameOne.add(textLabel, gbc);

        
        gbc.gridy=2;
        correctExercise = new JButton("See the visual of your exercise");
        frameOne.add(correctExercise, gbc);
        correctExercise.addActionListener(aev);

        
        //---Settings de fin--------
        frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOne.setResizable(true);
        frameOne.pack();
        frameOne.setVisible(true); // Setting the frame visible
        
        tortueN = new TortueG();
        tortueC = new TortueCouleur();
        tortueR = new TortueRapide();
        

        newTurtle = tortueN; //set the newTurtle by default
        

        
        /** = new JButton("Slow Down");
        slowDown.addActionListener(aev);
        slowDown.setEnabled(false);*/
        
        save = new JButton("Save");
        save.addActionListener(aev);
        
        correct = new JButton("CORRECT");
        correct.addActionListener(aev);
        
    
    }
    
    public void press(ActionEvent e)
    {
        /**if (e.getSource() == backward) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }*/
        
        if (e.getSource() == correctExercise) {
            //char lastChar = myExercise.getCodeExercise().charAt(myExercise.getCodeExercise().length() - 1);
            //for(char c = myExercise.getCodeExercise().charAt(0); c != lastChar; c++){
            frameOne.dispose();
            correctExercise();
            for (int i = 0 ; i < ex.getCodeExercise().length() ;i++){
                switch (ex.getCodeExercise().charAt(i)) {
                    case 'T':
                        while (newTurtle.getDirection()!=3){
                            newTurtle.tourner();
                        }   break;
                    case 'L':
                        while (newTurtle.getDirection()!=2){
                            newTurtle.tourner();
                        }   break;
                    case 'R':
                        while (newTurtle.getDirection()!=0){
                            newTurtle.tourner();
                        }   break;
                    case 'B':
                        while (newTurtle.getDirection()!=1){
                            newTurtle.tourner();
                        }   break;
                    case 'U':
                        newTurtle.tracer(false);
                        break;
                    case 'W':
                        newTurtle.tracer(true);
                        break;
                    case 'M':
                        newTurtle.avancer();
                        break;
                    case 'A':
                        tortueR.accelerer();
                        break;
                    case 'F':
                        tortueR.ralentir();
                        break;
                    default:
                        break;
                }
            }
        }else if (e.getSource()== correct){
            myFrame.dispose();
            correct();
            for (int i = 0 ; i < attEvaluated.getAnswer().length() ;i++){
                switch (attEvaluated.getAnswer().charAt(i)) {
                    case 'T':
                        while (newTurtle.getDirection()!=3){
                            newTurtle.tourner();
                        }   break;
                    case 'L':
                        while (newTurtle.getDirection()!=2){
                            newTurtle.tourner();
                        }   break;
                    case 'R':
                        while (newTurtle.getDirection()!=0){
                            newTurtle.tourner();
                        }   break;
                    case 'B':
                        while (newTurtle.getDirection()!=1){
                            newTurtle.tourner();
                        }   break;
                    case 'U':
                        newTurtle.tracer(false);
                        break;
                    case 'W':
                        newTurtle.tracer(true);
                        break;
                    case 'M':
                        newTurtle.avancer();
                        break;
                    case 'A':
                        tortueR.accelerer();
                        break;
                    case 'F':
                        tortueR.ralentir();
                        break;
                    default:
                        break;
                }
            }
        }

        else if (e.getSource()==save){
            Evaluation eval = new Evaluation(commentaryLabel.getText());
            if(acq.isSelected()){
                eval.setGrade(Grade.ACQ);
            }else if(prog.isSelected()){
                eval.setGrade(Grade.PROG);
            }else if(not.isSelected()){
                eval.setGrade(Grade.NOT);
            }
        }
   

    }
    
    public void correctExercise(){
        
        instruLabel = new JLabel("<html>Here is the drawing you created for the exercise. <br></html>");
        
        myFrame = new JFrame("Correct an exercise");
        canvTeacher = Interface.Canvas.getCanvasPanel();

        myFrame.add(canvTeacher, BorderLayout.CENTER);
        
        myFrame.add(instruLabel, BorderLayout.NORTH);
        myFrame.add(correct, BorderLayout.SOUTH);
        myFrame.setResizable(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window

        myFrame.setVisible(true);
        myFrame.pack();      

    }
        
    
    public void correct(){
                
        newTurtle.reset();
        // instanciation of panels
        // label panels

        yourCodeLabel = new JLabel("Your code: " + ex.getCodeExercise());
        pupilCodeLabel = new JLabel("The code of your pupil: " + attEvaluated.getAnswer());
        commentaryLabel = new JLabel("Your commentary: ");
        gradeLabel = new JLabel("Grade: ");
        textCommentary = new JTextField();
        
        acq = new JRadioButton("Acquired");
        prog = new JRadioButton("In Progress");
        not = new JRadioButton("Not Acquired");
        groupGrade = new ButtonGroup();
        groupGrade.add(acq);
        groupGrade.add(prog);
        groupGrade.add(not);
        
        panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(8,1));
        panelLeft.add(yourCodeLabel);
        panelLeft.add(pupilCodeLabel);
        panelLeft.add(commentaryLabel);
        panelLeft.add(textCommentary);
        panelLeft.add(acq);
        panelLeft.add(prog);
        panelLeft.add(not);
        panelLeft.add(save);
        
        frameTwo = new JFrame();
        canvPupil = new JPanel();
        canvPupil = Interface.Canvas.getCanvasPanel();
        frameTwo.add(canvPupil, BorderLayout.CENTER);
        frameTwo.add(panelLeft, BorderLayout.WEST);
        
        //myFrame = new JFrame("Create Exercise");//give the name to the frame
        frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window

            
        frameTwo.setVisible(true);
        frameTwo.pack();
    }
    
}
