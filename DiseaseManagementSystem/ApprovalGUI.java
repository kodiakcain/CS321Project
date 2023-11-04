package DiseaseManagementSystem;

import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

/**
 * A Graphical User Interface for the ApprovingSystem.
 * 
 * @author Youssef Melk
 */
public class ApprovalGUI extends JFrame implements ActionListener {

    /**
     * JFrame that provides a window on the screen.
     */
    private static JFrame f1;

    /**
     * Labels to display text to the Approving Agent user.
     */
    private static JLabel l1, l2, l3, l4, l5, l6;
    
    /**
     * The immigrant's infectious disease form.
     */
    private static InfectedUserData immigrantDataForm;

    /**
     * Specifies the constraints on the display.
     */
    private static GridBagConstraints gbc;

    /**
     * Container to store all components such as buttons and textfields.
     */
    private static JPanel p;

    /**
     * Displays the Immigrant's infectious disease information to the Approving
     *     Agent User. This Graphical User Interface is the screen for the
     *     ApprovingSystem class.
     * 
     * @param form for the Immigrant's infectious disease form that contains
     *     its corresponding data.
     */
    public static void loadApprovalScreen(InfectedUserData form) {
        immigrantDataForm = form;
        
        // New frame for Approving Agent
        f1 = new JFrame("Disease Management System - Approve Data"); 
        ApprovalGUI gui = new ApprovalGUI();
        
        // approval button
        JButton approveButton = new JButton("Send Approval Email");
        approveButton.addActionListener(gui);
        
        // return button
        JButton returnButton = new JButton("Return for Review");
        returnButton.addActionListener(gui);

        // set the frame to visible
        f1.setVisible(true);
        // maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // store all provided data received from Review Agent
        l1 = new JLabel("Entered Name: " + form.getName());
        l2 = new JLabel("Entered Email: " + form.getEmail());
        l3 = new JLabel("Entered Birthdate: " + form.getBirthdate());
        l4 = new JLabel("Entered Number of Children: " + form.getNumChildren());
        l5 = new JLabel("Entered Disease Data: " + form.getData());

        // stores all components
        p = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);

        // center component
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        // move downwards
        gbc.gridy++;

        // center the labels
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;

        // add labels
        p.add(l1, gbc);
        gbc.gridy++;
        p.add(l2, gbc);
        gbc.gridy++;
        p.add(l3, gbc);
        gbc.gridy++;
        p.add(l4, gbc);
        gbc.gridy++;
        p.add(l5, gbc);

        // move downwards
        gbc.gridy++;
        // reset gridwidth for buttons
        gbc.gridwidth = 1;
        // add buttons
        p.add(approveButton, gbc);
        // move right
        gbc.gridx++;
        p.add(returnButton, gbc);
        f1.add(p);
    }

    /**
     * Handles action events triggered by the Approving Agent when they press
     *     the following buttons: The "Send Approval Email" currently ONLY 
     *     notifies the Approving Agent that an approval email has been sent
     *     to the immigrant. The "Return for Review" button currently returns
     *     the immigrant's infectious disease form data back to the Reviewing
     *     Agent to be reviewed for correction.
     * 
     * @param e for the ActionEvent to indicate that one of the following two
     *     has been pressed: "Send Approval Email" or "Return for Review".
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Send Approval Email")) {
            // email-sending logic
            l6 =  new JLabel("Approval Email sent to Immigrant, Exit System.");
            l6.setText("Approval Email Sent, Exit System");
            
            JButton closeButton  = new JButton("Exit System");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // close window
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
        //  return the form back to the Reviewing Agent
        else if (command.equals("Return for Review")) {
            // close window
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setVisible(false);
            
            // load the reviewing agent's Reviewing screen
            ReviewGUI gui = new ReviewGUI();
            gui.loadReviewScreen(immigrantDataForm);
        }
    }
}
