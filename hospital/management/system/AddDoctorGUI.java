package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDoctorGUI {
    public AddDoctorGUI() {
        JFrame frame = new JFrame("Add Doctor");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        JLabel idLabel = new JLabel("Doctor ID:");
        JTextField idField = new JTextField();

        JLabel ssnLabel = new JLabel("SSN:");
        JTextField ssnField = new JTextField();

        JLabel fnameLabel = new JLabel("First Name:");
        JTextField fnameField = new JTextField();

        JLabel lnameLabel = new JLabel("Last Name:");
        JTextField lnameField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        JLabel birthdateLabel = new JLabel("Birthdate (YYYY-MM-DD):");
        JTextField birthdateField = new JTextField();

        JLabel departmentLabel = new JLabel("Department Code:");
        JTextField departmentField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(idLabel); panel.add(idField);
        panel.add(ssnLabel); panel.add(ssnField);
        panel.add(fnameLabel); panel.add(fnameField);
        panel.add(lnameLabel); panel.add(lnameField);
        panel.add(addressLabel); panel.add(addressField);
        panel.add(phoneLabel); panel.add(phoneField);
        panel.add(birthdateLabel); panel.add(birthdateField);
        panel.add(departmentLabel); panel.add(departmentField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String ssn = ssnField.getText();
                String fname = fnameField.getText();
                String lname = lnameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String birthdate = birthdateField.getText();
                String department = departmentField.getText();

                try (Connection conn = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO DOCTOR(DID, SSN, FNAME, LNAME, ADDRESS, PHONENUMBER, BIRTHDATE, DCODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, id);
                    stmt.setString(2, ssn);
                    stmt.setString(3, fname);
                    stmt.setString(4, lname);
                    stmt.setString(5, address);
                    stmt.setString(6, phone);
                    stmt.setString(7, birthdate);
                    stmt.setString(8, department);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
