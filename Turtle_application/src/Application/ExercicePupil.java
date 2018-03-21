/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
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
import javax.swing.JComboBox;
import turtle_project_hci.RequestSQLite;




/**
 * @author Felix
 */
public final class ExercicePupil extends JFrame
{

    private JButton backward, thisExercise;
    private JLabel text, instruLabel, picLabel, myEmptyLabel;
    private TortueG tortueN, newTurtle;
    private TortueCouleur tortueC;
    private TortueRapide tortueR;


    private Exercise myExercise;

    
    private JFrame myFrame, frameOne, frameTwo;
    private JButton write, unwrite, speedUp, slowDown;
    private JButton forward, back, left, right, move, restart, save, start;
    
    private JComboBox combo;
    private JPanel canv, canvToFill, panelArrows, panelButtonsRight, panelRight;
    private String answer = "";



    
/**
 * Constructor of ExercicePupil
 */
    public ExercicePupil () {
        ActionExPupil ep = new ActionExPupil(this);

        myExercise = new Exercise();
        
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
        backward.addActionListener(ep);
        
        //---Grid 0, 3 -------------
        gbc.gridy = 1;
        text = new JLabel("Choose an exercise it is time to exercise !");

        frameOne.add(text, gbc);

        // Combo box : menu deroulant avec la liste des exercices
        gbc.gridy = 2;
        combo = new JComboBox(); // Creation de la combobox

        combo.setPreferredSize(new Dimension(400, 200));

        ArrayList<Exercise> p = new ArrayList<>();
        RequestSQLite req = new RequestSQLite();
        p = req.fetchAllExerciseName();
        for (Exercise exercise : p) {
            combo.addItem(exercise.getNameExercise());
        }
        frameOne.add(combo,gbc);
        //combo.addItemListener(new ItemState());
        for (Exercise exercise : p){
            if (exercise.getNameExercise()==combo.getSelectedItem()){
                myExercise = exercise;
            }
        }
        
        gbc.gridy=4;
        thisExercise = new JButton("Exercise");
        frameOne.add(thisExercise, gbc);
        thisExercise.addActionListener(ep);

        
        //---Settings de fin--------
        frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOne.setResizable(true);
        frameOne.pack();
        frameOne.setVisible(true); // Setting the frame visible
        
        
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
        
    }
    
    /**
     * Class interne
     */
    class ItemState implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            System.out.println("événement déclenché sur : " + e.getItem());
    }
    }
    /*
    public void exerciceList () {
        exo.setListAttempt(ArrayList<Attempt> listAttempt);
    }*/
    
    public void press(ActionEvent e)
    {
        if (e.getSource() == backward) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }
        
        if (e.getSource() == thisExercise) {
            //char lastChar = myExercise.getCodeExercise().charAt(myExercise.getCodeExercise().length() - 1);
            //for(char c = myExercise.getCodeExercise().charAt(0); c != lastChar; c++){
            frameOne.dispose();
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
        }else if (e.getSource() == start){
            myFrame.dispose();
            start();
        }else if (e.getSource() == forward){
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
