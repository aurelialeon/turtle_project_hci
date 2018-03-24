/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import Controller.ActionAccueilExPupil;
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
public final class AccueilExPupil extends JFrame
{

    private Exercise myExercise;

    private JButton backward, thisExercise;
    private JLabel text;
    private JFrame frameOne, frameAEP;
    
    private JComboBox combo;




    
/**
 * Constructor of ExercicePupil
 */
    public AccueilExPupil (JFrame frame) {

        frameAEP = frame;
        
        //myExercise = new Exercise();
        
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
        ActionAccueilExPupil ep = new ActionAccueilExPupil(this, backward);
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
        if (e.getSource() == thisExercise){
            frameOne.dispose();
            ExercisePupil aep = new ExercisePupil(myExercise);

        }
   

    }

    public JFrame getFrameAEP() {
        return frameAEP;
    }
    
   public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }
    
}
