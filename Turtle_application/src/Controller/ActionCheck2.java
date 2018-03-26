/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.CreateOneExercise;
import Interface.TortueCouleur;
import Interface.TortueG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Utilisateur
 */
public class ActionCheck2 implements ActionListener{
    private CreateOneExercise coe;
    private JRadioButton butt;
    private JButton speedUp, slowDown;
    private TortueCouleur colorTurtle;
    private ImageIcon black, red, blue, green, yellow, magenta;
    
    public ActionCheck2(CreateOneExercise c, JRadioButton b, JButton su, JButton sd){
        coe = c;
        butt = b;
        speedUp = su;
        slowDown = sd;
        black = new ImageIcon(getClass().getResource("/images/blackcolor_opt.png"));
        
        red = new ImageIcon(getClass().getResource("/images/red_opt.png"));

        blue = new ImageIcon(getClass().getResource("/images/blue_opt.png"));
            
        green = new ImageIcon(getClass().getResource("/images/green_opt.png"));
            
        yellow = new ImageIcon(getClass().getResource("/images/yellow_opt.jpg"));
            
        magenta =new ImageIcon(getClass().getResource("/images/magenta_opt.png"));

        
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==butt){
            //colorTurtle = new TortueCouleur();
            //coe.setNewTurtle(colorTurtle);
            //coe.getEx().setModeC(null);
            coe.getEx().setModeG(null);
            coe.getEx().setModeR(null);
            speedUp.setEnabled(false);
            slowDown.setEnabled(false);
            coe.getNewTurtle().reset();
            coe.setResult("");
            //coe.chooseMode(coe.getColorTurtle());
            Object[] choix = {black, red, blue, green, yellow, magenta};
            int n = JOptionPane.showOptionDialog(null,"Choose a color for your Color Turtle:",
    	        "Mode",
    	        JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, choix, null);
            if (n==0){
                coe.setNewTurtle(new TortueCouleur("black"));
                coe.getEx().setModeC(new TortueCouleur("black"));
            }else if (n==1){
                coe.setNewTurtle(new TortueCouleur("red"));
                coe.getEx().setModeC(new TortueCouleur("red"));
            }else if (n==2){
                coe.setNewTurtle(new TortueCouleur("blue"));
                coe.getEx().setModeC(new TortueCouleur("blue"));
            }else if (n==3){
                coe.setNewTurtle(new TortueCouleur("green"));
                coe.getEx().setModeC(new TortueCouleur("green"));
            }else if (n==4){
                coe.setNewTurtle(new TortueCouleur("yellow"));
                coe.getEx().setModeC(new TortueCouleur("yellow"));
            }else if (n==5){
                coe.setNewTurtle(new TortueCouleur("magenta"));
                coe.getEx().setModeC(new TortueCouleur("magenta"));
            }
        }
    }
}
