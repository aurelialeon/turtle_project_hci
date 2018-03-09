/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import turtle_project_hci.Donnees;
import turtle_project_hci.Class;
import turtle_project_hci.Pupil;

/**
 *
 * @author manonsacre
 */
public class Exploration extends JFrame implements ActionListener{

    private JMenuItem createI, modifyI, exploreI, evaluationI, addClassI, addPupI, backMenu; 
    private Donnees don;
    private JTree tree;
    private DefaultMutableTreeNode top;
    
    public Exploration() {
        
        this.setTitle("Exploration");
        
        don = new Donnees();
        
        top = new DefaultMutableTreeNode((don.getTeach1().getFName() + " " + don.getTeach1().getTName()));
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        //tree.addTreeSelectionListener();
        
        tree.setRootVisible(true);
        
        // Creation and Instantiation of the Menubar
        JMenuBar menuBar = new JMenuBar(); 
        
        // Creation and Instantiation of the Menubar
        JMenu menu = new JMenu("Menu");
        
        createI = new JMenuItem("Create exercice"); 
        modifyI = new JMenuItem("Modify exercice");
        exploreI = new JMenuItem("Explore Class");
        evaluationI = new JMenuItem("Evaluation");
        addClassI = new JMenuItem("New Class");
        addPupI = new JMenuItem("New Pupil");
        backMenu = new JMenuItem("Back to the menu");
        
        // Add the items to the menu 
        menu.add(createI);
        menu.add(modifyI);
        menu.add(exploreI);
        menu.add(evaluationI);
        menu.add(addClassI);
        menu.add(addPupI);
        menu.add(backMenu);
        
        // Add our menu to the menubar
        menuBar.add(menu);
        
        // Display the menubar in the frame
        this.setJMenuBar(menuBar);
        
        createI.addActionListener(this);
        modifyI.addActionListener(this);
        exploreI.addActionListener(this);
        evaluationI.addActionListener(this);
        addClassI.addActionListener(this);
        addPupI.addActionListener(this);
        backMenu.addActionListener(this);
        
        this.add(tree);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(3000, 3000);
        this.pack();
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == createI) {
            CreateExercises ce = new CreateExercises();
            this.dispose();
        } else if (e.getSource() == modifyI) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        } else if (e.getSource() == exploreI) {
            //Identification_Teacher id = new Identification_Teacher(); 
            this.dispose();
        } else if (e.getSource() == evaluationI) {
            //Identification_Teacher id = new Identification_Teacher(); "
            this.dispose();
        } else if (e.getSource() == backMenu) {
            Menu_Teacher menu = new Menu_Teacher(); 
            this.dispose();
        }
    }
    
    public void createTree() {
        for (Class classe : don.getTeach1().getListClass()) {
            DefaultMutableTreeNode laClasse = new DefaultMutableTreeNode(
                    (classe.getNameClass()));
            for (Pupil pup : classe.getPupils()) {
                System.out.println(pup);
                DefaultMutableTreeNode eleve = new DefaultMutableTreeNode((pup.getPFName() + " " + pup.getPName()));
                laClasse.add(eleve);
            }
            top.add(laClasse);
        }
    }
}
