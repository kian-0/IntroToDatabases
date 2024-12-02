package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateHealthRecordGUI {
    public GenerateHealthRecordGUI() {
        JFrame frame = new JFrame("Generate Health Record");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel patientIdLabel = new JLabel("Patient ID:");
        JTextField patientIdField = new JTextField(10);
        JButton fetchButton = new JButton("Fetch Record");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(patientIdLabel);
        inputPanel.add(patientIdField);
        inputPanel.add(fetchButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);

        fetchButton.addActionListener(e -> {
            String patientId = patientIdField.getText();
            try (Connection conn = DatabaseConnector.getConnection()) {
                String query = "SELECT * FROM PATIENT WHERE PID = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, patientId);
                ResultSet rs = stmt.executeQuery();

                StringBuilder record = new StringBuilder();
                while (rs.next()) {
                    record.append("Patient ID: ").append(rs.getString("PID")).append("\n");
                    record.append("Name: ").append(rs.getString("FNAME")).append(" ")
                            .append(rs.getString("LNAME")).append("\n");
                    record.append("Condition: ").append(rs.getString("CONDIT")).append("\n");
                    record.append("Address: ").append(rs.getString("CURRADDRESS")).append("\n");
                    record.append("Phone: ").append(rs.getString("CURRPHONE")).append("\n");
                    // Add additional fields as needed
                }

                resultArea.setText(record.length() > 0 ? record.toString() : "No record found.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });
    }
}
