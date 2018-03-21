/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author manonsacre
 */
public class ActListEcouteur implements ActionListener{

    private HomePage hp;
    
    public ActListEcouteur(HomePage acc) {
        hp = acc;
    }
    
    public void actionPerformed(ActionEvent ae){
        hp.actionPerformed(ae);
    }
    
}
