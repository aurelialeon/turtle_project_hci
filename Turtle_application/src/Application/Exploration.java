/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.ControlExploreItemToCreateEx;
import Controller.ControlExploreItemToEval;
import Controller.ControlExploreItemToExplore;
import Controller.ControlExploreItemToMenu;
import Controller.ControlExploreItemToModif;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
public class Exploration extends JPanel{

    private JMenuItem createI, modifyI, exploreI, evaluationI, backMenu; 
    private Donnees don;
    private JTree tree;
    private DefaultMutableTreeNode top;
    private Identification_Teacher id;
    private JFrame exploreFrame;
    
    public Exploration(JFrame fra) {
        
        exploreFrame = fra;
        
        //this.setTitle("Exploration");
        
        //id = new Identification_Teacher();
        id.setVisible(false);
        
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
        backMenu = new JMenuItem("Back to the menu");
        
        // Add the items to the menu 
        menu.add(createI);
        menu.add(modifyI);
        menu.add(exploreI);
        menu.add(evaluationI);
        menu.add(backMenu);
        
        // Add our menu to the menubar
        menuBar.add(menu);
        
        // Display the menubar in the frame
        exploreFrame.setJMenuBar(menuBar);
        
        ControlExploreItemToCreateEx ceitce = new ControlExploreItemToCreateEx(this, createI);
        createI.addActionListener(ceitce);
        ControlExploreItemToModif ceitm = new ControlExploreItemToModif(this, modifyI);
        modifyI.addActionListener(ceitm);
        ControlExploreItemToExplore ceite = new ControlExploreItemToExplore(this, exploreI);
        exploreI.addActionListener(ceite);
        ControlExploreItemToEval ceitev = new ControlExploreItemToEval(this, evaluationI);
        evaluationI.addActionListener(ceitev);
        ControlExploreItemToMenu ceitmenu = new ControlExploreItemToMenu(this, backMenu);
        backMenu.addActionListener(ceitmenu);
        
        this.add(tree);
        
        this.setSize(3000, 3000);
        this.setVisible(true);
        
    }
    
    /*
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
            Menu_Teacher menu = new Menu_Teacher(id.getCurrentTeacher()); 
            this.dispose();
        }
    }
*/
    
    public void createTree() {
        //for (Class classe : id.getCurrentTeacher().getListClass(id.getCurrentTeacher())) {
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
    
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }

    public JFrame getExploreFrame() {
        return exploreFrame;
    }
}
