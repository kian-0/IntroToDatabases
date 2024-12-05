package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPatientGUI {
    public AddPatientGUI() {
        JFrame frame = new JFrame("Add Patient");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(16, 2, 10, 10));

        JLabel pidLabel = new JLabel("Patient ID:");
        JTextField pidField = new JTextField();

        JLabel ssnLabel = new JLabel("SSN:");
        JTextField ssnField = new JTextField();

        JLabel fnameLabel = new JLabel("First Name:");
        JTextField fnameField = new JTextField();

        JLabel lnameLabel = new JLabel("Last Name:");
        JTextField lnameField = new JTextField();

        JLabel sexLabel = new JLabel("Sex:");
        JTextField sexField = new JTextField();

        JLabel bdateLabel = new JLabel("Birthdate (YYYY-MM-DD):");
        JTextField bdateField = new JTextField();

        JLabel conditionLabel = new JLabel("Condition:");
        JTextField conditionField = new JTextField();

        JLabel currentAddressLabel = new JLabel("Current Address:");
        JTextField currentAddressField = new JTextField();
        
        JLabel permanentAddressLabel = new JLabel("Permanent Address:");
        JTextField permanentAddressField = new JTextField();

        JLabel currentPhoneLabel = new JLabel("Current Phone:");
        JTextField currentPhoneField = new JTextField();
        
        JLabel permanentPhoneLabel = new JLabel("Permanent Phone:");
        JTextField permanentPhoneField = new JTextField();

        JLabel doctorIdLabel = new JLabel("Primary Doctor ID:");
        JTextField doctorIdField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(pidLabel); panel.add(pidField);
        panel.add(ssnLabel); panel.add(ssnField);
        panel.add(fnameLabel); panel.add(fnameField);
        panel.add(lnameLabel); panel.add(lnameField);
        panel.add(sexLabel); panel.add(sexField);
        panel.add(bdateLabel); panel.add(bdateField);
        panel.add(conditionLabel); panel.add(conditionField);
        panel.add(currentAddressLabel); panel.add(currentAddressField);
        panel.add(permanentAddressLabel); panel.add(permanentAddressField);
        panel.add(currentPhoneLabel); panel.add(currentPhoneField);
        panel.add(permanentPhoneLabel); panel.add(permanentPhoneField);
        panel.add(doctorIdLabel); panel.add(doctorIdField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid = pidField.getText();
                String ssn = ssnField.getText();
                String fname = fnameField.getText();
                String lname = lnameField.getText();
                String sex = sexField.getText();
                String bdate = bdateField.getText();
                String condition = conditionField.getText();
                String currentAddress = currentAddressField.getText();
                String permanentAddress = permanentAddressField.getText();
                String currentPhone = currentPhoneField.getText();
                String permanentPhone = permanentPhoneField.getText();
                String doctorId = doctorIdField.getText();

                try (Connection conn = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO PATIENT(PID, SSN, FNAME, LNAME, SEX, BIRTHDATE, CONDIT, CURRADDRESS, CURRPHONE, DOCTORID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, pid);
                    stmt.setString(2, ssn);
                    stmt.setString(3, fname);
                    stmt.setString(4, lname);
                    stmt.setString(5, sex);
                    stmt.setString(6, bdate);
                    stmt.setString(7, condition);
                    stmt.setString(8, permanentAddress);
                    stmt.setString(8, currentAddress);
                    stmt.setString(9, currentPhone);
                    stmt.setString(9, permanentPhone);
                    stmt.setString(10, doctorId);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Patient added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
