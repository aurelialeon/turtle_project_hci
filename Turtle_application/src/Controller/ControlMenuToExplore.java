/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Exploration;
import Application.Menu_Teacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;
import turtle_project_hci.Donnees;
import turtle_project_hci.Pupil;

/**
 *
 * @author manonsacre
 */
public class ControlMenuToExplore implements ActionListener{
    private Menu_Teacher mt;
    private JButton but;
    private Donnees don;
    private DefaultMutableTreeNode racine;
    
    public ControlMenuToExplore (Menu_Teacher av, JButton button) {
        mt = av; 
        but = button;
        racine = new DefaultMutableTreeNode((don.getTeach1().getFName() + " " + don.getTeach1().getTName()));
        don = new Donnees();
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) { 
            //Exploration ex = new Exploration();
            //ex.createTree();
            //mt.setPanel(new Exploration(mt.getMenuFrame()), mt.getMenuFrame());
        }
    } 
    
    public void createTree() {
        //for (Class classe : id.getCurrentTeacher().getListClass(id.getCurrentTeacher())) {
        for (turtle_project_hci.Class classe : don.getTeach1().getListClass()) {
            DefaultMutableTreeNode laClasse = new DefaultMutableTreeNode(
                    (classe.getNameClass()));
            for (Pupil pup : classe.getPupils()) {
                System.out.println(pup);
                DefaultMutableTreeNode eleve = new DefaultMutableTreeNode((pup.getPFName() + " " + pup.getPName()));
                laClasse.add(eleve);
            }
            racine.add(laClasse);
        }
    }
}
