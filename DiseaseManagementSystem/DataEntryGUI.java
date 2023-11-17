package DiseaseManagementSystem;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;
import java.util.Queue;

import DiseaseManagementSystem.*;

/**
 * The {@code DataEntryGUI} class provides a graphical user interface for data entry in a disease management system.
 * It captures user input regarding infected individuals, validates the input, and queues it for review and approval.
 * The class uses Swing components to create a user-friendly interface for inputting data.
 * 
 * @author Cain Clifton
 * @author John Fulton (javadoc)
 */
class DataEntryGUI extends JFrame implements ActionListener {
    // JTextField to enter text
    static JTextField t1, t2, t3, t4, t5;

    // JFrame
    static JFrame f;

    // JFrame
    static JFrame f2;

    // JButton to submit to review
    static JButton b, exit;

    // Labels to display text
    static JLabel l1, l2, l3, l4, l5, title;

    // Data variables, all data from textfields stored here
    static String name, email, birthdate, children, diseaseData;

    //amount of times submitted
    static int tries = 0;

    //immigrant data form
    static InfectedUserData ImmigrantDataForm;

    //boolean for first submission
    static boolean firstSubmission = false;

    //flag for completion of data entry screen and ready for review screen
    static boolean flag1 = false;

    //flag for completion of review screen and ready for approval screen
    static boolean flag2 = false;

    static WorkflowTable workflowtable;

    
    public static void main(String[] args) {

        //load the initial data screen
        // if (firstSubmission == false) {
        //     DataEntryGUI.loadDataScreen();
        // }

    }

    /**
     * Handles action events triggered by the user interface elements. Specifically, this
     * method is responsible for handling when the user presses the submit for review button.
     *
     * @param e The ActionEvent that contains information about the event
     *          and its source (clicking the submit for approval button).
     */
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {

             
            //once the button is pressed the first submission is done
            firstSubmission = true;

            //add a try to tries
            tries++;

            //get data from textfields
            name = t1.getText();
            email = t2.getText();
            birthdate = t3.getText();
            children = t4.getText();
            diseaseData = t5.getText();

            //fill the form with the data
            ImmigrantDataForm = new InfectedUserData(name, diseaseData, email, birthdate, 0, false, null);


            //if there is more than zero children, the immigrant is a parent or guardian
            if (!children.equals("")) {
                if (Integer.parseInt(children) > 0) {
                    ImmigrantDataForm.setGuardian(true);
                }
            }

            //if all validations are not done, dispose of the old screen, and reload a new screen for data entry 
            if (DataEntryGUI.validate(ImmigrantDataForm) != 5) {
        
                f.dispose();
                DataEntryGUI.loadDataScreen(workflowtable);

            }

            //if all fields are valid, 
            if (DataEntryGUI.validate(ImmigrantDataForm) == 5) {
            
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(false);

            //set the flag to true
            flag1 = true;

            //add form to review queue
            workflowtable.addReviewForm(ImmigrantDataForm);

            DataEntryGUI.loadDataScreen(workflowtable);

            } 
        } 
        if (s.equals("Exit")) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(false);
            CentralGUI centralgui = new CentralGUI();
            centralgui.loadCentralScreen(workflowtable);
        }
    }
    /**
     * Validates the data entered by the review agent (same logic as ReviewGUI).
     * The method checks the validity of various fields such as name, email, birthdate,
     * number of children, and disease data.
     * @param form The InfectedUserData form to be validated.
     * @return The number of valid data parts. A fully valid form would return 5.
     */
    public static int validate(InfectedUserData form) {

        //final number of valid parts
        int finalNum = 0;

        //add validation for name
        if (form.validateName(name) == 1) {
            finalNum++;
        } else {
            //add clear data form and show name error message
        }

        //add validation for disease data
        if (form.validateInfectiousData(diseaseData) == 1) {
            finalNum++;
        } else {
            //add clear data form and show data error message
        }

        //add validation for email
        if (form.validateEmail(email) == 1) {
            finalNum++;
        } else {
            //add clear data form and show email error message
        }

        //add validation for birthdate
        if (form.validateBirthdate(birthdate) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }

        //add validation for number of children
        if (!children.equals("") && form.validateNumChild(Integer.parseInt(children)) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }
        
        //return total valid
        return finalNum;
    }

    /**
     * Loads the data entry screen for the user to enter data into the InfectedUserData form.
     * Displays appropriate GUI components via Swing.
     */
    public static void loadDataScreen(WorkflowTable workflow) {
        workflowtable = workflow;
        firstSubmission = false;
        if (firstSubmission == false) {
            //Make the JFrame
            f = new JFrame("Disease Management System - Enter Data");

            //Labels for text
            title = new JLabel("Disease Management System");
            title.setFont(title.getFont().deriveFont(18.0f)); // Increase font size

            l1 = new JLabel("Enter Name:");
            l2 = new JLabel("Enter Email:");
            l3 = new JLabel("Enter Birthdate (MM/DD/YYYY):");
            l4 = new JLabel("Enter Number of Children (Parent or guardian):");
            l5 = new JLabel("Enter Disease Data:");

            //=Create submit button
            b = new JButton("Submit");
            exit = new JButton("Exit");

            //make the gui object
            DataEntryGUI gui = new DataEntryGUI();

            //make the 
            b.addActionListener(gui);
            exit.addActionListener(gui);

            //make the five textfields
            t1 = new JTextField(16);
            t2 = new JTextField(16);
            t3 = new JTextField(16);
            t4 = new JTextField(16);
            t5 = new JTextField(16);

            //set the size of the textfields
            Dimension fieldSize = new Dimension(100, 20); // Adjust the size as needed
            t1.setPreferredSize(fieldSize);
            t2.setPreferredSize(fieldSize);
            t3.setPreferredSize(fieldSize);
            t4.setPreferredSize(fieldSize);
            t5.setPreferredSize(fieldSize);

            //create panel
            JPanel p = new JPanel(new GridBagLayout());

            //center components
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets.set(5, 5, 5, 5);

            //add title to top
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            p.add(title, gbc);

            //reset gridwidth
            gbc.gridwidth = 1;

            //add labels and textfields
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridy++;
            p.add(l1, gbc);
            gbc.gridy++;
            p.add(t1, gbc);
            gbc.gridy++;
            p.add(l2, gbc);
            gbc.gridy++;
            p.add(t2, gbc);
            gbc.gridy++;
            p.add(l3, gbc);
            gbc.gridy++;
            p.add(t3, gbc);
            gbc.gridy++;
            p.add(l4, gbc);
            gbc.gridy++;
            p.add(t4, gbc);
            gbc.gridy++;
            p.add(l5, gbc);
            gbc.gridy++;
            p.add(t5, gbc);
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            p.add(b, gbc);
            gbc.gridy++;
            p.add(exit, gbc);

            //add panel to frame
            f.add(p);

            //set size of frame
            f.setSize(300, 300); // Adjust the size as needed

            //center the frame
            f.setLocationRelativeTo(null);

            //set the frame to visible
            f.setVisible(true);

            //maximize the screen size
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
    }
}