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
     * A Header to be displayed for the agent to indicate that they are looking
     *     at the Approving Screen.
     */
    private static JLabel header;

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
     * The label to notify the Approving Agent that the immigrant form with
     *     a null field can not be approved.
     */
    private static JLabel nullFieldLabel;
    
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
     * Flag to indicate if an Approval Form has been approved.
     */
    private static boolean approvalFlag;

    /**
     * Flag to indicate if an Approval Form contains a null field.
     */
    private static boolean nullFieldFlag;

    /**
     * Flag to indicate that the Approving Agent has been notified of a null
     *     field in the immigrant's form.
     */
    private static boolean nullFieldMessageFlag;

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
        ApprovalGUI approvalGUI = new ApprovalGUI();

        // the header for the approving screen
        header = new JLabel("Approval Screen");
        header.setFont(header.getFont().deriveFont(20.0f));

        // Container to store components 
        panel = new JPanel(new GridBagLayout());
        // Component constraints
        gridBagConst = new GridBagConstraints();
        gridBagConst.insets.set(5, 5, 5, 5);
        
        // Set frame to visible for the user
        frame.setVisible(true);
        // Set screen to fullscreen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Approval button
        JButton approveButton = new JButton("Send Approval Email");
        // Prepare specific action when approveButton is pressed
        approveButton.addActionListener(approvalGUI);
        
        // Return button
        JButton returnButton = new JButton("Return for Review");
        // Prepare specific action when returnButton is pressed
        returnButton.addActionListener(approvalGUI);

        // Exit button
        JButton exitButton = new JButton("Exit");
        // Prepare specific action when exitButton is pressed
        exitButton.addActionListener(approvalGUI);

        // Store all provided data received from Review Agent
        name = new JLabel("Entered Name: " + immigrantDataForm.getName());
        email = new JLabel("Entered Email: " + immigrantDataForm.getEmail());
        birthdate = new JLabel("Entered Birthdate: " + immigrantDataForm.getBirthdate());
        numChildren = new JLabel("Entered Number of Children: " + immigrantDataForm.getNumChildren());
        diseaseName = new JLabel("Entered Disease Data: " + immigrantDataForm.getData());

        // check for possible null fields in the immigrant's form
        if (immigrantDataForm.getName() == null ||
            immigrantDataForm.getEmail() == null ||
            immigrantDataForm.getBirthdate() == null ||
            immigrantDataForm.getData() == null) {
                // set nullFieldFlag to true; null field was found in the form
                nullFieldFlag = true;
            }

        // add the header to the center of the screen, above the form's fields
        gridBagConst.anchor = GridBagConstraints.CENTER;
        panel.add(header, gridBagConst);

        // Center component
        gridBagConst.anchor = GridBagConstraints.CENTER;
        gridBagConst.gridx = 0;
        gridBagConst.gridy = 0;
        gridBagConst.gridwidth = 2;
        // Move downwards
        gridBagConst.gridy++;

        // Center the labels
        gridBagConst.anchor = GridBagConstraints.CENTER;
        gridBagConst.fill = GridBagConstraints.HORIZONTAL;
        gridBagConst.gridwidth = 2;
        gridBagConst.gridx = 0;

        // Add all labels
        panel.add(name, gridBagConst);
        gridBagConst.gridy++;
        panel.add(email, gridBagConst);
        gridBagConst.gridy++;
        panel.add(birthdate, gridBagConst);
        gridBagConst.gridy++;
        panel.add(numChildren, gridBagConst);
        gridBagConst.gridy++;
        panel.add(diseaseName, gridBagConst);

        // Move downwards
        gridBagConst.gridy++;
        // reset gridwidth for buttons
        gridBagConst.gridwidth = 1;

        // Add approve button to container
        panel.add(approveButton, gridBagConst);
        // Move right
        gridBagConst.gridx++;

        // Add return button to container
        panel.add(returnButton, gridBagConst);
        frame.add(panel);
        
        // move exitButton downwards before adding it
        gridBagConst.gridy++;
        // Add exit button to container
        panel.add(exitButton, gridBagConst);
        frame.add(panel);
    }
    
    /**
     * Handles action events triggered by the Approving Agent when they press
     *     the following buttons: The "Send Approval Email" button informs
     *     the Approving Agent that a confirmation email has been sent to the
     *     immigrant, and that the Approving Agent may return to the Central
     *     screen. The "Return for Review" button returns the applicant's form
     *     back to the Reviewing Agent for correction, then the next Approval
     *     form is viewed to the Approving Agent.
     * 
     * @param e for the ActionEvent to indicate that one of the following two
     *     has been pressed: "Send Approval Email" or "Return for Review".
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Approving agent presses "Send Approval Email" button
        if (command.equals("Send Approval Email")) {
            /* 
             * check if the approving agent has already been notified of 
             * the null field in the immigrant's form
             */
            if (nullFieldMessageFlag == true) {
                return;
            }

            // check if the Approval form contains a null field
            else if (nullFieldFlag == true) {
                // display error message
                nullFieldLabel = new JLabel("Null field found");
                nullFieldLabel.setText(
                    "Null-Fielded Form: Return."
                );
                
                gridBagConst.anchor = GridBagConstraints.CENTER;
                gridBagConst.gridx--;
                // Move downwards
                panel.add(nullFieldLabel, gridBagConst);

                // refresh the frame to show new label (tell layout manager of change)
                frame.revalidate();
                // ensure the change is displayed
                frame.repaint();

                // the approving agent has been notified of the null field
                nullFieldMessageFlag = true;
                return;
            }

            // check if Approval form has already been approved by agent
            else if (approvalFlag == true) {
                return;
            }
            
            // Notifies Approving Agent the confirmation email was sent
            approvalEmail =  new JLabel(
                "Approval Email sent to Immigrant: Load next Approval form or Exit"
            );
            approvalEmail.setText("Approval Email Sent");
            
            // Exit Approval System button and return to Central GUI screen
            JButton nextButton  = new JButton("Next Approval Item");
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // Set approvalFlag to false to indicate the form was not approved
                    approvalFlag = false;
                    
                    // Close ApprovalGUI screen to load next Approval form screen
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(false);

                    // load the next Approval form for the Approving Agent
                    ApprovalGUI approvalGUI = new ApprovalGUI();
                    approvalGUI.loadApprovalScreen(workFlowTable);
                }
            });

            gridBagConst.anchor = GridBagConstraints.CENTER;
            gridBagConst.gridx--;
            panel.add(nextButton, gridBagConst);
            // Move downwards
            gridBagConst.gridy++;
            panel.add(approvalEmail, gridBagConst);

            // refresh the frame to show new label (tell layout manager of change)
            frame.revalidate();
            // ensure the change is displayed
            frame.repaint();
            
            // Set approvalFlag to true to indicate the form was approved
            approvalFlag = true;
        }

        // Return the form back to the Reviewing Agent
        else if (command.equals("Return for Review")) {
            // send immigrant's form back to the workflow table's reviewQueue
            workFlowTable.addReviewForm(immigrantDataForm);
            
            // Set approvalFlag to false to indicate the form was not approved
            approvalFlag = false;
            // Set nullFieldMessageFlag to false for the next form
            nullFieldMessageFlag = false;

            // close ApprovalGUI screen to open screen for next Approval form
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);

            // load the next Approval form for the Approving Agent
            ApprovalGUI approvalGUI = new ApprovalGUI();
            approvalGUI.loadApprovalScreen(workFlowTable);
        }

        // Approving Agent decides to return to Central screen
        else if (command.equals("Exit")) {            
            // check if currently viewed approval form has not been approved
            if (approvalFlag == false) {
                // send immigrant's form back to the workflow table's approveQueue
                workFlowTable.addApprovalForm(immigrantDataForm);
            }

            // close ApprovalGUI screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);

            // Set approvalFlag to false to indicate the form was not approved
            approvalFlag = false;
            // Set nullFieldMessageFlag to false when exiting
            nullFieldMessageFlag = false;

            // return to CentralGUI screen
            CentralGUI centralGUI = new CentralGUI();
            centralGUI.loadCentralScreen(workFlowTable);
        }
    }
}
