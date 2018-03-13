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
    private TortueG newTurtle, normalTurtle;
    private TortueCouleur colorTurtle;
    private TortueRapide fastTurtle;
    private JButton normal, color, fast, write, unwrite, speedUp, slowDown;
    private JButton forward, backward, left, right, move, restart, save;
    private JPanel panelArrows, panelLabel, panelMode, panelButtonsRight, panelRight, panelPage;
    private JLabel myEmptyLabel, labelInstruction, labelMode;
    private JFrame myFrame, secondFrame, thirdFrame;
    private String result="";
    
    // for the second frame
    private JLabel colorLabel, fastLabel;
    private JButton black, red, blue, green, yellow, magenta, setSpeed;
    private JPanel panelColor, panelGlobal, panelGlobal2, panelRadioButtons;
    private JFormattedTextField textSpeed;
    private String c;
    private JComboBox comboSpeed;
    private JRadioButton check1, check2, check3, check4, check5;
    
    private Exercise exo;
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == forward){
            while (newTurtle.getDirection()!=3){
                newTurtle.tourner();
                
            }
            result += "T"; //top
        }else if (ae.getSource() == left) {
            while (newTurtle.getDirection()!=2){
                newTurtle.tourner();
                
            }
            result += "L"; //left
        }else if (ae.getSource() == right){
            while (newTurtle.getDirection()!=0){
                newTurtle.tourner(); 
            }
            result += "R"; //right
        }else if (ae.getSource()==backward){
            while (newTurtle.getDirection()!=1){
                newTurtle.tourner();
            }
            result += "B"; //bottom
        }else if (ae.getSource()==unwrite){
            newTurtle.tracer(false);
            result += "U"; //unwrite
        }else if (ae.getSource()==write){
            newTurtle.tracer(true);
            result+="W"; //write
        }else if (ae.getSource()== normal){
            newTurtle = normalTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            newTurtle.reset();
            result = "";
        }else if (ae.getSource()== color){
            newTurtle = colorTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            newTurtle.reset();
            result = "";
            chooseMode(colorTurtle);
        }else if (ae.getSource()== fast){
            newTurtle = fastTurtle;
            speedUp.setEnabled(true);
            slowDown.setEnabled(true);
            newTurtle.reset();
            result = "";
            chooseMode(fastTurtle);
        }else if (ae.getSource()== move){
            newTurtle.avancer();
            result += "M"; //move
        }else if (ae.getSource()== restart){
            newTurtle.reset();
            result ="";
        } else if (ae.getSource()==black){
            newTurtle = new TortueCouleur("black");
            secondFrame.dispose();
        } else if (ae.getSource()==red){
            newTurtle = new TortueCouleur("red");
            secondFrame.dispose();
        } else if (ae.getSource()==blue){
            newTurtle = new TortueCouleur("blue");
            secondFrame.dispose();
        } else if (ae.getSource()==green){
            newTurtle = new TortueCouleur("green");
            secondFrame.dispose();
        } else if (ae.getSource()==yellow){
            newTurtle = new TortueCouleur("yellow");
            secondFrame.dispose();
        } else if (ae.getSource()==magenta){
            newTurtle = new TortueCouleur("magenta");
            secondFrame.dispose();
        } else if (ae.getSource()==setSpeed){
            if (check1.isSelected()){
                //newTurtle = new TortueRapide();
                fastTurtle.setVitesse(1);
            }else if (check2.isSelected()){
                fastTurtle.setVitesse(2);
            }else if (check3.isSelected()){
                fastTurtle.setVitesse(3);
            }else if (check4.isSelected()){
                fastTurtle.setVitesse(4);
            }else if (check5.isSelected()){
                fastTurtle.setVitesse(5);
            }
            thirdFrame.dispose();

        }else if (ae.getSource()==speedUp){
            fastTurtle.accelerer();
            result += "Su"; //speed up
            
        }else if (ae.getSource()==slowDown){
            fastTurtle.ralentir();
            result += "Sd"; //slow down
        }else if (ae.getSource()==save){
            exo.setCodeExercise(result);
            labelInstruction.setText(exo.getCodeExercise());
            //labelInstruction.repaint();
        }
    }
    
    public void chooseMode(TortueG mode){
        if (mode==colorTurtle){
            colorLabel = new JLabel("Choose a color for your Color Turtle:");
            black = new JButton(new ImageIcon(getClass().getResource("/images/blackcolor_opt.png")));
            black.addActionListener(this);
            
            red = new JButton(new ImageIcon(getClass().getResource("/images/red_opt.png")));
            red.addActionListener(this);
            
            blue = new JButton(new ImageIcon(getClass().getResource("/images/blue_opt.png")));
            blue.addActionListener(this);
            
            green = new JButton(new ImageIcon(getClass().getResource("/images/green_opt.png")));
            green.addActionListener(this);
            
            yellow = new JButton(new ImageIcon(getClass().getResource("/images/yellow_opt.jpg")));
            yellow.addActionListener(this);
            
            magenta = new JButton(new ImageIcon(getClass().getResource("/images/magenta_opt.png")));
            magenta.addActionListener(this);
            
            panelColor = new JPanel();
            panelColor.setLayout(new GridLayout(1,6));
            panelColor.add(black);
            panelColor.add(red);
            panelColor.add(blue);
            panelColor.add(green);
            panelColor.add(yellow);
            panelColor.add(magenta);
            
            panelGlobal = new JPanel();
            panelGlobal.setLayout(new GridLayout(2,1));
            panelGlobal.add(colorLabel);
            panelGlobal.add(panelColor);
            
            secondFrame = new JFrame();

            secondFrame.add(panelGlobal);
            secondFrame.setResizable(true);
            secondFrame.pack();
            secondFrame.setVisible(true);
            
        }else if (mode==fastTurtle){
            fastLabel = new JLabel("Set the initial speed of your turtle:");
            setSpeed = new JButton("Set Speed");
            setSpeed.addActionListener(this);
            
            check1 = new JRadioButton("1");
            check2 = new JRadioButton("2");
            check3 = new JRadioButton("3");
            check4 = new JRadioButton("4");
            check5 = new JRadioButton("5");
            panelRadioButtons = new JPanel();
            panelRadioButtons.add(check1);
            panelRadioButtons.add(check2);
            panelRadioButtons.add(check3);
            panelRadioButtons.add(check4);
            panelRadioButtons.add(check5);
            
            //textSpeed = new JTextField();
            comboSpeed = new JComboBox();
            comboSpeed.addItem(1);
            comboSpeed.addItem(2);
            comboSpeed.addItem(3);
            comboSpeed.addItem(4);
            comboSpeed.addItem(5);
            comboSpeed.addItem(6);
            comboSpeed.addItem(7);
            //textSpeed = new JFormattedTextField();
            
            panelGlobal2 = new JPanel();
            panelGlobal2.setLayout(new GridLayout(3,1));
            panelGlobal2.add(fastLabel);
            panelGlobal2.add(panelRadioButtons);
            panelGlobal2.add(setSpeed);
            thirdFrame = new JFrame();
            
            thirdFrame.add(panelGlobal2);
            thirdFrame.setResizable(true);
            thirdFrame.pack();
            thirdFrame.setVisible(true);
            
        }

    }
    
    
    public CreateExercise(TortueG mode){
        normalTurtle = new TortueG();
        colorTurtle = new TortueCouleur();
        fastTurtle = new TortueRapide();
                
        exo = new Exercise();
        newTurtle = mode; //set the newTurtle by default
        
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
        
        save = new JButton("Save");
        save.addActionListener(this);
        
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
        panelRight.setLayout(new GridLayout(5,1));
        panelRight.add(panelLabel);
        panelRight.add(panelMode);
        panelRight.add(panelButtonsRight);
        panelRight.add(panelArrows);
        panelRight.add(save);
        
        myFrame = new JFrame();
        JPanel canv = Canvas.getCanvasPanel();
        myFrame.add(canv, BorderLayout.CENTER);
        myFrame.add(panelRight, BorderLayout.EAST);
        
        //myFrame = new JFrame("Create Exercise");//give the name to the frame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window
            
        myFrame.setVisible(true);
        myFrame.pack();
    }
    

    
}
