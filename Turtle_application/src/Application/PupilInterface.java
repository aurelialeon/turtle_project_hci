package Application;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * 07/03/2018
 * @author Felix
 */
public final class PupilInterface extends JFrame{
    private JPanel pupilInterface;
    private JButton enterSubmitBtn, exerciceBtn, attemptVisuBtn, resultVisuBtn;
    private JLabel imageEnter;
    private JTextField pupilLogin;

    public PupilInterface() {
        
        //---General settings-------
        this.setTitle("Pupil Interface");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //---Panels-----------------
        pupilInterface = new JPanel();
        pupilInterface.setBackground(Color.WHITE);
        pupilInterface.setPreferredSize(new Dimension(200,50));
        
        //---Buttons----------------
        enterSubmitBtn = new JButton ();
        exerciceBtn = new JButton ();
        attemptVisuBtn = new JButton ();
        resultVisuBtn = new JButton ();
        this.add(enterSubmitBtn,BorderLayout.SOUTH);
        
        //---Labels-----------------
        //imageEnter = new JLabel();
        //imageEnter.setIcon(new ImageIcon(PupilInterface.class.getResource("/images/satisfiedSmiley.png")));
        //this.add(imageEnter,BorderLayout.WEST);
        
        //---TextField--------------
        pupilLogin = new JTextField();
        this.add(pupilLogin,BorderLayout.EAST);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true); // Setting the frame visible
    }
}


        /*
        //---Contener/Frame---------
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.BLACK);
        //Instantiate the grid------
        GridBagConstraints gbc = new GridBagConstraints(); */