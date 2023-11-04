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
    static JTextField t1, t2, t3, t4, t5;
    static InfectedUserData immigrantDataForm;

    /**
     * Loads the review screen with the data from the given InfectedUserData form.
     * This screen will show the immigrants data on the screen and provides input fields 
     * for correction from the review agent, if necessary.
     *
     * @param form The InfectedUserData containing the information to be reviewed.
     */
    public static void loadReviewScreen(InfectedUserData form) {

        // creating copy of form 
        immigrantDataForm = form;

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

        // Adding and manipulating various 
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

    /**
     * Validates the data entered by the review agent (same logic as DataEntryGUI).
     * The method checks the validity of various fields such as name, email, birthdate,
     * number of children, and disease data.
     *
     * @param form The InfectedUserData form to be validated.
     * @return The number of valid data parts. A fully valid form would return 5.
     */
    public static int validate(InfectedUserData form) {

        //final number of valid parts
        int finalNum = 0;

        //add validation for name
        if (form.validateName(form.getName()) == 1) {
            finalNum++;
        } else {
            //add clear data form and show name error message
        }

        //add validation for disease data
        if (form.validateInfectiousData(form.getData()) == 1) {
            finalNum++;
        } else {
            //add clear data form and show data error message
        }

        //add validation for email
        if (form.validateEmail(form.getEmail()) == 1) {
            finalNum++;
        } else {
            //add clear data form and show email error message
        }

        //add validation for birthdate
        if (form.validateBirthdate(form.getBirthdate()) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }

        //add validation for number of children
        if (form.validateNumChild(form.getNumChildren()) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }
        
        //return total valid
        return finalNum;
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
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setVisible(false);

            // Create a new instance of ApprovalGUI
            ApprovalGUI approval = new ApprovalGUI();

            
            // Making a deep copy of the current immigrant form
            InfectedUserData copy = new InfectedUserData(immigrantDataForm.getName(), immigrantDataForm.getData(), immigrantDataForm.getEmail(), immigrantDataForm.getBirthdate(), immigrantDataForm.getNumChildren(), immigrantDataForm.getIsGuardian(), immigrantDataForm.getDate());
            
            // Validate any data that was entered by the review agent.
            if (!(t1.getText().equals(""))) {
                copy.setName(t1.getText());
            } 
            
            if (!(t2.getText().equals(""))) {
                copy.setEmail(t2.getText());
            }
            
            if (!(t3.getText().equals(""))) {
                copy.setBirthdate(t3.getText());
            }
            
            if (!(t4.getText().equals(""))) {
                if (Integer.parseInt(t4.getText()) > 0) {
                    copy.setGuardian(true);
                    copy.setNumChildren(Integer.parseInt(t4.getText()));
                } else  {
                    copy.setGuardian(false);
                    copy.setNumChildren(Integer.parseInt(t4.getText()));
                }
            } 
            
            if (!(t5.getText().equals(""))) {
                copy.setData(t5.getText());
            }
            
            // Validate the data and let the user know if it was invalid.
            int validationResult = validate(copy);

            if (validationResult != 5) {
            // This means not all fields are valid
                JOptionPane.showMessageDialog(f1, "Some fields have invalid data. Please check and try again.");
                loadReviewScreen(immigrantDataForm);
            } else {
                // All fields are valid, so proceed
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setVisible(false);

                // load the approval screen with the new version of the form
                approval.loadApprovalScreen(copy);

            }
        }
    }
}
