package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JLabel;

/**
 * 07/03/2018
 * @author Felix
 */
public final class PupilInterface extends JFrame implements ActionListener{
    private final JPanel pupilInterface;
    private final JButton enterSubmitBtn;
    private final JTextField pupilLogin;

    public PupilInterface() {
        
        //---General settings-------
        this.setTitle("Pupil Interface");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //---Panel-----------------
        pupilInterface = new JPanel();
        pupilInterface.setBackground(Color.WHITE);
        pupilInterface.setPreferredSize(new Dimension(200,50));
        
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
        this.setVisible(true); // Setting the frame visible
    }
    
    public void actionPerformed(ActionEvent e)//rend le bouton actif
    {
        if (e.getSource() == enterSubmitBtn) {
            AcceuilPupil acceuilPupil = new AcceuilPupil(); 
            this.dispose();
        }
    }
}


        /*
        //---Contener/Frame---------
        Container myContainer = this.getContentPane();
        myContainer.setLayout(new GridBagLayout());
        myContainer.setBackground(Color.BLACK);
        //Instantiate the grid------
        GridBagConstraints gbc = new GridBagConstraints(); */