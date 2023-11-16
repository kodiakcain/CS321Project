package DiseaseManagementSystem;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

/**
 * This class serves as the central screen which displays for our user. They are shown 3 buttons which
 * they can press to load the various screens in the system.
 * 
 * @author John Fulton, Cain Clifton, Youssef Melk
 */
public class CentralGUI extends JFrame implements ActionListener {
    
    /**
     * These are the various buttons that the user can press to choose what screen they want
     * to load or to exit the system.
     */
    static JButton dataEntryButton, reviewButton, approvalButton, exitButton;
    /**
     * This label is the welcome message that displays above the buttons to greet the user.
     */
    static JLabel welcomeMessage;
    /**
     * This JFrame is the window that the screen will be displayed in.
     */
    static JFrame f;

    /**
     * This method loads the central screen
     */
    public static void loadCentralScreen() {

        // making frame
        f = new JFrame("Disease Management System");

        // making label
        welcomeMessage = new JLabel("Welcome to the Disease Management System");

        // making buttons
        dataEntryButton = new JButton("Load Data Entry System");
        reviewButton = new JButton("Load Reviewing System");
        approvalButton = new JButton("Load Approval System");

        // making gui object
        CentralGUI gui = new CentralGUI();

        // added action listeners
        dataEntryButton.addActionListener(gui);
        reviewButton.addActionListener(gui);
        approvalButton.addActionListener(gui);

        // creating panel and gbc
        JPanel centralPanel = new JPanel(new GridBagLayout());

        // displaying 3 
        GridBagConstraints centralGBC = new GridBagConstraints();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Adding the welcome label
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(welcomeLabel, gbc);

        // Adding the first button
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button1, gbc);

        // Adding the second (central) button
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(button2, gbc);

        // Adding the third button
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(button3, gbc);

        // Adding the exit button
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(exitButton, gbc);


        centralGBC.gridx = 0; // First column
        frame.add(button1, centralGBC);

        centralGBC.gridx = 1; // Second column
        frame.add(button2, centralGBC);

        centralGBC.gridx = 2; // Third column
        frame.add(button3, centralGBC);

        

        frame.setVisible(true);
    }

    /**
     * This method is a part of the actionListener.
     * It handles action events that are triggered by the user when they press the following
     * buttons: dataEntryButton, reviewButton, approvalButton, and the exitButton.
     * @param e the event recorded by the action listener (what button the user pressed).
     */
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * This method serves as the driver method for the central screen.
     * @param args the array of strings passed in as CLI by the user.
     */
    public static void main(String[] args) {
        loadCentralScreen();
    }


}
