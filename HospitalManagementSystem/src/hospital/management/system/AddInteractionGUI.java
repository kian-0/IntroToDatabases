package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddInteractionGUI {
    public AddInteractionGUI() {
        JFrame frame = new JFrame("Add Interaction Record");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel interactionIdLabel = new JLabel("Interaction ID:");
        JTextField interactionIdField = new JTextField();

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel patientIdLabel = new JLabel("Patient ID:");
        JTextField patientIdField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(interactionIdLabel); panel.add(interactionIdField);
        panel.add(dateLabel); panel.add(dateField);
        panel.add(descriptionLabel); panel.add(descriptionField);
        panel.add(patientIdLabel); panel.add(patientIdField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String interactionId = interactionIdField.getText();
                String date = dateField.getText();
                String description = descriptionField.getText();
                String patientId = patientIdField.getText();

                try (Connection conn = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO INTERACTIONRECORD(IID, IDATE, DESCRIPTION, PATIENTID) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, interactionId);
                    stmt.setString(2, date);
                    stmt.setString(3, description);
                    stmt.setString(4, patientId);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Interaction record added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
