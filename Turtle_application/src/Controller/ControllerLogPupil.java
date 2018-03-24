/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.AcceuilPupil;
import Application.HomePage;
import Application.Identification_Teacher;
import Application.PupilInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import turtle_project_hci.RequestSQLite;

/**
 *
 * @author manonsacre
 */
public class ControllerLogPupil implements ActionListener{
    private HomePage hp;
    private PupilInterface pi;
    private JButton butt;
    
    public ControllerLogPupil(PupilInterface acc, JButton b) {
        pi = acc;
        butt = b;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == butt) {
            String login = pi.getPupilLogin().getText();
            
            boolean fetchLog;
            RequestSQLite req = new RequestSQLite();
            fetchLog = req.fetchLogin(login);
            
            if (fetchLog == true){
                System.out.println(fetchLog);
                pi.setPanel(new AcceuilPupil(pi.getJfp()), pi.getJfp());
            }
        }
   }
    
}
