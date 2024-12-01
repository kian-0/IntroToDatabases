package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDepartmentGUI {
    public AddDepartmentGUI(Connection conn) {
        JFrame frame = new JFrame("Add Department");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Department Name:");
        JTextField nameField = new JTextField();

        JLabel codeLabel = new JLabel("Department Code:");
        JTextField codeField = new JTextField();

        JLabel numberLabel = new JLabel("Office Number:");
        JTextField numberField = new JTextField();

        JLabel phoneLabel = new JLabel("Office Phone:");
        JTextField phoneField = new JTextField();

        JLabel headLabel = new JLabel("Department Head ID:");
        JTextField headField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(nameLabel); panel.add(nameField);
        panel.add(codeLabel); panel.add(codeField);
        panel.add(numberLabel); panel.add(numberField);
        panel.add(phoneLabel); panel.add(phoneField);
        panel.add(headLabel); panel.add(headField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String code = codeField.getText();
                String number = numberField.getText();
                String phone = phoneField.getText();
                String head = headField.getText();

                try{
                    String query = "INSERT INTO DEPARTMENT(DNAME, DCODE, DNUMBER, DPHONE, DHEADID) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, name);
                    stmt.setString(2, code);
                    stmt.setString(3, number);
                    stmt.setString(4, phone);
                    stmt.setString(5, head);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Department added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
