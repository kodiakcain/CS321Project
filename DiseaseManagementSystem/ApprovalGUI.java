package DiseaseManagementSystem;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

public class ApprovalGUI extends JFrame implements ActionListener{

    static JFrame f1;

    // Labels to display text
    static JLabel l1, l2, l3, l4, l5, l6;
    
    static InfectedUserData immigrantDataForm;

    static GridBagConstraints gbc;

    static JPanel p;

    public static void loadApprovalScreen(InfectedUserData form) {
        immigrantDataForm = form;
        
        // New frame for Approving Agent
        f1 = new JFrame("Disease Management System - Approve Data");
        
        ApprovalGUI gui = new ApprovalGUI();

        // Approval Button
        JButton approveButton = new JButton("Send Approval Email");
        approveButton.addActionListener(gui);

        // Return Button
        JButton returnButton = new JButton("Return for Review");
        returnButton.addActionListener(gui);

        // Set the frame to visible
        f1.setVisible(true);

        //maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Store all provided data from Review Agent
        l1 = new JLabel("Entered Name: " + form.getName());
        l2 = new JLabel("Entered Email: " + form.getEmail());
        l3 = new JLabel("Entered Birthdate: " + form.getBirthdate());
        l4 = new JLabel("Entered Number of Children: " + form.getNumChildren());
        l5 = new JLabel("Entered Disease Data: " + form.getData());

        p = new JPanel(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);

        // add title to top
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        // Move downwards
        gbc.gridy++;

        // Center the labels
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;

        p.add(l1, gbc);
        gbc.gridy++;
        p.add(l2, gbc);
        gbc.gridy++;
        p.add(l3, gbc);
        gbc.gridy++;
        p.add(l4, gbc);
        gbc.gridy++;
        p.add(l5, gbc);

        // Add buttons
        gbc.gridy++;
        gbc.gridwidth = 1; // reset gridwidth for buttons
        p.add(approveButton, gbc);
        gbc.gridx++; // Move Right
        p.add(returnButton, gbc);

        f1.add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Send Approval Email")) {
            // Email-Sending logic
            l6 =  new JLabel("Approval Email sent to Immigrant, Exit System.");
            l6.setText("Approval Email Sent, Exit System");
            
            JButton closeButton  = new JButton("Exit System");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // Close window
                    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f1.setVisible(false);
                }
            });

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx--;
            // Move downwards
            gbc.gridy++;
            p.add(l6, gbc);
            gbc.gridy++;
            p.add(closeButton, gbc);

            // refresh the frame to show new label (tell layout manager of change)
            f1.revalidate();
            // ensure the change is displayed
            f1.repaint();
        }
        else if (command.equals("Return for Review")) {
            // Close window
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setVisible(false);
            
            ReviewGUI gui = new ReviewGUI();
            gui.loadReviewScreen(immigrantDataForm);
        }
    }

}
