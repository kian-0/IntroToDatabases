package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMedicationGUI {
    public AddMedicationGUI() {
        JFrame frame = new JFrame("Add Medication");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Medication Name:");
        JTextField nameField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        JTextField manufacturerField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(nameLabel); panel.add(nameField);
        panel.add(descriptionLabel); panel.add(descriptionField);
        panel.add(manufacturerLabel); panel.add(manufacturerField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descriptionField.getText();
                String manufacturer = manufacturerField.getText();

                try (Connection conn = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO MEDICATION(MNAME, MDESCRIPTION, MANUFACTURER) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, name);
                    stmt.setString(2, description);
                    stmt.setString(3, manufacturer);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Medication added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
