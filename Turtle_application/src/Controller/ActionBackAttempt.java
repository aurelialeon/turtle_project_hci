package Controller;

import Application.AcceuilPupil;
import Application.AttemptVisu;
import Application.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author cleme
 */
public class ActionBackAttempt implements ActionListener {
    private AttemptVisu att; 
    private JButton but;
    private HomePage hp;
    
    public ActionBackAttempt (AttemptVisu av, JButton button) {
        att = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) {
            hp = new HomePage(); 
            hp.setPanel(new AcceuilPupil());
        }
    }
}
