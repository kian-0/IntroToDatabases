package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindProceduresByDepartmentGUI {
    public FindProceduresByDepartmentGUI() {
        // Create JFrame for the GUI
        JFrame frame = new JFrame("Find Procedures by Department");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));  // 3 rows, 2 columns
        
        // Create components
        JLabel departmentLabel = new JLabel("Enter Department Name or Code:");
        JTextField departmentTextField = new JTextField();
        JButton findButton = new JButton("Find Procedures");
        
        // Add components to the panel
        panel.add(departmentLabel);
        panel.add(departmentTextField);
        panel.add(findButton);
        
        // Add panel to the frame
        frame.add(panel);
        
        // Button action listener
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String departmentInput = departmentTextField.getText();
               
                JOptionPane.showMessageDialog(frame, "Finding procedures for: " + departmentInput);
            }
        });
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
