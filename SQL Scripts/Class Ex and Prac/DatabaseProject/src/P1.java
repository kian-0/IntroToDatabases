/*
 * If we are able to get a fully operating 
 * GUI we can replace the beginning of the code.
 * 
 * 
 */

import java.sql.*;
import java.util.Scanner;
import java.io.*;  

public class P1 {
	public static void main (String args []) 
		throws SQLException
		{
		
		//Gets Oracle UserName and Password
		System.out.print("userid: ");
	    String uid = getString();

	    System.out.print("password: ");
	    String pword = getString();
		
	    // Load the Oracle JDBC driver
	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";

	    
	    // Connect to the database
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    
	    // Connect to the database
	    Connection conn =
	    DriverManager.getConnection (url, uid, pword);
	    
	    
	    Scanner scnr = new Scanner(System.in);
	    
	    int operating = 1; 
	    
	    while(operating != 0) {
	    System.out.println("\n*** Hospital Management System ***");
	    System.out.println("Please Choose an option!");
        System.out.println("1. Add a Patient");
        System.out.println("2. Add a Department");
        System.out.println("3. Add a Procedure/Operation");
        System.out.println("4. Add a Doctor");
        System.out.println("5. Add an Interaction Record");
        System.out.println("6. Generate Health Record for a Patient");
        System.out.println("7. Find Procedures by Department");
        System.out.println("8. List Procedures Done by a Doctor");
        System.out.println("9. Add Medication");
        System.out.println("10. Add Prescription");
        System.out.println("11. Add Undergo");
        System.out.println("12. Exit");
        System.out.print("Choose an option: ");
	    
	    int option = scnr.nextInt();
	    scnr.nextLine();
	    switch (option) {
	    
	    case 1:
	    	addPatient(conn,scnr);
	    	break;
	    case 2:
	    	addDepartment(conn,scnr);
	    	break;
	    case 3:
	    	addProcedureOperation(conn,scnr);
	    	break;
	    case 4:
	    	addDoctor(conn,scnr);
	    	break;
	    case 5:
	    	addInteraction(conn,scnr);
	    	break;
	    case 6:
	    	generateRecord(conn,scnr);
	    	break;
	    case 7:
	    	ProceduresByDepartment(conn,scnr);
	    	break;
	    case 8:
	    	ProceduresByDoctor(conn,scnr);
	    	break;
	    case 9:
	    	addMedication(conn,scnr);
	    	break;
	    case 10:
	    	addPrescription(conn,scnr);
	    	break;
	    case 11:
	    	addUndergo(conn,scnr);
	    	break;
	    case 12:
	    	operating = 0;
	    	break;
	    default:
	    	System.out.println("Not an option please try again.");
	    	break;
	    
	    }// end of switch
	    
	    }//end of while
	    
	    System.out.println("Database closing! Bye!");
	    
		conn.close();
		scnr.close();
		
	}// end of main
	
	
	//should be complete but have not tested yet
	private static void addUndergo(Connection conn, Scanner scnr) {
		try {
		PreparedStatement undergo = conn.prepareStatement("INSERT INTO UNDERGO (patientID,doctorID,datePerformed,notes,pnumber)" + "VALUES(?,?,?,?,?)");
		
		System.out.println("Insert PatientID\n");
		undergo.setString(1, getString());
		
		System.out.println("Insert DoctorId\n");
		undergo.setString(2, getString());
		
		System.out.println("Insert datePerformed (YYYY-MM-DD)\n");
        undergo.setDate(3, java.sql.Date.valueOf(getString()));
		
        System.out.println("Insert notes\n");
        undergo.setString(4, getString());
        
        System.out.println("Insert pnumber\n");
        undergo.setString(5, getString());
        
        undergo.executeUpdate();
        System.out.println("Success");
        
        
		}catch(SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		    e.printStackTrace();
		}//end of try/catch
		
		
	}// end of addUndergo

	
	// Should be Complete but i  have not been able to test this
	private static void addPrescription(Connection conn, Scanner scnr) {
		try {
		PreparedStatement addprescription = conn.prepareStatement("INSERT INTO PRESCRIPTION (patientID,doctorID,datePrescribed,mname)" + "VALUES (?,?,?,?)");
	
		System.out.println("Insert PatientID\n");
		addprescription.setString(1, getString());
		
		System.out.println("Insert DoctorID\n");
		addprescription.setString(2, getString());
		
		System.out.println("Insert datePerformed (YYYY-MM-DD)\n");
		addprescription.setDate(3, java.sql.Date.valueOf(getString()));
		
		System.out.println("Insert mname\n");
		addprescription.setString(4, getString());
		
		addprescription.executeUpdate();
		System.out.println("Success");
		
		
		}catch(SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		    e.printStackTrace();
		}// end of try/catch
		
		}// end of addPrescription

	
	
	// addMedication Complete
	private static void addMedication(Connection conn, Scanner scnr) {
		try {
			
			PreparedStatement Medication = conn.prepareStatement("INSERT INTO MEDICATION(mname,mdescription,manufactuer)" + "VALUES(?,?,?)");
			
			System.out.println("Insert mname\n");
			Medication.setString(1, getString());
			
			System.out.println("Insert mdescription\n");
			Medication.setString(2, getString());
			
			System.out.println("Insert manufacturer\n");
			Medication.setString(3, getString());
			
			Medication.executeUpdate();
			System.out.println("Success");
		}	
			catch (SQLException e) {System.out.println("SQL Error: " + e.getMessage());
		    e.printStackTrace();}
		
		
	}// end of addMedication

	
	
	// addProcedureOperation Complete
	private static void addProcedureOperation(Connection conn, Scanner scnr) {
		try {
		
			PreparedStatement Operation = conn.prepareStatement("INSERT INTO OPERATION(pnumber,pname,pdescription,pduration,offerdep)" + "VALUES(?,?,?,?,?)");
			
			System.out.println("Insert pnumber\n");
			Operation.setString(1, getString());
			
			System.out.println("Insert pname\n");
			Operation.setString(2, getString());
			
			System.out.println("Insert pdescription\n");
			Operation.setString(3, getString());
			
			System.out.println("Insert pduration\n");
			Operation.setString(4, getString());
			
			System.out.println("Insert offerdep\n");
			Operation.setString(5, getString());
			
			Operation.executeUpdate();
			System.out.println("Success");
	}
		
	catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        e.printStackTrace();
    }// end of try/catch
	
	}//end of addProcedureOperation
	
	
	// addPatient Complete
	private static void addPatient(Connection conn, Scanner scnr) {
	    try {
	        // Prepare the SQL statement
	        PreparedStatement Patient = conn.prepareStatement(
	            "INSERT INTO PATIENT(PID, ssn, fname, minitial, lname, sex, birthdate, condit, curraddress, " +
	            "currphone, permaddress, permcity, permstate, permzipp, permphone, doctorID) " +
	            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	        
	        System.out.println("Insert PID\n");
	        Patient.setString(1, getString());
	        
	        System.out.println("Insert ssn\n");
	        Patient.setString(2, getString()); 
	        
	        System.out.println("Insert fname\n");
	        Patient.setString(3, getString());
	        
	        System.out.println("Insert mininitial\n");
	        Patient.setString(4, getString());
	        
	        System.out.println("Insert lname\n");
	        Patient.setString(5, getString());
	        
	        System.out.println("Insert sex\n");
	        Patient.setString(6, getString());
	        
	        System.out.println("Insert birthdate (YYYY-MM-DD)\n");
	        Patient.setDate(7, java.sql.Date.valueOf(getString())); // Convert to SQL Date
	        
	        System.out.println("Insert condit\n");
	        Patient.setString(8, getString());
	        
	        System.out.println("Insert curraddress\n");
	        Patient.setString(9, getString());
	        
	        System.out.println("Insert currphone\n");
	        Patient.setString(10, getString());
	        
	        System.out.println("Insert permaddress\n");
	        Patient.setString(11, getString());
	        
	        System.out.println("Insert permcity\n");
	        Patient.setString(12, getString());
	        
	        System.out.println("Insert permstate\n");
	        Patient.setString(13, getString());
	        
	        System.out.println("Insert permzipp\n");
	        Patient.setInt(14, getInt());
	        
	        System.out.println("Insert permphone\n");
	        Patient.setString(15, getString());
	        
	        System.out.println("Insert DoctorId\n");
	        Patient.setString(16, getString());
	        
	        //Executes the Statement
	        Patient.executeUpdate();
	        System.out.println("Patient Added!");
	        
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	        e.printStackTrace();
	    }// end of try/catch
	}//end of addPatient
	
	
	
	
	
	
	// addDepartment Complete
	private static void addDepartment(Connection conn, Scanner scnr) {
		
			try {
				PreparedStatement Department = conn.prepareStatement("INSERT INTO DEPARTMENT(dname, dcode, dnumber, dphone, dheadID)" + "VALUES(?,?,?,?,?)");
				
				System.out.println("Insert dname\n");
			    Department.setString(1, getString());
			        
			    System.out.println("Insert dcode (4 Chars)\n");
			    Department.setString(2, getString());
			        
			    System.out.println("Insert dnumber (4 Digits)\n");
			    Department.setString(3, getString());
			        
			    System.out.println("Insert dphone (10 Digits)\n");
			    Department.setString(4, getString());
			        
			    System.out.println("Insert dheadID (D followed by 8 Digits)\n");
			    Department.setString(5, getString());
			
			        
			    Department.executeUpdate();
			    System.out.println("Department Added!");
			
				} catch (SQLException e) {
						
					System.out.println("SQL Error: " + e.getMessage());
			        e.printStackTrace();
			
		}// end of try/catch
			
			
		}// end of addDepartment
		
	
		// addDoctor Complete
		private static void addDoctor(Connection conn, Scanner scnr) {
			try {
				PreparedStatement Doctor = conn.prepareStatement("INSERT INTO DOCTOR(DID,ssn,fname,minitial,lname,address,phonenumber,birthdate,dcode)" + "VALUES(?,?,?,?,?,?,?,?,?)");
				System.out.println("Insert DID\n");
				Doctor.setString(1, getString());
				
				System.out.println("Insert ssn\n");
				Doctor.setInt(2, getInt());
				
				System.out.println("Insert fname\n");
				Doctor.setString(3, getString());
				
				System.out.println("Insert minitial\n");
				Doctor.setString(4, getString());
				
				System.out.println("Insert lname\n");
				Doctor.setString(5, getString());
				
				System.out.println("Insert address\n");
				Doctor.setString(6, getString());
				
				System.out.println("Insert phonenumber\n");
				Doctor.setString(7,getString());
				
				System.out.println("Insert birthdate (YYYY-MM-DD)\n");
			    Doctor.setDate(8, java.sql.Date.valueOf(getString()));
			        
				System.out.println("Insert dcode\n");
				Doctor.setString(9,getString());
				
				Doctor.executeUpdate();
				System.out.println("Doctor added!");
				
				
			} catch (SQLException e) {
				System.out.println("SQL Error: " + e.getMessage());
		        e.printStackTrace();
			}// end of try/catch
			
		    }// end of addDoctor
		
		
		// This should be correct just haven't tested it yet
		
		private static void addInteraction(Connection conn, Scanner scnr) {
			try {	
				PreparedStatement Interaction = conn.prepareStatement("INSERT INTO INTERACTIONRECORD (IID,idate,description,patientID" + "VALUES(?,?,?,?)");
				
				System.out.println("Insert IID\n");
				Interaction.setString(1, getString());
				
				System.out.println("Insert idate (YYYY-MM-DD)\n");
				Interaction.setDate(8, java.sql.Date.valueOf(getString()));
				
				System.out.println("Insert description\n");
				Interaction.setString(3, getString());
				
				System.out.println("Insert patientID");
				Interaction.setString(4, getString());
				
				Interaction.executeUpdate();
				System.out.println("Success");
				
				
				
			}catch (SQLException e) {
				System.out.println("SQL Error: " + e.getMessage());
		        e.printStackTrace();
			}// end of try/catch
			
		}// end of addInteraction
		
		
		/*
		 * In order to generate the record we first need to get the Patient Id
		 * 
		 */
		
		
		private static void generateRecord(Connection conn, Scanner scnr) {
			try {
				
				PreparedStatement generateRecord = conn.prepareStatement("");
				
				System.out.println("Please insert Patient Id");
				String Patient = getString();
				
				
				
				
			}catch(SQLException e) {
				
				System.out.println("No Patient Found! Please insert another Id");
				System.out.println("SQL Error: " + e.getMessage());
		        e.printStackTrace();
			}// end of try/catch
			
			
			
			
			
			
			
		}//end of generateRecord class
		
		/*
		 * Im not sure if this is right since i havent tested it yet i will Sunday when i get back
		 */
		private static void ProceduresByDepartment(Connection conn, Scanner scnr) {
			try{
				
				PreparedStatement procedureBydep = conn.prepareStatement("SELECT o.pname,o.pdescription,o.pduration " 
			    + "FROM OPERATION o JOIN DEPARTMENT d ON o.offerdep = d.dcode " +
			    "WHERE d.dcode = ? OR d.dname = ?");
				
				
				System.out.println("Please type Department name then code");
				procedureBydep.setString(1, getString());
				procedureBydep.setString(2, getString());
				
				procedureBydep.executeUpdate();
				
				ResultSet Procedure = procedureBydep.executeQuery();
				
				 while (Procedure.next()) {
					 
			            System.out.printf("Procedure: %s\n", Procedure.getString("pname"));
			            System.out.printf("Description: %s\n", Procedure.getString("pdescription")); 
			            System.out.printf("Duration: %d minutes\n", Procedure.getInt("pduration"));
				 }
				 
				 
			}catch(SQLException e){
				System.out.println("SQL Error: " + e.getMessage());
		        e.printStackTrace();
				
			}// end of try/catch
			
			
		}// end of ProceduresByDepartment
		
		
		
		/* IN order to run this method we first have to select name,description,duration
		 * Finished but has not been tested
		 * 
		 */
		private static void ProceduresByDoctor(Connection conn, Scanner scnr) {
			
			try {
				
				PreparedStatement procedureBydoc = conn.prepareStatement(
						"SELECT p.pnumber, p.pname, p.pdescription, u.datePerformed " +
			            "FROM UNDERGO u " +
			            "JOIN OPERATION p ON u.pnumber = p.pnumber " +
			            "WHERE u.doctorID = ?");
				
				
				System.out.println("Please enter a Doctor ID");
				procedureBydoc.setString(1,getString());
				
				
				ResultSet PBD = procedureBydoc.executeQuery();
				
				while(PBD.next()) {
					
					 System.out.printf("Date: %s\n", PBD.getDate("datePreformed"));
			         System.out.printf("Procedure: %s\n", PBD.getString("pname"));
			         System.out.printf("Description: %s\n", PBD.getString("pdescription"));
			         System.out.printf("Notes: %s\n", PBD.getString("notes"));
					
					
					
				}// end of while
				
				
			}catch(SQLException e){
				System.out.println("SQL Error: " + e.getMessage());
		        e.printStackTrace();
				
			}// end of try/catch
			
		}// end of procedureByDoctor
	

	public static String getString() {
		try {
		    StringBuffer buffer = new StringBuffer();
	        int c = System.in.read();
	        while (c != '\n' && c != -1) {
	    	  buffer.append((char)c);
	          c = System.in.read();
	          }
	        return buffer.toString().trim();
	        }
	        catch (IOException e){return "";}
	    }
	
	public static int getInt() 

	  {
	      String s= getString();
	      return Integer.parseInt(s);
	  }
	
	
}// end of class
