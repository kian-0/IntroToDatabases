package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainGUI {	
	private static String username;
	private static String password;
	private static String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	
    public static void main(String[] args) {
        // Start the login window
    	showLoginDialog();
    }

    public static void showLoginDialog() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Panel to hold input fields and buttons
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                password = new String(passwordField.getPassword());

                try(Connection con = DriverManager.getConnection(url, username, password)) {
                    // Try connecting to the database
                    JOptionPane.showMessageDialog(frame, "Connection Successful!");
                    mainGUI();
                    frame.dispose();  // Close the login window once connection is successful
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Connection Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }//cisvm-oracle	n01449744@//cisvm-oracle.unfcsd.unf.edu:1521/orcl
	
    public static void mainGUI() {
        // Create the main JFrame
    	try {
			Connection con = DriverManager.getConnection(url, username, password);
		
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns, space between buttons

        // Create buttons for each functionality
        JButton addPatientButton = new JButton("Add Patient");
        JButton addDepartmentButton = new JButton("Add Department");
        JButton addProcedureButton = new JButton("Add Procedure/Operation");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton addInteractionButton = new JButton("Add Interaction Record");
        JButton addMedicationButton = new JButton("Add Medication");
        JButton generateRecordButton = new JButton("Generate Health Record");
        JButton findProcedureButton = new JButton("Find Procedures by Department");
        JButton listProceduresButton = new JButton("List Procedures by Doctor");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        panel.add(addPatientButton);
        panel.add(addDepartmentButton);
        panel.add(addProcedureButton);
        panel.add(addDoctorButton);
        panel.add(addInteractionButton);
        panel.add(addMedicationButton);
        panel.add(generateRecordButton);
        panel.add(findProcedureButton);
        panel.add(listProceduresButton);
        panel.add(exitButton);

        // Add action listeners for each button
        addPatientButton.addActionListener(e -> new AddPatientGUI(con));
        addDepartmentButton.addActionListener(e -> new AddDepartmentGUI(con));
        addProcedureButton.addActionListener(e -> new AddProcedureGUI(con));
        addDoctorButton.addActionListener(e -> new AddDoctorGUI(con));
        addInteractionButton.addActionListener(e -> new AddInteractionGUI(con));
        addMedicationButton.addActionListener(e -> new AddMedicationGUI(con));
        generateRecordButton.addActionListener(e -> new GenerateHealthRecordGUI(con));
        findProcedureButton.addActionListener(e -> new FindProceduresByDepartmentGUI());
        listProceduresButton.addActionListener(e -> new ListProceduresByDoctorGUI());
        exitButton.addActionListener(e -> System.exit(0));

        // Add panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    	} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
