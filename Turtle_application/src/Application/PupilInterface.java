package Application;
import Controller.ControllerLogPupil;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import javax.swing.JLabel;
import turtle_project_hci.RequestSQLite;

/**
 * 07/03/2018
 * @author Felix
 */
public final class PupilInterface extends JPanel {
    //private final JPanel pupilInterface;
    private final JButton enterSubmitBtn;
    private final JTextField pupilLogin;
    private final JLabel satisfyiedSmileyImage;
    private ControllerLogPupil clp;
    private JFrame jfp;
    
    public PupilInterface(JFrame hp) {
        //---General settings-------
        //this.setTitle("Pupil Interface");
        jfp = hp;
        
        this.setSize(1200,800);

        this.setLayout(new BorderLayout());
        
        //---Images----------------
        satisfyiedSmileyImage = new JLabel();
        satisfyiedSmileyImage.setIcon(new ImageIcon(PupilInterface.class.getResource("/Images/hello.gif")));
        satisfyiedSmileyImage.setPreferredSize(new Dimension(480,370));
        satisfyiedSmileyImage.setEnabled(true);
        satisfyiedSmileyImage.setBackground(Color.WHITE);
        this.add(satisfyiedSmileyImage, BorderLayout.CENTER);

        //---Button----------------
        enterSubmitBtn = new JButton ("Connection");
        this.add(enterSubmitBtn,BorderLayout.SOUTH);
        clp = new ControllerLogPupil(this, enterSubmitBtn);
        enterSubmitBtn.addActionListener(clp);

        //---TextField--------------
        pupilLogin = new JTextField();
        this.add(pupilLogin,BorderLayout.NORTH);
        
        //---Settings de fin--------
        this.setVisible(true);
    }   

    public JTextField getPupilLogin() {
        return pupilLogin;
    }

    public JFrame getJfp() {
        return jfp;
    }
    
    public void setPanel(JPanel panel, JFrame frame) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.pack();
        frame.setSize(1200,800);
        //myFrame.setVisible(true);
    }
}

