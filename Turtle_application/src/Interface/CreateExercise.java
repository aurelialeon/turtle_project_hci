/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import turtle_project_hci.Exercise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Utilisateur
 */
public class CreateExercise extends JFrame implements ActionListener{
    private Exercise ex;
    private TortueG newTurtle, normalTurtle, colorTurtle, fastTurtle;
    private JButton normal, color, fast, write, unwrite, speedUp, slowDown;
    private JButton forward, backward, left, right, move, restart;
    private JPanel panelArrows, panelLabel, panelMode, panelButtonsRight, panelRight, panelPage;
    private JLabel myEmptyLabel, labelInstruction, labelMode;
    private JFrame myFrame;
    
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == forward){
            while (newTurtle.getDirection()!=3){
                newTurtle.tourner();
            }
        }else if (ae.getSource() == left) {
            while (newTurtle.getDirection()!=2){
                newTurtle.tourner();
            }
        }else if (ae.getSource() == right){
            while (newTurtle.getDirection()!=0){
                newTurtle.tourner();
            }
        }else if (ae.getSource()==backward){
            while (newTurtle.getDirection()!=1){
                newTurtle.tourner();
            }
        }else if (ae.getSource()==unwrite){
            newTurtle.tracer(false);
        }else if (ae.getSource()==write){
            newTurtle.tracer(true);
        }else if (ae.getSource()== normal){
            newTurtle = normalTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            newTurtle.reset();
        }else if (ae.getSource()== color){
            newTurtle = colorTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            newTurtle.reset();
        }else if (ae.getSource()== fast){
            newTurtle = fastTurtle;
            speedUp.setEnabled(true);
            slowDown.setEnabled(true);
            newTurtle.reset();
        }else if (ae.getSource()== move){
            newTurtle.avancer();
        }else if (ae.getSource()== restart){
            newTurtle.reset();
        }        
    }
    
    
    public CreateExercise(TortueG mode){
        normalTurtle = new TortueG();
        colorTurtle = new TortueCouleur();
        fastTurtle = new TortueRapide();
        JPanel canv = Canvas.getCanvasPanel();
        this.add(canv, BorderLayout.CENTER);
        
        newTurtle = mode; //set the mode by default
        
        normal = new JButton("Graphical Turtle");
        normal.addActionListener(this);
        
        color = new JButton("Color Turtle");
        color.addActionListener(this);
        
        fast = new JButton("Fast Turtle");
        fast.addActionListener(this);
        
        forward = new JButton(new ImageIcon(getClass().getResource("/images/arrowN.png")));
        forward.addActionListener(this);
        
        backward = new JButton(new ImageIcon(getClass().getResource("/images/arrowS.png")));
        backward.addActionListener(this);
        
        left = new JButton(new ImageIcon(getClass().getResource("/images/arrowW.png")));
        left.addActionListener(this);
        
        right = new JButton(new ImageIcon(getClass().getResource("/images/arrowE.png")));
        right.addActionListener(this);
        
        move = new JButton("Move");
        move.addActionListener(this);
        
        restart = new JButton("Restart");
        restart.addActionListener(this);
        
        write = new JButton("Write");
        write.addActionListener(this);
        
        unwrite = new JButton("Unwrite");
        unwrite.addActionListener(this);
        
        speedUp = new JButton("Speed Up");
        speedUp.addActionListener(this);
        speedUp.setEnabled(false);
        
        slowDown = new JButton("Slow Down");
        slowDown.addActionListener(this);
        slowDown.setEnabled(false);
        
        
        //Container c = this.getContentPane();
        
        labelInstruction = new JLabel("<html>Create your exercise here. <br>You can change the turtle mode or restart if you change your mind. <br>Click on the buttons to create a drawing for your pupils to redo.</html>");
        labelMode = new JLabel("Change Turtle Mode:");
        
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
        
        panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(2,1));
        panelLabel.add(labelInstruction);
        panelLabel.add(labelMode);
        
        panelMode = new JPanel();
        panelMode.setLayout(new GridLayout(4,1));
        panelMode.add(normal);
        panelMode.add(color);
        panelMode.add(fast);
        panelMode.add(restart);
        
        panelButtonsRight = new JPanel();
        panelButtonsRight.setLayout(new GridLayout(2,2));
        panelButtonsRight.add(speedUp);
        panelButtonsRight.add(slowDown);
        panelButtonsRight.add(write);
        panelButtonsRight.add(unwrite);
        
        panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(4,1));
        panelRight.add(panelLabel);
        panelRight.add(panelMode);
        panelRight.add(panelButtonsRight);
        panelRight.add(panelArrows);
        

        this.add(panelRight, BorderLayout.EAST);
        
        //myFrame = new JFrame("Create Exercise");//give the name to the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window
            
        this.setVisible(true);
        this.pack();
    }
    

    
}
