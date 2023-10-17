package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

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

    static InfectedUserData placeholderEntryForm;

    static boolean firstSubmission = false;

    // Default constructor
    DataEntryGUI() {
    }

    // Main class
    public static void main(String[] args) {

        firstSubmission = false;

        if (firstSubmission == false) {
            // Create a new frame to store text fields and button
            f = new JFrame("Disease Management System");

            // Create labels to display text
            title = new JLabel("Disease Management System");
            title.setFont(title.getFont().deriveFont(18.0f)); // Increase font size

            l1 = new JLabel("Enter Name:");
            l2 = new JLabel("Enter Email:");
            l3 = new JLabel("Enter Birthdate (MM/DD/YYYY):");
            l4 = new JLabel("Enter Number of Children (Parent or guardian):");
            l5 = new JLabel("Enter Disease Data:");

            // Create a new button
            b = new JButton("Submit");

            // Create an object of the TextFieldsDemo class
            DataEntryGUI demo = new DataEntryGUI();

            // Add ActionListener to the button
            b.addActionListener(demo);

            // Create five objects of JTextField
            t1 = new JTextField(16);
            t2 = new JTextField(16);
            t3 = new JTextField(16);
            t4 = new JTextField(16);
            t5 = new JTextField(16);

            // Set the preferred size for the text fields (smaller width and height)
            Dimension fieldSize = new Dimension(100, 20); // Adjust the size as needed
            t1.setPreferredSize(fieldSize);
            t2.setPreferredSize(fieldSize);
            t3.setPreferredSize(fieldSize);
            t4.setPreferredSize(fieldSize);
            t5.setPreferredSize(fieldSize);

            // Create a panel with GridBagLayout
            JPanel p = new JPanel(new GridBagLayout());

            // Create GridBagConstraints to center components
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets.set(5, 5, 5, 5);

            // Add the title label at the top
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            p.add(title, gbc);

            // Reset gridwidth for other components
            gbc.gridwidth = 1;

            // Add labels, text fields, and the button to the panel with GridBagConstraints
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

            // Add the panel to the frame
            f.add(p);

            // Set the size of the frame
            f.setSize(300, 300); // Adjust the size as needed

            // Center the frame on the screen
            f.setLocationRelativeTo(null);

            // Make the frame visible
            f.setVisible(true);

        placeholderEntryForm = new InfectedUserData(name, diseaseData, email, birthdate, 0, false, null);


        }

        //System.out.println("TEST: " + DataEntryGUI.validate(placeholderEntryForm));

        

    }

    // If the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {

            firstSubmission = true;
            tries++;

            // Retrieve data from text fields and store in variables
            name = t1.getText();
            email = t2.getText();
            birthdate = t3.getText();
            children = t4.getText();
            diseaseData = t5.getText();

            // Clear text fields
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");

            // Print the stored data to the console
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Birthdate: " + birthdate);
            System.out.println("Number of Children: " + children);
            System.out.println("Disease Data: " + diseaseData);

            while (DataEntryGUI.validate(placeholderEntryForm) != 5) {
            

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");


            }

            if (DataEntryGUI.validate(placeholderEntryForm) == 5) {
            Container contentPane = f.getContentPane();
            contentPane.removeAll();
            contentPane.repaint();
        } 
    }
    }

    public static int validate(InfectedUserData form) {
        int finalNum = 5;

        /* 
        System.out.println("FORM NAME: " + form.getName());
        System.out.println("FORM DATA: " + form.getData());
        System.out.println("FORM Email: " + form.getEmail());
        System.out.println("FORM Birthdate: " + form.getBirthdate());
        System.out.println("FORM NumChild: " + form.getNumChildren());

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
        //FIXME bug with entering string into box with validations using Integer.parseInt
        if (form.validateNumChild(0) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }

        System.out.println("Final Num: " + finalNum);

        */
        
        return finalNum;
    }
}