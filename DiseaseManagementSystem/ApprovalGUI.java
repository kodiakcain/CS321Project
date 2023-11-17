package DiseaseManagementSystem;

import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

/**
 * A Graphical User Interface for the Approving Agent to approve or return
 *     Infectious Disease forms.
 * 
 * @author Youssef Melk
 */
public class ApprovalGUI extends JFrame implements ActionListener {

    /**
     * JFrame that provides a window on the screen.
     */
    private static JFrame frame;

    /**
     * Label to display the immigrant's name to the Approving Agent user.
     */
    private static JLabel name;
    
    /**
     * Label to display the immigrant's email to the Approving Agent user.
     */
    private static JLabel email;
    
    /**
     * Label to display the immigrant's birthdate to the Approving Agent user.
     */
    private static JLabel birthdate;

    /**
     * Label to display the immigrant's number of children to the Approving
     *     Agent user.
     */
    private static JLabel numChildren;

    /**
     * Label to display the immigrant's disease to the Approving Agent user.
     */
    private static JLabel diseaseName;

    /**
     * Label to notify the Approving Agent user that the confirmation email has
     *     been sent.
     */
    private static JLabel approvalEmail;
    
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
    private static JPanel panel;

    /**
     * The Workflow Table that contains the Infectious Disease Forms
     *     of all immigrants. 
     */
    private static WorkflowTable workflowtable;

    /**
     * Displays the Immigrant's infectious disease information to the Approving
     *     Agent User.
     * 
     * @param form for the Immigrant's infectious disease form that contains
     *     its corresponding data.
     */
    public static void loadApprovalScreen(WorkflowTable workflowtable) {
        // get next immigrant infectious disease form for approval
        immigrantDataForm = workflowtable.getNextApprovalForm();

        // New frame to show the Approving Agent
        frame = new JFrame("Disease Management System - Approve Data"); 
        ApprovalGUI gui = new ApprovalGUI();
        
        // approval button
        JButton approveButton = new JButton("Send Approval Email");
        approveButton.addActionListener(gui);
        // return button
        JButton returnButton = new JButton("Return for Review");
        returnButton.addActionListener(gui);

        // set the frame to visible
        frame.setVisible(true);
        // maximize the screen size
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // store all provided data received from Review Agent
        name = new JLabel("Entered Name: " + immigrantDataForm.getName());
        email = new JLabel("Entered Email: " + immigrantDataForm.getEmail());
        birthdate = new JLabel("Entered Birthdate: " + immigrantDataForm.getBirthdate());
        numChildren = new JLabel("Entered Number of Children: " + immigrantDataForm.getNumChildren());
        diseaseName = new JLabel("Entered Disease Data: " + immigrantDataForm.getData());

        // stores all components
        panel = new JPanel(new GridBagLayout());
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
        panel.add(name, gbc);
        gbc.gridy++;
        panel.add(email, gbc);
        gbc.gridy++;
        panel.add(birthdate, gbc);
        gbc.gridy++;
        panel.add(numChildren, gbc);
        gbc.gridy++;
        panel.add(diseaseName, gbc);

        // move downwards
        gbc.gridy++;
        // reset gridwidth for buttons
        gbc.gridwidth = 1;
        // add buttons
        panel.add(approveButton, gbc);
        // move right
        gbc.gridx++;
        panel.add(returnButton, gbc);
        frame.add(panel);
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
            approvalEmail =  new JLabel(
                "Approval Email sent to Immigrant, Exit System."
            );

            approvalEmail.setText("Approval Email Sent, Exit System");
            
            JButton closeButton  = new JButton("Exit System");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // close window
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(false);
                }
            });

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx--;
            // Move downwards
            gbc.gridy++;
            p.add(approvalEmail, gbc);
            gbc.gridy++;
            p.add(closeButton, gbc);

            // refresh the frame to show new label (tell layout manager of change)
            frame.revalidate();
            // ensure the change is displayed
            frame.repaint();
        }

        //  return the form back to the Reviewing Agent
        else if (command.equals("Return for Review")) {
            // close window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // set off visibility
            frame.setVisible(false);
            
            // load the reviewing agent's Reviewing screen
            ReviewGUI gui = new ReviewGUI();
            gui.loadReviewScreen(immigrantDataForm);
        }
    }
}
