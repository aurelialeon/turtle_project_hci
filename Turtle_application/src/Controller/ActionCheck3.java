/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateOneExercise;
import Interface.TortueCouleur;
import Interface.TortueG;
import Interface.TortueRapide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Utilisateur
 */
public class ActionCheck3 implements ActionListener{
    private CreateOneExercise coe;
    private JRadioButton butt;
    private JButton speedUp, slowDown;
    private TortueRapide fastTurtle;
    private JRadioButton check1Bis, check2Bis, check3Bis, check4Bis, check5Bis;

    
    public ActionCheck3(CreateOneExercise c, JRadioButton b, JButton su, JButton sd){
        coe = c;
        butt = b;
        speedUp = su;
        slowDown = sd;
        /**check1Bis = new JRadioButton("1");
        check2Bis = new JRadioButton("2");
        check3Bis = new JRadioButton("3");
        check4Bis = new JRadioButton("4");
        check5Bis = new JRadioButton("5");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(check1Bis);
        group2.add(check2Bis);
        group2.add(check3Bis);
        group2.add(check4Bis);
        group2.add(check5Bis);*/
        
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==butt){
            fastTurtle = new TortueRapide();
            coe.setNewTurtle(fastTurtle);
            coe.getEx().setModeC(null);
            coe.getEx().setModeG(null);
            coe.getEx().setModeR(fastTurtle);
            speedUp.setEnabled(true);
            slowDown.setEnabled(true);
            coe.getNewTurtle().reset();
            coe.setResult("");
            //coe.chooseMode(coe.getFastTurtle());

            
            Object[] choix = {"1", "2", "3", "4", "5"};
            int n = JOptionPane.showOptionDialog(null,"Set the initial speed of your turtle:",
    	        "Mode",
    	        JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, choix, null);
            if (n==0){
                //coe.getEx().setModeR(new TortueRapide());
                fastTurtle.setVitesse(1);
                coe.setNewTurtle(fastTurtle);
                
                
            }else if (n==1){
                fastTurtle.setVitesse(2);
                coe.setNewTurtle(fastTurtle);
                //coe.getEx().setModeR(new TortueRapide());
            }else if (n==2){
                fastTurtle.setVitesse(3);
                coe.setNewTurtle(fastTurtle);
                //coe.getEx().setModeR(new TortueRapide());
            }else if (n==3){
                fastTurtle.setVitesse(4);
                coe.setNewTurtle(fastTurtle);
                //coe.getEx().setModeR(new TortueRapide());
            }else if (n==4){
                fastTurtle.setVitesse(5);
                coe.setNewTurtle(fastTurtle);
                //coe.getEx().setModeR(new TortueRapide());
            }
        }
    }
}
