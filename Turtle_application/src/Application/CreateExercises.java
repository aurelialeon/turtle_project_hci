/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.ActionsCreationExercise;
import Interface.Canvas;
import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
public class CreateExercises extends JPanel 
{
    private JLabel titre, nameEx,instruction; 
    //Fields that teachers fill out for exercise name and instructions
    private JTextField nameExo, consigne; 
    private JPanel panel1,panel2,panel3,paneltot;
    // Boutton to create the draw
    private JButton exo;
    private TortueG tortueN, newTurtle;
    private TortueRapide tortueR;
    private TortueCouleur tortueC;
    //Buttons to choose the mode of the eercice
    private JRadioButton check1, check2, check3;
    private Exercise myExercise;
    
    private JFrame firstFrame;
   
    private JButton normal, color, fast, write, unwrite, speedUp, slowDown;
    private JButton forward, backward, left, right, move, restart, save;
    private JPanel panelArrows, panelLabel, panelMode, panelButtonsRight, panelRight, panelPage;
    private JLabel myEmptyLabel, labelInstruction, labelMode;
    private JFrame myFrame, secondFrame, thirdFrame;
    private String result="";

    // for the second frame
    private JLabel colorLabel, fastLabel;
    private JButton black, red, blue, green, yellow, magenta, setSpeed;
    private JPanel panelColor, panelGlobal, panelGlobal2, panelRadioButtons, canv;
    private String c;
    private JComboBox comboSpeed;
    private JRadioButton check1Bis, check2Bis, check3Bis, check4Bis, check5Bis;
            
    private JFrame controlFrame;
/**
 * Constructor of CreateExerciseClass
 */
    public CreateExercises(JFrame fra) {
        
        controlFrame = fra;
        
        ActionsCreationExercise p = new ActionsCreationExercise(this);
        myExercise = new Exercise();
        
        tortueR = new TortueRapide();
        tortueC = new TortueCouleur();
        tortueN = new TortueG();
        
        normal = new JButton("Graphical Turtle");
        normal.addActionListener(p);
        
        color = new JButton("Color Turtle");
        color.addActionListener(p);
        
        fast = new JButton("Fast Turtle");
        fast.addActionListener(p);
        
        forward = new JButton(new ImageIcon(getClass().getResource("/images/arrowN.png")));
        forward.addActionListener(p);
        
        backward = new JButton(new ImageIcon(getClass().getResource("/images/arrowS.png")));
        backward.addActionListener(p);
        
        left = new JButton(new ImageIcon(getClass().getResource("/images/arrowW.png")));
        left.addActionListener(p);
        
        right = new JButton(new ImageIcon(getClass().getResource("/images/arrowE.png")));
        right.addActionListener(p);
        
        move = new JButton("Move");
        move.addActionListener(p);
        
        restart = new JButton("Restart");
        restart.addActionListener(p);
        
        write = new JButton("Write");
        write.addActionListener(p);
        
        unwrite = new JButton("Unwrite");
        unwrite.addActionListener(p);
        
        speedUp = new JButton("Speed Up");
        speedUp.addActionListener(p);
        speedUp.setEnabled(false);
        
        slowDown = new JButton("Slow Down");
        slowDown.addActionListener(p);
        slowDown.setEnabled(false);
        
        save = new JButton("Save");
        save.addActionListener(p);
        
        black = new JButton(new ImageIcon(getClass().getResource("/images/blackcolor_opt.png")));
        black.addActionListener(p);
            
        red = new JButton(new ImageIcon(getClass().getResource("/images/red_opt.png")));
        red.addActionListener(p);
         
        blue = new JButton(new ImageIcon(getClass().getResource("/images/blue_opt.png")));
        blue.addActionListener(p);
        
        green = new JButton(new ImageIcon(getClass().getResource("/images/green_opt.png")));
        green.addActionListener(p);
            
        yellow = new JButton(new ImageIcon(getClass().getResource("/images/yellow_opt.jpg")));
        yellow.addActionListener(p);
            
        magenta = new JButton(new ImageIcon(getClass().getResource("/images/magenta_opt.png")));
        magenta.addActionListener(p);
            
        setSpeed = new JButton("Set Speed");
        setSpeed.addActionListener(p);
                
        
        titre = new JLabel("Creation exercise", JLabel.CENTER);
        
        panel1 = new JPanel();
        

        panel1.setLayout(new GridLayout(1,1));
        nameEx= new JLabel("Enter the name of the exercise");
        nameExo = new JTextField();
        
        panel1.add(nameEx, BorderLayout.SOUTH);
        panel1.add(nameExo, BorderLayout.SOUTH);
        
        panel2 =new JPanel();
        panel2.setLayout(new GridLayout(1,3));
        check1 = new JRadioButton("Classical turtle");
        check2 = new JRadioButton("Color turtle");
        check3 = new JRadioButton("Speed turtle");
        panel2.add(check1);
        panel2.add(check2);
        panel2.add(check3);
        
        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,1));
        instruction= new JLabel("Enter the instructions of the exercise");
        consigne = new JTextField();
        exo =new JButton();
        exo.setText("Create the draw");
        exo.addActionListener(p);
        panel3.add(instruction);
        panel3.add(consigne);
        panel3.add(exo);
        
        
        paneltot= new JPanel();
        paneltot.setLayout(new BorderLayout());
        paneltot.add(panel1,BorderLayout.NORTH);
        paneltot.add(panel2,BorderLayout.CENTER);
        paneltot.add(panel3,BorderLayout.SOUTH);
        
        firstFrame = new JFrame();
        firstFrame.add(paneltot);
        
        firstFrame.add(titre, BorderLayout.NORTH);
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.setResizable(true);
        firstFrame.pack();
        firstFrame.setVisible(true);
    }
    
    public void chooseMode(TortueG mode){
        //ActionsCreationExercise p = new ActionsCreationExercise(this);
        if (mode== tortueC){
            colorLabel = new JLabel("Choose a color for your Color Turtle:");
            
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
            secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            secondFrame.setResizable(true);
            secondFrame.pack();
            secondFrame.setVisible(true);
            
        }else if (mode== tortueR){
            fastLabel = new JLabel("Set the initial speed of your turtle:");
            
            check1Bis = new JRadioButton("1");
            check2Bis = new JRadioButton("2");
            check3Bis = new JRadioButton("3");
            check4Bis = new JRadioButton("4");
            check5Bis = new JRadioButton("5");
            panelRadioButtons = new JPanel();
            panelRadioButtons.add(check1Bis);
            panelRadioButtons.add(check2Bis);
            panelRadioButtons.add(check3Bis);
            panelRadioButtons.add(check4Bis);
            panelRadioButtons.add(check5Bis);
            
            
            panelGlobal2 = new JPanel();
            panelGlobal2.setLayout(new GridLayout(3,1));
            panelGlobal2.add(fastLabel);
            panelGlobal2.add(panelRadioButtons);
            panelGlobal2.add(setSpeed);
            
            thirdFrame = new JFrame();
            
            thirdFrame.add(panelGlobal2);
            thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            thirdFrame.setResizable(true);
            thirdFrame.pack();
            thirdFrame.setVisible(true);

        }
    }
    
    public void createOneExercise(TortueG mode){
        //ActionsCreationExercise p = new ActionsCreationExercise(this);

        newTurtle = mode;
        
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
        canv = Canvas.getCanvasPanel();
        myFrame.add(canv, BorderLayout.CENTER);
        myFrame.add(panelRight, BorderLayout.EAST);
        
        //myFrame = new JFrame("Create Exercise");//give the name to the frame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the application when we close the window

            
        myFrame.setVisible(true);
        myFrame.pack();
    }
    
    public void press(ActionEvent ae) {
        if (check1.isSelected()){
            check2.setSelected(false);
            check3.setSelected(false);
            myExercise.setModeG(tortueN);
            if (ae.getSource()== exo){
                //TortueG tg = new TortueG();
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                CreateOneExercise newExercise = new CreateOneExercise(myExercise);
                firstFrame.dispose();
            }
        } else if (check2.isSelected()){
            check1.setSelected(false);
            check3.setSelected(false);
            myExercise.setModeC(tortueC);
            if (ae.getSource()== exo){
                //TortueCouleur tc = new TortueCouleur();
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                CreateOneExercise newExercise = new CreateOneExercise(myExercise);
                firstFrame.dispose();
            }
        }
        else if (check3.isSelected()){
            check1.setSelected(false);
            check2.setSelected(false);
            myExercise.setModeR(tortueR);
            if (ae.getSource()== exo){
                //TortueRapide tr = new TortueRapide();
                myExercise.setInstruction(consigne.getText());
                myExercise.setNameExercise(nameExo.getText());
                
                CreateOneExercise newExercise = new CreateOneExercise(myExercise);
                firstFrame.dispose();
            }
        }
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

    public void setResult(String result) {
        this.result = result;
    }
        
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }

    public JFrame getControlFrame() {
        return controlFrame;
    }
     
}
