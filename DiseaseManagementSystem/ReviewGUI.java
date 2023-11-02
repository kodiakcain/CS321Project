package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

public class ReviewGUI extends JFrame implements ActionListener {
    static JFrame f1;
    // Labels to display text
    static JLabel l1, l2, l3, l4, l5;
    // Add text fields
    static JTextField t1, t2, t3, t4, t5;

    public static void loadReviewScreen(String name, String email, String birthdate, String numChildren, String data) {
        f1 = new JFrame("Disease Management System - Review Data");

        ReviewGUI gui = new ReviewGUI();

        JButton b = new JButton("Submit for Approval");

        b.addActionListener(gui);

        // Set the frame to visible
        f1.setVisible(true);

        // Maximize the screen size
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        l1 = new JLabel("Entered Name: " + name);
        l2 = new JLabel("Entered Email: " + email);
        l3 = new JLabel("Entered Birthdate: " + birthdate);
        l4 = new JLabel("Entered Number of Children: " + numChildren);
        l5 = new JLabel("Entered Disease Data: " + data);

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

    public static int validate(InfectedUserData form) {

        //final number of valid parts
        int finalNum = 0;

        //add validation for name
        if (form.validateName(form.name) == 1) {
            finalNum++;
        } else {
            //add clear data form and show name error message
        }

        //add validation for disease data
        if (form.validateInfectiousData(form.diseaseData) == 1) {
            finalNum++;
        } else {
            //add clear data form and show data error message
        }

        //add validation for email
        if (form.validateEmail(form.email) == 1) {
            finalNum++;
        } else {
            //add clear data form and show email error message
        }

        //add validation for birthdate
        if (form.validateBirthdate(form.birthdate) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }

        //add validation for number of children
        if (form.validateNumChild(form.numChildren) == 1) {
            finalNum++;
        } else {
            //add clear data form and show birthdate error message
        }
        
        //return total valid
        return finalNum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Submit for Approval")) {
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setVisible(false);

            // Create a new instance of ApprovalGUI
            ApprovalGUI approval = new ApprovalGUI();

            //Validate any data that was entered by the review agent.
            if (!(t1.getText().equals(""))) {
                
            } 
            
            if (!(t2.getText().equals(""))) {

            }
            
            if (!(t3.getText().equals(""))) {

            }
            
            if (!(t4.getText().equals(""))) {

            } 
            
            if (!(t5.getText().equals(""))) {

            }
            
            // Load approval system screen

            // Needs to be fixed, currently is constructing the approval screen with the textfields (which can be empty)
            // causing unanticipated behavior.
            approval.loadApprovalScreen(
                t1.getText(),
                t2.getText(),
                t3.getText(),
                t4.getText(),
                t5.getText()
        );
    }
}
}