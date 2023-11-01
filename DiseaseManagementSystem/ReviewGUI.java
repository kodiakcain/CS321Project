package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

public class ReviewGUI extends JFrame implements ActionListener {
    static JFrame f1;
    // Labels to display text
    static JLabel l1, l2, l3, l4, l5;
    // Add text fields
    static JTextField t1, t2, t3, t4, t5;
    // JButton
    static JButton b;

    public static void loadReviewScreen(String name, String email, String birthdate, String numChildren, String data) {
        f1 = new JFrame("Disease Management System - Review Data");

        ApprovalGUI gui = new ApprovalGUI();

        // Set the frame to visible
        f1.setVisible(true);

        // Maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        l1 = new JLabel("Entered Name: " + name);
        l2 = new JLabel("Entered Email: " + email);
        l3 = new JLabel("Entered Birthdate: " + birthdate);
        l4 = new JLabel("Entered Number of Children: " + numChildren);
        l5 = new JLabel("Entered Disease Data: " + data);

        b = new JButton("Submit for Approval");

        // Make the five text fields
        t1 = new JTextField(16);
        t2 = new JTextField(16);
        t3 = new JTextField(16);
        t4 = new JTextField(16);
        t5 = new JTextField(16);

        // Set the size of the text fields
        Dimension fieldSize = new Dimension(100, 20); // Adjust the size as needed
        t1.setPreferredSize(fieldSize);
        t2.setPreferredSize(fieldSize);
        t3.setPreferredSize(fieldSize);
        t4.setPreferredSize(fieldSize);
        t5.setPreferredSize(fieldSize);

        JPanel p = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(l1, gbc);

        gbc.gridx = 1;
        p.add(t1, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l2, gbc);

        gbc.gridx = 1;
        p.add(t2, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l3, gbc);

        gbc.gridx = 1;
        p.add(t3, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l4, gbc);

        gbc.gridx = 1;
        p.add(t4, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l5, gbc);

        gbc.gridx = 1;
        p.add(t5, gbc);
        gbc.gridy++;

        p.add(b, gbc);
        f1.add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement action handling if needed
    }
}