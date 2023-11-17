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
    static JLabel l1, l2, l3, l4, l5;
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
    public static void loadReviewScreen(WorkflowTable wft) {

        workflowtable = wft;
        // creating copy of form 
        immigrantDataForm = workflowtable.getNextReviewForm();

        // displaying frame
        f1 = new JFrame("Disease Management System - Review Data");

        ReviewGUI gui = new ReviewGUI();

        JButton b = new JButton("Submit for Approval");

        b.addActionListener(gui);

        // Set the frame to visible
        f1.setVisible(true);

        // Maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Displaying immigrant information
        l1 = new JLabel("Entered Name: " + form.name);
        l2 = new JLabel("Entered Email: " + form.email);
        l3 = new JLabel("Entered Birthdate: " + form.birthdate);
        l4 = new JLabel("Entered Number of Children: " + form.numChildren);
        l5 = new JLabel("Entered Disease Data: " + form.data);

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

        // Adding and manipulating various 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(l1, gbc);

        gbc.gridx = 1;
        p.add(nameTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l2, gbc);

        gbc.gridx = 1;
        p.add(emailTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l3, gbc);

        gbc.gridx = 1;
        p.add(DOBTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l4, gbc);

        gbc.gridx = 1;
        p.add(numChildrenTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        p.add(l5, gbc);

        gbc.gridx = 1;
        p.add(diseaseTextField, gbc);
        gbc.gridy++;

        p.add(b, gbc);
        f1.add(p);
    }

    // /**
    //  * Validates the data entered by the review agent (same logic as DataEntryGUI).
    //  * The method checks the validity of various fields such as name, email, birthdate,
    //  * number of children, and disease data.
    //  *
    //  * @param form The InfectedUserData form to be validated.
    //  * @return The number of valid data parts. A fully valid form would return 5.
    //  */
    // public static int validate(InfectedUserData form) {

    //     //final number of valid parts
    //     int finalNum = 0;

    //     //add validation for name
    //     if (form.validateName(form.getName()) == 1) {
    //         finalNum++;
    //     } else {
    //         //add clear data form and show name error message
    //     }

    //     //add validation for disease data
    //     if (form.validateInfectiousData(form.getData()) == 1) {
    //         finalNum++;
    //     } else {
    //         //add clear data form and show data error message
    //     }

    //     //add validation for email
    //     if (form.validateEmail(form.getEmail()) == 1) {
    //         finalNum++;
    //     } else {
    //         //add clear data form and show email error message
    //     }

    //     //add validation for birthdate
    //     if (form.validateBirthdate(form.getBirthdate()) == 1) {
    //         finalNum++;
    //     } else {
    //         //add clear data form and show birthdate error message
    //     }

    //     //add validation for number of children
    //     if (form.validateNumChild(form.getNumChildren()) == 1) {
    //         finalNum++;
    //     } else {
    //         //add clear data form and show birthdate error message
    //     }
        
    //     //return total valid
    //     return finalNum;
    // }

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
            
            // Validate the data and let the user know if it was invalid.
            // int validationResult = validate(copy);

            // if (validationResult != 5) {
            //     // This means not all fields are valid
            //     JOptionPane.showMessageDialog(f1, "Some fields have invalid data. Please check and try again.");
            //     loadReviewScreen(workflowtable);
            // } else {
            //     // All fields are valid, so proceed
            //     f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //     f1.setVisible(false);

            //     // load the approval screen with the new version of the form
            //     approval.loadApprovalScreen(copy);

            // }

            boolean validationResult = validate(copy);

            while (!validationResult) {
                JOptionPane.showMessageDialog(f1, "Some fields have invalid data. Please check and try again.");
                validate(copy);
            }

            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setVisible(false);

            workflowtable.addApprovalForm(copy);

            approval.loadApprovalScreen(null);

        }
    }
}
