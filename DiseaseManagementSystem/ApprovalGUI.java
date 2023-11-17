package DiseaseManagementSystem;
import java.awt.event.*;
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
     *  The window on the screen.
     */
    private static JFrame frame;

    /**
     * The label to display the immigrant's name to the Approving Agent user.
     */
    private static JLabel name;
    
    /**
     * The label to display the immigrant's email to the Approving Agent user.
     */
    private static JLabel email;
    
    /**
     * The label to display the immigrant's birthdate to the Approving Agent user.
     */
    private static JLabel birthdate;

    /**
     * The label to display the immigrant's number of children to the Approving
     *     Agent user.
     */
    private static JLabel numChildren;

    /**
     * The label to display the immigrant's disease to the Approving Agent user.
     */
    private static JLabel diseaseName;

    /**
     * The label to notify the Approving Agent user that the confirmation email has
     *     been sent.
     */
    private static JLabel approvalEmail;
    
    /**
     * The immigrant's infectious disease form.
     */
    private static InfectedUserData immigrantDataForm;

    /**
     * Determines how components are displayed to the user.
     */
    private static GridBagConstraints gridBagConst;

    /**
     * Container to store all components such as buttons and textfields.
     */
    private static JPanel panel;

    /**
     * The Workflow Table that contains the Infectious Disease Forms
     *     of all immigrants. 
     */
    private static WorkflowTable workFlowTable;

    /**
     * Displays the Immigrant's infectious disease information to the Approving
     *     Agent User.
     * 
     * @param workFlowTableInput for the workflow table to be accessed by the
     *     ApprovalGUI system.
     */
    public static void loadApprovalScreen(WorkflowTable workFlowTableInput) {
        // ApprovalGUI obtains workflow table
        workFlowTable = workFlowTableInput;
        // Get next immigrant infectious disease form for approval
        immigrantDataForm = workFlowTable.getNextApprovalForm();

        // New frame to be shown to the Approving Agent
        frame = new JFrame("Disease Management System - Approve Data"); 
        ApprovalGUI gui = new ApprovalGUI();

         // container to store components 
        panel = new JPanel(new GridBagLayout());
        // component constraints
        gridBagConst = new GridBagConstraints();
        gridBagConst.insets.set(5, 5, 5, 5);

        // Set frame to visible for the user
        frame.setVisible(true);
        // Set screen to fullscreen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Approval button
        JButton approveButton = new JButton("Send Approval Email");
        // Prepare specific action when approveButton is pressed
        approveButton.addActionListener(gui);
        
        // Return button
        JButton returnButton = new JButton("Return for Review");
        // Prepare specific action when returnButton is pressed
        returnButton.addActionListener(gui);

        // Store all provided data received from Review Agent
        name = new JLabel("Entered Name: " + immigrantDataForm.getName());
        email = new JLabel("Entered Email: " + immigrantDataForm.getEmail());
        birthdate = new JLabel("Entered Birthdate: " + immigrantDataForm.getBirthdate());
        numChildren = new JLabel("Entered Number of Children: " + immigrantDataForm.getNumChildren());
        diseaseName = new JLabel("Entered Disease Data: " + immigrantDataForm.getData());

        // center component
        gridBagConst.anchor = GridBagConstraints.CENTER;
        gridBagConst.gridx = 0;
        gridBagConst.gridy = 0;
        gridBagConst.gridwidth = 2;
        // move downwards
        gridBagConst.gridy++;

        // center the labels
        gridBagConst.anchor = GridBagConstraints.CENTER;
        gridBagConst.fill = GridBagConstraints.HORIZONTAL;
        gridBagConst.gridwidth = 2;
        gridBagConst.gridx = 0;

        // add all labels
        panel.add(name, gridBagConst);
        gridBagConst.gridy++;
        panel.add(email, gridBagConst);
        gridBagConst.gridy++;
        panel.add(birthdate, gridBagConst);
        gridBagConst.gridy++;
        panel.add(numChildren, gridBagConst);
        gridBagConst.gridy++;
        panel.add(diseaseName, gridBagConst);

        // move downwards
        gridBagConst.gridy++;
        // reset gridwidth for buttons
        gridBagConst.gridwidth = 1;
        
        // add approve button to container
        panel.add(approveButton, gridBagConst);
        // move right
        gridBagConst.gridx++;

        // add return button to container
        panel.add(returnButton, gridBagConst);
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

            gridBagConst.anchor = GridBagConstraints.CENTER;
            gridBagConst.gridx--;
            // Move downwards
            gridBagConst.gridy++;
            panel.add(approvalEmail, gridBagConst);
            gridBagConst.gridy++;
            panel.add(closeButton, gridBagConst);

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
            gui.loadReviewScreen(workFlowTable);
        }
    }
}
