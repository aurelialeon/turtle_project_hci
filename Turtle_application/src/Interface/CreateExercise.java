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
    private TortueG currentTurtle, normalTurtle;
    private TortueCouleur colorTurtle;
    private TortueRapide fastTurtle;
    private JButton normal, color, fast, write, unwrite, speedUp, slowDown;
    private JButton forward, backward, left, right, move, restart;
    private JPanel panelArrows, panelLabel, panelMode, panelButtonsRight, panelRight, panelPage;
    private JLabel myEmptyLabel, labelInstruction, labelMode;
    private JFrame myFrame, secondFrame;
    
    // for the second frame
    private JLabel colorLabel, fastLabel;
    private JButton black, red, blue, green, yellow, magenta, setSpeed;
    private JPanel panelColor, panelGlobal;
    private JFormattedTextField textSpeed;
    private String c;
    private JComboBox comboSpeed;
    
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == forward){
            while (currentTurtle.getDirection()!=3){
                currentTurtle.tourner();
            }
        }else if (ae.getSource() == left) {
            while (currentTurtle.getDirection()!=2){
                currentTurtle.tourner();
            }
        }else if (ae.getSource() == right){
            while (currentTurtle.getDirection()!=0){
                currentTurtle.tourner();
            }
        }else if (ae.getSource()==backward){
            while (currentTurtle.getDirection()!=1){
                currentTurtle.tourner();
            }
        }else if (ae.getSource()==unwrite){
            currentTurtle.tracer(false);
        }else if (ae.getSource()==write){
            currentTurtle.tracer(true);
        }else if (ae.getSource()== normal){
            currentTurtle = normalTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            currentTurtle.reset();
        }else if (ae.getSource()== color){
            currentTurtle = colorTurtle;
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            currentTurtle.reset();
            chooseMode(colorTurtle);
        }else if (ae.getSource()== fast){
            currentTurtle = fastTurtle;
            speedUp.setEnabled(true);
            slowDown.setEnabled(true);
            currentTurtle.reset();
        }else if (ae.getSource()== move){
            currentTurtle.avancer();
        }else if (ae.getSource()== restart){
            currentTurtle.reset();
        } else if (ae.getSource()==black){
            currentTurtle = new TortueCouleur("black");
            secondFrame.dispose();
        } else if (ae.getSource()==red){
            currentTurtle = new TortueCouleur("red");
            secondFrame.dispose();
        } else if (ae.getSource()==blue){
            currentTurtle = new TortueCouleur("blue");
            secondFrame.dispose();
        } else if (ae.getSource()==green){
            currentTurtle = new TortueCouleur("green");
            secondFrame.dispose();
        } else if (ae.getSource()==yellow){
            currentTurtle = new TortueCouleur("yellow");
            secondFrame.dispose();
        } else if (ae.getSource()==magenta){
            currentTurtle = new TortueCouleur("magenta");
            secondFrame.dispose();
        } else if (ae.getSource()==setSpeed){
            currentTurtle = new TortueRapide();
            //mode.setVitesse(1);
           // s=(int).comboSpeed.getSelectedItem()
            /**String[] speed = {"1", "2", "3", "4", "5", "6", "7"};
            JOptionPane jop = new JOptionPane();
            String getSpeed = (String)jop.showInputDialog(null, 
            "Set the initial speed of your turtle:",
            "Set speed",
            JOptionPane.QUESTION_MESSAGE,
            null,
            speed,
            speed[2]);
            //c = setSpeed.getText();
            //if ("1".equals(c)|"2".equals(c)|"3".equals(c)|"4".equals(c)|"5".equals(c)|"6".equals(c)|"7".equals(c)|"8".equals(c)|"9".equals(c)){
                
            //}*/
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
            
            panelGlobal = new JPanel();
            panelGlobal.setLayout(new GridLayout(3,1));
            panelGlobal.add(fastLabel);
            panelGlobal.add(comboSpeed);
            panelGlobal.add(setSpeed);
            
            secondFrame.add(panelGlobal);
            secondFrame.setResizable(true);
            secondFrame.pack();
            secondFrame.setVisible(true);
            
        }

    }
    
    
    public CreateExercise(TortueG mode){
        normalTurtle = new TortueG();
        colorTurtle = new TortueCouleur();
        fastTurtle = new TortueRapide();
        JPanel canv = Canvas.getCanvasPanel();
        this.add(canv, BorderLayout.CENTER);
        
        currentTurtle = mode; //set the mode by default
        
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
