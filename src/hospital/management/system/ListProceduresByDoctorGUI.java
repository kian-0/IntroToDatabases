package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListProceduresByDoctorGUI {
    public ListProceduresByDoctorGUI() {
        // Create JFrame for the GUI
        JFrame frame = new JFrame("List Procedures by Doctor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));  // 3 rows, 2 columns
        
        // Create components
        JLabel doctorLabel = new JLabel("Enter Doctor ID:");
        JTextField doctorTextField = new JTextField();
        JButton listButton = new JButton("List Procedures");
        
        // Add components to the panel
        panel.add(doctorLabel);
        panel.add(doctorTextField);
        panel.add(listButton);
        
        // Add panel to the frame
        frame.add(panel);
        
        // Button action listener
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorId = doctorTextField.getText();
                
                JOptionPane.showMessageDialog(frame, "Listing procedures for Doctor ID: " + doctorId);
            }
        });
        
        // Make the frame visible
        frame.setVisible(true);
    }
}

