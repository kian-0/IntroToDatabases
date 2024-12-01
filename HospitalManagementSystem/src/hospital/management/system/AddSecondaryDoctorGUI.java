package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddSecondaryDoctorGUI {
    public AddSecondaryDoctorGUI() {
        // Create the frame
        JFrame frame = new JFrame("Assign Doctor to Patient");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Create labels and text fields
        JLabel patientIdLabel = new JLabel("Patient ID:");
        JTextField patientIdField = new JTextField();

        JLabel doctorIdLabel = new JLabel("Doctor ID:");
        JTextField doctorIdField = new JTextField();

        // Submit button
        JButton submitButton = new JButton("Submit");

        // Add components to panel
        panel.add(patientIdLabel);
        panel.add(patientIdField);
        panel.add(doctorIdLabel);
        panel.add(doctorIdField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(submitButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = patientIdField.getText();
                String doctorId = doctorIdField.getText();

                // Perform basic validation
                if (patientId.isEmpty() || doctorId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                    return;
                }

                // Attempt to insert data into the database
                try (Connection conn = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO PATIENT_DOCTOR (PATIENT_ID, DOCTOR_ID) VALUES (?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, patientId);
                    stmt.setString(2, doctorId);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Doctor assigned to patient successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
