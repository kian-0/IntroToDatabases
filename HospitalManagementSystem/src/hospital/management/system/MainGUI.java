package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {

    public static void main(String[] args) {
        // Create the main JFrame
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
        addPatientButton.addActionListener(e -> new AddPatientGUI());
        addDepartmentButton.addActionListener(e -> new AddDepartmentGUI());
        addProcedureButton.addActionListener(e -> new AddProcedureGUI());
        addDoctorButton.addActionListener(e -> new AddDoctorGUI());
        addInteractionButton.addActionListener(e -> new AddInteractionGUI());
        addMedicationButton.addActionListener(e -> new AddMedicationGUI());
        generateRecordButton.addActionListener(e -> new GenerateHealthRecordGUI());
        findProcedureButton.addActionListener(e -> new FindProceduresByDepartmentGUI());
        listProceduresButton.addActionListener(e -> new ListProceduresByDoctorGUI());
        exitButton.addActionListener(e -> System.exit(0));

        // Add panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }
}
