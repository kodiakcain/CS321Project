package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;

class DataEntryGUI extends JFrame implements ActionListener {
    // JTextField
    static JTextField t1, t2, t3;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // Labels to display text
    static JLabel l1, l2, l3;

    // Default constructor
    DataEntryGUI() {
    }

    // Main class
    public static void main(String[] args) {
        // Create a new frame to store text fields and button
        f = new JFrame("Text Fields");

        // Create labels to display text
        l1 = new JLabel("Field 1:");
        l2 = new JLabel("Field 2:");
        l3 = new JLabel("Field 3:");

        // Create a new button
        b = new JButton("Submit");

        // Create an object of the TextFieldsDemo class
        DataEntryGUI demo = new DataEntryGUI();

        // Add ActionListener to the button
        b.addActionListener(demo);

        // Create three objects of JTextField with 16 columns
        t1 = new JTextField(5);
        t2 = new JTextField(5);
        t3 = new JTextField(5);

        // Create a panel to add labels, text fields, and the button
        JPanel p = new JPanel();

        // Add labels, text fields, and the button to the panel
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(b);

        // Add the panel to the frame
        f.add(p);

        // Set the size of the frame
        f.setSize(10, 10);

        // Set the layout manager for the panel
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        // Make the frame visible
        f.setVisible(true);
    }

    // If the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {
            // Set the text of labels to the text of the fields
            l1.setText("Field 1: " + t1.getText());
            l2.setText("Field 2: " + t2.getText());
            l3.setText("Field 3: " + t3.getText());

            // Set the text of fields to blank
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
}