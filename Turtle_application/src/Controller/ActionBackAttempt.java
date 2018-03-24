package Controller;

import Application.AttemptVisu;
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
    
    public ActionBackAttempt (AttemptVisu av, JButton button) {
        att = av; 
        but = button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but) {
            // Revenir à la page précédente
        }
    }
}
