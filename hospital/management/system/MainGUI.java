
package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {

    public static void main(String[] args) {
        // Creates da main JFrame
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates JPanel for de buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Creates buttons 
        JButton addPatientButton = new JButton("Add Patient");
        JButton addDepartmentButton = new JButton("Add Department");
        JButton addProcedureButton = new JButton("Add Procedure/Operation");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton addInteractionButton = new JButton("Add Interaction Record");
        JButton addMedicationButton = new JButton("Add Medication");
        JButton exitButton = new JButton("Exit");

        // Adds buttons to  panel
        panel.add(addPatientButton);
        panel.add(addDepartmentButton);
        panel.add(addProcedureButton);
        panel.add(addDoctorButton);
        panel.add(addInteractionButton);
        panel.add(addMedicationButton);
        panel.add(exitButton);

        // Adds action listeners 
        addPatientButton.addActionListener(e -> new AddPatientGUI());
        addDepartmentButton.addActionListener(e -> new AddDepartmentGUI());
        addProcedureButton.addActionListener(e -> new AddProcedureGUI());
        addDoctorButton.addActionListener(e -> new AddDoctorGUI());
        addInteractionButton.addActionListener(e -> new AddInteractionGUI());
        addMedicationButton.addActionListener(e -> new AddMedicationGUI());
        
        exitButton.addActionListener(e -> System.exit(0));

        // Adds panel to the frame
        frame.add(panel);

        // Sets de frame visibility
        frame.setVisible(true);
    }
}
