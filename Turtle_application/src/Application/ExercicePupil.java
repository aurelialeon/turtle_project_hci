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
import javax.swing.JComboBox;
import turtle_project_hci.RequestSQLite;

 
/**
 * @author Felix
 */
public final class ExercicePupil extends JFrame implements ActionListener
{
    private JButton backward;
    private JLabel text;
    private TortueG tortueR, tortueC,tortueN;
    private Exercise myExercise;
    private JComboBox combo;
    
/**
 * Constructor of ExercicePupil
 */
    public ExercicePupil () {
               
        //---General settings-------

        this.setTitle("Exercises");
        this.setPreferredSize(new Dimension(800, 400));
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
        gbc.gridy = 1;
        text = new JLabel("Choose an exercise it is time to exercise !");
        this.add(text, gbc);
              
        // Combo box : menu déroulant avec la liste des exercices
        gbc.gridy = 2;
        combo = new JComboBox(); // Création de la combobox
        combo.setPreferredSize(new Dimension(100, 20));
        ArrayList<Exercise> p = new ArrayList<>();
        RequestSQLite req = new RequestSQLite();
        p = req.fetchAllExerciseName();
        for (Exercise ex : p) {
            combo.addItem(ex.getNameExercise());
        }
        this.add(combo,gbc);
        combo.addItemListener(new ItemState());
        

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
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backward) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }
        
        //if (e.getSource() == thisExercise) {
            //TheExercisePupil theExo = new TheExercisePupil();
            //this.dispose();
            
        }
    }