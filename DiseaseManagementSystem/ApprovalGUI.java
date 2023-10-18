package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

public class ApprovalGUI extends JFrame implements ActionListener{

    static JFrame f1;
    

public static void loadApprovalScreen() {
    f1 = new JFrame("Disease Management System - Approve Data");

    ApprovalGUI gui = new ApprovalGUI();

    //set the frame to visible
    f1.setVisible(true);

    //maximize the screen size
    f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
}

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}

}