package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

public class ApprovalGUI extends JFrame implements ActionListener{

    static JFrame f1;

    // Labels to display text
    static JLabel l1, l2, l3, l4, l5;
    
    static InfectedUserData immigrantDataForm;

public static void loadApprovalScreen(InfectedUserData form) {
    f1 = new JFrame("Disease Management System - Approve Data");

    ApprovalGUI gui = new ApprovalGUI();

    //set the frame to visible
    f1.setVisible(true);

    //maximize the screen size
    f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

            l1 = new JLabel("Entered Name: " + form.getName());
            l2 = new JLabel("Entered Email: " + form.getEmail());
            l3 = new JLabel("Entered Birthdate: " + form.getBirthdate());
            l4 = new JLabel("Entered Number of Children: " + form.getNumChildren());
            l5 = new JLabel("Entered Disease Data: " + form.getData());

            JPanel p = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets.set(5, 5, 5, 5);

            //add title to top
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;

            //reset gridwidth
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;

            gbc.gridy++;
            p.add(l1, gbc);
            gbc.gridy++;
            p.add(l2, gbc);
            gbc.gridy++;
            p.add(l3, gbc);
            gbc.gridy++;
            p.add(l4, gbc);
            gbc.gridy++;
            p.add(l5, gbc);
            gbc.anchor = GridBagConstraints.CENTER;

            f1.add(p);

}

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}

}