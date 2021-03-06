/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.ActionExercisePupil;
import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import turtle_project_hci.Attempt;
import turtle_project_hci.Exercise;

/**
 *
 * @author Utilisateur
 */
public class ExercisePupil extends JPanel{
    
    
    private JLabel text, instruLabel, picLabel, myEmptyLabel;
    private TortueG tortueN, newTurtle;
    private TortueCouleur tortueC;
    private TortueRapide tortueR;

    private JFrame myFrame, frameOne, frameTwo;
    private JButton write, unwrite, speedUp, slowDown, backward;
    private JButton forward, back, left, right, move, restart, save, start;
    private JPanel canv, canvToFill, panelArrows, panelButtonsRight, panelRight;
    private String answer = "";
    
    private Exercise myExercise;


    
    public ExercisePupil(Exercise exo){
        ActionExercisePupil ep = new ActionExercisePupil(this);
        
        this.myExercise = exo;
        
        tortueN = new TortueG();
        tortueC = new TortueCouleur();
        tortueR = new TortueRapide();
        
        //myExercise.setModeG(tortueN);

        /**if (myExercise.getModeG()!=null){
            newTurtle = tortueN;
        }else if (myExercise.getModeC()!=null){
            newTurtle = tortueC;
        }else if (myExercise.getModeR()!=null){
            newTurtle = tortueR;
        }*/
        newTurtle = tortueN; //set the newTurtle by default
        
        forward = new JButton(new ImageIcon(getClass().getResource("/images/arrowN.png")));
        forward.addActionListener(ep);
        
        backward = new JButton(new ImageIcon(getClass().getResource("/images/arrowS.png")));
        backward.addActionListener(ep);
        
        left = new JButton(new ImageIcon(getClass().getResource("/images/arrowW.png")));
        left.addActionListener(ep);
        
        right = new JButton(new ImageIcon(getClass().getResource("/images/arrowE.png")));
        right.addActionListener(ep);
        
        move = new JButton("Move");
        move.addActionListener(ep);
        
        restart = new JButton("Restart");
        restart.addActionListener(ep);
        
        restart = new JButton("Restart");
        restart.addActionListener(ep);
        
        write = new JButton("Write");
        write.addActionListener(ep);
        
        unwrite = new JButton("Unwrite");
        unwrite.addActionListener(ep);
        
        speedUp = new JButton("Speed Up");
        speedUp.addActionListener(ep);
        speedUp.setEnabled(false);
        
        slowDown = new JButton("Slow Down");
        slowDown.addActionListener(ep);
        slowDown.setEnabled(false);
        
        save = new JButton("Save");
        save.addActionListener(ep);
        
        start = new JButton("START");
        start.addActionListener(ep);
        
        displayInstruction();
        
    }
    
    public void press(ActionEvent e){
        if (e.getSource() == forward){
            while (newTurtle.getDirection()!=3){
                newTurtle.tourner();
            }
            answer += "T"; //top
        }else if (e.getSource() == left) {
            while (newTurtle.getDirection()!=2){
                newTurtle.tourner();
            }
            answer += "L"; //left
        }else if (e.getSource() == right){
            while (newTurtle.getDirection()!=0){
                newTurtle.tourner(); 
            }
            answer += "R"; //right
        }else if (e.getSource()==backward){
            while (newTurtle.getDirection()!=1){
                newTurtle.tourner();
            }
            answer += "B"; //bottom
        }else if (e.getSource()==unwrite){
            newTurtle.tracer(false);
            answer += "U"; //unwrite

        }else if (e.getSource()==write){
            newTurtle.tracer(true);
            answer+="W"; //write
        }else if (e.getSource()== move){
            newTurtle.avancer();
            answer += "M"; //move

        }else if (e.getSource()== restart){
            newTurtle.reset();
            answer ="";
        }else if (e.getSource()==speedUp){
            tortueR.accelerer();
            answer += "A"; //acceler
            
        }else if (e.getSource()==slowDown){
            tortueR.ralentir();
            answer += "F"; //freiner
        }else if (e.getSource()==save){
            Attempt at = new Attempt(answer);
            myExercise.addAttempt(at);
            //ex.setCodeExercise(result);
        }else if (e.getSource() == start){
            myFrame.dispose();
            start();
        }
    }
        
    public void displayInstruction(){
        performExercise();
            myExercise.setCodeExercise("MRMMBUMMW");
            for (int i = 0 ; i < myExercise.getCodeExercise().length() ;i++){
                switch (myExercise.getCodeExercise().charAt(i)) {
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
    
    
    public void performExercise(){

        
        instruLabel = new JLabel("<html>Copy the drawing that you see on the screen. <br>You can use the arrows and the move buttons. <br>Good luck!</html>");
        
        myFrame = new JFrame("Perform an exercise");
        canv = Interface.Canvas.getCanvasPanel();

        myFrame.add(canv, BorderLayout.CENTER);
        
        myFrame.add(instruLabel, BorderLayout.NORTH);
        myFrame.add(start, BorderLayout.SOUTH);
        myFrame.setResizable(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window

        myFrame.setVisible(true);
        myFrame.pack();      
        

    }
    
    public void start(){
                
        newTurtle.reset();
        // instanciation of panels
        // label panels
        panelArrows = new JPanel();
        panelArrows.setLayout(new GridLayout(3,3));
        panelArrows.add(myEmptyLabel = new JLabel());
        panelArrows.add(forward);
        panelArrows.add(myEmptyLabel = new JLabel());
        panelArrows.add(left);
        panelArrows.add(move);
        panelArrows.add(right);
        panelArrows.add(myEmptyLabel = new JLabel());
        panelArrows.add(backward);
        panelArrows.add(myEmptyLabel = new JLabel());
        
        panelButtonsRight = new JPanel();
        panelButtonsRight.setLayout(new GridLayout(2,2));
        panelButtonsRight.add(speedUp);
        panelButtonsRight.add(slowDown);
        panelButtonsRight.add(write);
        panelButtonsRight.add(unwrite);
        
        panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(4,1));
        panelRight.add(restart);
        panelRight.add(panelArrows);
        panelRight.add(panelButtonsRight);
        panelRight.add(save);
        
        frameTwo = new JFrame();
        canvToFill = new JPanel();
        canvToFill = Interface.Canvas.getCanvasPanel();
        frameTwo.add(canvToFill, BorderLayout.CENTER);
        frameTwo.add(panelRight, BorderLayout.EAST);
        
        //myFrame = new JFrame("Create Exercise");//give the name to the frame
        frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window

            
        frameTwo.setVisible(true);
        frameTwo.pack();
    }
    
}
