/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author manonsacre
 */
public class Menu_Teacher extends JFrame implements ActionListener{
    
    private JSplitPane split;
    private JPanel menuPanel;
    private JButton createB, modifyB, exploreB, evaluationB;

    public Menu_Teacher() {
        
        
        this.setTitle("Menu Teacher");
        
        split = new JSplitPane();
        split.setOneTouchExpandable(true);
        split.setContinuousLayout(true);
        getContentPane().add(split);
        
        createB = new JButton("◊ Create exercice");
        createB.addActionListener(this);
        
        modifyB = new JButton("◊ Modify exercice");
        modifyB.addActionListener(this);
        
        exploreB = new JButton("◊ Explore class");
        exploreB.addActionListener(this);
        
        evaluationB = new JButton("◊ Evaluation");
        evaluationB.addActionListener(this);
        
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
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(3000, 3000);
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == createB) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        } else if (e.getSource() == modifyB) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        } else if (e.getSource() == exploreB) {
            Exploration ex = new Exploration();
            ex.createTree();
            this.dispose();
        } else if (e.getSource() == evaluationB) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        }
    }
    
}
