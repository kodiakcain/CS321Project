package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

/**
 * The ReviewGUI class provides a graphical user interface for reviewing the data
 * of individuals in a disease management context. It allows for the validation and submission
 * of immigrant data for further processing.
 *
 * @author John Fulton
 */
public class ReviewGUI extends JFrame implements ActionListener {
    static JFrame f1;
    // Labels to display text
    static JLabel nameLabel, emailLabel, birthdateLabel, numChildrenLabel, diseaseLabel, reviewTitle, editLabel;
    // Add text fields
    static JTextField nameTextField, emailTextField, DOBTextField, numChildrenTextField, diseaseTextField;
    static InfectedUserData immigrantDataForm;
    static WorkflowTable workflowtable;

    /**
     * Loads the review screen with the data from the given InfectedUserData form.
     * This screen will show the immigrants data on the screen and provides input fields 
     * for correction from the review agent, if necessary.
     *
     * @param wft The workflow table containing the information to be reviewed.
     */
    public static void loadReviewScreen(WorkflowTable wft, InfectedUserData form) {

        workflowtable = wft;

        if (form == null) {
            // creating copy of form 
            immigrantDataForm = workflowtable.getNextReviewForm();
        } else {
            immigrantDataForm = form;
        }

        // displaying frame
        f1 = new JFrame("Disease Management System - Review Data");

        ReviewGUI gui = new ReviewGUI();

        JButton submitButton = new JButton("Submit for Approval");
        submitButton.setHorizontalAlignment(JButton.CENTER);

        JButton exitButton = new JButton("Exit");
        exitButton.setHorizontalAlignment(JButton.CENTER);

        submitButton.addActionListener(gui);

        exitButton.addActionListener(gui);

        // Set the frame to visible
        f1.setVisible(true);

        // Maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Creating title for screen
        reviewTitle = new JLabel("Review System");
        reviewTitle.setFont(reviewTitle.getFont().deriveFont(18.0f));

        // Displaying immigrant information
        nameLabel = new JLabel("Entered Name: " + immigrantDataForm.name);
        emailLabel = new JLabel("Entered Email: " + immigrantDataForm.email);
        birthdateLabel = new JLabel("Entered Birthdate: " + immigrantDataForm.birthdate);
        numChildrenLabel = new JLabel("Entered Number of Children: " + immigrantDataForm.numChildren);
        diseaseLabel = new JLabel("Entered Disease Data: " + immigrantDataForm.data);
        editLabel = new JLabel("Please review the data below and enter any changes in the textboxes.");

        // Make the five text fields
        nameTextField = new JTextField(16);
        emailTextField = new JTextField(16);
        DOBTextField = new JTextField(16);
        numChildrenTextField = new JTextField(16);
        diseaseTextField = new JTextField(16);

        // Set the size of the text fields
        Dimension fieldSize = new Dimension(100, 20); // Adjust the size as needed
        nameTextField.setPreferredSize(fieldSize);
        emailTextField.setPreferredSize(fieldSize);
        DOBTextField.setPreferredSize(fieldSize);
        numChildrenTextField.setPreferredSize(fieldSize);
        diseaseTextField.setPreferredSize(fieldSize);

        JPanel p = new JPanel(new GridBagLayout());

        // Adding and manipulating various components of screen.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);
        
        // Adding title to the top of the screen
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        p.add(reviewTitle, gbc);

        // Adding edit message for user below
        gbc.gridy++;
        p.add(editLabel, gbc);

        // Realigning gridbagconstraints
        gbc.anchor = GridBagConstraints.WEST;

        // Adding labels and textfields to screen
        gbc.gridy++;
        gbc.gridwidth = 1;
        p.add(nameLabel, gbc);

        gbc.gridx = 1;
        p.add(nameTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(emailLabel, gbc);

        gbc.gridx = 1;
        p.add(emailTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(birthdateLabel, gbc);

        gbc.gridx = 1;
        p.add(DOBTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(numChildrenLabel, gbc);

        gbc.gridx = 1;
        p.add(numChildrenTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(diseaseLabel, gbc);

        gbc.gridx = 1;
        p.add(diseaseTextField, gbc);
        gbc.gridy++;

        p.add(submitButton, gbc);
        gbc.gridy++;

        p.add(exitButton, gbc);
        f1.add(p);
    }

    /**
     * Validates the data entered by the review agent.
     * The method checks the validity of various fields such as name, email, birthdate,
     * number of children, and disease data.
     *
     * @param form The InfectedUserData form to be validated.
     * @return The number of valid data parts. A fully valid form would return 5.
     */
    public boolean validate(InfectedUserData form) {
        boolean nameFlag = true;
        boolean emailFlag = true;
        boolean birthdateFlag = true;
        boolean numChildrenFlag = true;
        boolean dataFlag = true;

        if (form.validateName(form.getName()) != 1) {
            // Setting flag to false.
            nameFlag = false;
            // clear text field for name entry
            nameTextField.setText("");
            // display message to user that they need to fix the name
        }

        if (form.validateEmail(form.getEmail()) != 1) {
            emailFlag = false;
            emailTextField.setText("");
        }

        if (form.validateBirthdate(form.getBirthdate()) != 1) {
            birthdateFlag = false;
            DOBTextField.setText("");
        }

        if (form.validateNumChild(form.getNumChildren()) != 1) {
            numChildrenFlag = false;
            numChildrenTextField.setText("");
        }

        if (form.validateInfectiousData(form.getData()) != 1) {
            dataFlag = false;
            diseaseTextField.setText("");
        }

        return nameFlag && emailFlag && birthdateFlag && numChildrenFlag && dataFlag;

    }

    /**
     * Handles action events triggered by the user interface elements. Specifically, this
     * method is responsible for handling when the user presses the submission for approval button.
     *
     * @param e The ActionEvent that contains information about the event
     *          and its source (clicking the submit for approval button).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Submit for Approval")) {

            // making frame invisible to user
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setVisible(false);

            // Create a new instance of ApprovalGUI
            ApprovalGUI approval = new ApprovalGUI();

            // Making a deep copy of the current immigrant form
            InfectedUserData copy = new InfectedUserData(immigrantDataForm.getName(), immigrantDataForm.getData(), immigrantDataForm.getEmail(), immigrantDataForm.getBirthdate(), immigrantDataForm.getNumChildren(), immigrantDataForm.getIsGuardian(), immigrantDataForm.getDate());
            
            // Validate any data that was entered by the review agent.
            if (!(nameTextField.getText().equals(""))) {
                copy.setName(nameTextField.getText());
            } 
            
            if (!(emailTextField.getText().equals(""))) {
                copy.setEmail(emailTextField.getText());
            }
            
            if (!(DOBTextField.getText().equals(""))) {
                copy.setBirthdate(DOBTextField.getText());
            }
            
            if (!(numChildrenTextField.getText().equals(""))) {
                if (Integer.parseInt(numChildrenTextField.getText()) > 0) {
                    copy.setGuardian(true);
                    copy.setNumChildren(Integer.parseInt(numChildrenTextField.getText()));
                } else  {
                    copy.setGuardian(false);
                    copy.setNumChildren(Integer.parseInt(numChildrenTextField.getText()));
                }
            } 
            
            if (!(diseaseTextField.getText().equals(""))) {
                copy.setData(diseaseTextField.getText());
            }
            
            ReviewGUI gui = new ReviewGUI();

            boolean validationResult = validate(copy);

            if (!validationResult) {
                JOptionPane.showMessageDialog(f1, "Some fields have invalid data. Please check and try again.");
                f1.dispose();
                gui.loadReviewScreen(workflowtable, immigrantDataForm);
                return;
            }

            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setVisible(false);

            workflowtable.addApprovalForm(copy);
            gui.loadReviewScreen(workflowtable, null);

        }
        else if (command.equals("Exit")) {
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setVisible(false);
                CentralGUI central = new CentralGUI();
                central.loadCentralScreen(workflowtable); 
        }
    }
}
