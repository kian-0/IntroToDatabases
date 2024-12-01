package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProcedureGUI {
    public AddProcedureGUI(Connection conn) {
        JFrame frame = new JFrame("Add Procedure/Operation");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel numberLabel = new JLabel("Procedure Number:");
        JTextField numberField = new JTextField();

        JLabel nameLabel = new JLabel("Procedure Name:");
        JTextField nameField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel durationLabel = new JLabel("Duration:");
        JTextField durationField = new JTextField();

        JLabel departmentLabel = new JLabel("Offering Department:");
        JTextField departmentField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(numberLabel); panel.add(numberField);
        panel.add(nameLabel); panel.add(nameField);
        panel.add(descriptionLabel); panel.add(descriptionField);
        panel.add(durationLabel); panel.add(durationField);
        panel.add(departmentLabel); panel.add(departmentField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberField.getText();
                String name = nameField.getText();
                String description = descriptionField.getText();
                String duration = durationField.getText();
                String department = departmentField.getText();

                try {
                    String query = "INSERT INTO OPERATION(PNUMBER, PNAME, PDESCRIPTION, PDURATION, OFFERDEP) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, number);
                    stmt.setString(2, name);
                    stmt.setString(3, description);
                    stmt.setString(4, duration);
                    stmt.setString(5, department);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Procedure/Operation added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
