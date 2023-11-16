package DiseaseManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

        CentralGUI gui = new CentralGUI();

        dataEntryButton.addActionListener(gui);
        reviewButton.addActionListener(gui);
        approvalButton.addActionListener(gui);




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
