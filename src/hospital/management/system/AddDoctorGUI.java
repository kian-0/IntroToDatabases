package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDoctorGUI {
    public AddDoctorGUI() {
        // Create the frame
        JFrame frame = new JFrame("Add Doctor");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));

        // Create labels and text fields
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

        // Submit button
        JButton submitButton = new JButton("Submit");

        // Add components to panel
        panel.add(idLabel); panel.add(idField);
        panel.add(ssnLabel); panel.add(ssnField);
        panel.add(fnameLabel); panel.add(fnameField);
        panel.add(lnameLabel); panel.add(lnameField);
        panel.add(addressLabel); panel.add(addressField);
        panel.add(phoneLabel); panel.add(phoneField);
        panel.add(birthdateLabel); panel.add(birthdateField);
        panel.add(departmentLabel); panel.add(departmentField);
        panel.add(submitButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Submit button action listener
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

                // Perform basic validation
                if (id.isEmpty() || ssn.isEmpty() || fname.isEmpty() || lname.isEmpty() || 
                    address.isEmpty() || phone.isEmpty() || birthdate.isEmpty() || department.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                    return;
                }

                // Validate SSN (just a simple example of validation)
                if (!isValidSSN(ssn)) {
                    JOptionPane.showMessageDialog(frame, "Invalid SSN format.");
                    return;
                }

                // Validate phone number format (e.g., only digits and length of 10)
                if (!isValidPhone(phone)) {
                    JOptionPane.showMessageDialog(frame, "Invalid phone number format.");
                    return;
                }

                // Validate birthdate (simple YYYY-MM-DD check)
                if (!isValidBirthdate(birthdate)) {
                    JOptionPane.showMessageDialog(frame, "Invalid birthdate format. Use YYYY-MM-DD.");
                    return;
                }

                // Attempt to insert data into the database
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

    // Helper method to validate SSN format (simple example: 123-45-6789)
    private boolean isValidSSN(String ssn) {
        Pattern pattern = Pattern.compile("^(?!000|666|9\\d\\d)\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$");
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }

    // Helper method to validate phone number (e.g., 123-456-7890)
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    // Helper method to validate birthdate format (YYYY-MM-DD)
    private boolean isValidBirthdate(String birthdate) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(birthdate);
        return matcher.matches();
    }
}
