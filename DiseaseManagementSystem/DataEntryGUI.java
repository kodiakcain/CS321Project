package DiseaseManagementSystem;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;
import java.util.Queue;

import DiseaseManagementSystem.*;

class DataEntryGUI extends JFrame implements ActionListener {
    // JTextField
    static JTextField t1, t2, t3, t4, t5;

    // JFrame
    static JFrame f;

    // JFrame
    static JFrame f2;

    // JButton
    static JButton b;

    // Labels to display text
    static JLabel l1, l2, l3, l4, l5, title;

    // Data variables
    static String name, email, birthdate, children, diseaseData;

    //amount of times submitted
    static int tries = 0;

    //immigrant data form
    static InfectedUserData ImmigrantDataForm;

    //boolean for first submission
    static boolean firstSubmission = false;

    //flag for completion of data entry screen and ready for approval screen
    static boolean flag1 = false;

    //workflow table for approvalQueue
    static Queue<String> approvalQueue = new LinkedList<>();

    //workflow table for reviewQueue
    static Queue<String> reviewQueue = new LinkedList<>();
    public static void main(String[] args) {

        //load the initial data screen
        if (firstSubmission == false) {
            DataEntryGUI.loadDataScreen();
        }

    }

    // If the button is pressed
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
            if (Integer.parseInt(children) > 0) {
                ImmigrantDataForm.setGuardian(true);
            }

            //if all validations are not done, dispose of the old screen, and reload a new screen for data entry 
            if (DataEntryGUI.validate(ImmigrantDataForm) != 5) {
        
                f.dispose();
                DataEntryGUI.loadDataScreen();

            }

            //if all fields are valid, 
            if (DataEntryGUI.validate(ImmigrantDataForm) == 5) {
            
            //remove everything from the screen
            Container contentPane = f.getContentPane();
            contentPane.removeAll();
            contentPane.repaint();

            //set the flag to true
            flag1 = true;

            System.out.println("BEFORE HASH: " + ImmigrantDataForm.getEmail());

            //calculate the form number based on the SHA-256 hash of the email, and replace the email
            try {
                ImmigrantDataForm.calculateFormNumber();
            } catch (NoSuchAlgorithmException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.out.println("HASH: " + ImmigrantDataForm.getEmail());
            //new approval gui object
            ApprovalGUI approval = new ApprovalGUI();

            //once flag is true, close the data entry screen and load the approval screen
            if (flag1 == true) {
                //TODO close the original screen


                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(false);

                ApprovalGUI.loadApprovalScreen();
            }
        } 
    }
    }

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
        if (form.validateNumChild(Integer.parseInt(children)) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }
        
        //return total valid
        return finalNum;
    }

    public static void loadDataScreen() {
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

            //make the gui object
            DataEntryGUI gui = new DataEntryGUI();

            //make the 
            b.addActionListener(gui);

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