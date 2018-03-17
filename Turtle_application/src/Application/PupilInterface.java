package Application;
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
public final class PupilInterface extends JFrame implements ActionListener{
    //private final JPanel pupilInterface;
    private final JButton enterSubmitBtn;
    private final JTextField pupilLogin;
    private final JLabel satisfyiedSmileyImage;
    
    public PupilInterface() {
        //---General settings-------
        this.setTitle("Pupil Interface");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //---Images----------------
        satisfyiedSmileyImage = new JLabel();
        satisfyiedSmileyImage.setIcon(new ImageIcon(PupilInterface.class.getResource("/Images/AccueilPupil.png")));
        satisfyiedSmileyImage.setPreferredSize(new Dimension(250,250));
        satisfyiedSmileyImage.setEnabled(true);
        satisfyiedSmileyImage.setBackground(Color.WHITE);
        this.add(satisfyiedSmileyImage, BorderLayout.WEST);

        //---Button----------------
        enterSubmitBtn = new JButton ("Connection");
        this.add(enterSubmitBtn,BorderLayout.SOUTH);
        enterSubmitBtn.addActionListener(this);

        //---TextField--------------
        pupilLogin = new JTextField();
        this.add(pupilLogin,BorderLayout.NORTH);
        
        //---Settings de fin--------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }   
   
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == enterSubmitBtn) {
            String login = pupilLogin.getText();
            
            boolean fetchLog;
            RequestSQLite req = new RequestSQLite();
            fetchLog = req.fetchLogin(login);
            
            if (fetchLog == true){
                System.out.println(fetchLog);
                AcceuilPupil acceuilPupil = new AcceuilPupil();
                this.dispose();
            }
        }
   }
}

