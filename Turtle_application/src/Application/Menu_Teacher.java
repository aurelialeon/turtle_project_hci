/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.ControlMenuToCreateExercises;
import Controller.ControlMenuToEvalAcc;
import Controller.ControlMenuToExplore;
import Controller.ControlMenuToModif;
import Controller.ControllerMenuToCreateExercises;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import turtle_project_hci.Teacher;

/**
 *
 * @author manonsacre
 */
public class Menu_Teacher extends JPanel {
    
    private JSplitPane split;
    private JPanel menuPanel;
    private JButton createB, modifyB, exploreB, evaluationB;
    private JFrame menuFrame;

    public Menu_Teacher(Teacher t, JFrame fra) {
        
        menuFrame = fra;
        
        //this.setTitle("Menu Teacher");
        
        split = new JSplitPane();
        split.setOneTouchExpandable(true);
        split.setContinuousLayout(true);
        this.add(split);
        
        createB = new JButton("◊ Create exercice");
        ControlMenuToCreateExercises cmtce = new ControlMenuToCreateExercises(this, createB);
        createB.addActionListener(cmtce);
        
        modifyB = new JButton("◊ Modify exercice");
        ControlMenuToModif cmtm = new ControlMenuToModif(this, modifyB);
        modifyB.addActionListener(cmtm);
        
        exploreB = new JButton("◊ Explore class");
        ControlMenuToExplore cmte = new ControlMenuToExplore(this, exploreB);
        exploreB.addActionListener(cmte);
        
        evaluationB = new JButton("◊ Evaluation");
        ControlMenuToEvalAcc cmtea = new ControlMenuToEvalAcc(this, evaluationB);
        evaluationB.addActionListener(cmtea);
        
        JScrollPane scrollPane = new JScrollPane();
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1));
        //scrollPane.setViewportView(tree);
        split.setLeftComponent(menuPanel);
        split.setRightComponent(scrollPane);
        
        menuPanel.add(createB);
        menuPanel.add(modifyB);
        menuPanel.add(exploreB);
        menuPanel.add(evaluationB);
        
        this.setSize(3000, 3000);
        this.setVisible(true);
    }
    
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }

    public JFrame getMenuFrame() {
        return menuFrame;
    }
}