import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class P1 {
    public static void main(String args[])
            throws SQLException {

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
                DriverManager.getConnection(url, uid, pword);


        Scanner scnr = new Scanner(System.in);

        int operating = 1;

        while (operating != 0) {
            System.out.println("\n*** Hospital Management System ***");
            System.out.println("Please Choose an option!");
            System.out.println("1. Add a Patient");
            System.out.println("2. Add a Department");
            System.out.println("3. Add a Procedure");
            System.out.println("4. Add a Doctor");
            System.out.println("5. Add an Interaction Record");
            System.out.println("6. Generate Health Record for a Patient");
            System.out.println("7. Find Procedures by Department");
            System.out.println("8. List Procedures Done by a Doctor");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int option = scnr.nextInt();
            scnr.nextLine();
            switch (option) {

                case 1:
                    addPatient(conn, scnr);
                    break;
                case 2:
                    addDepartment(conn, scnr);
                    break;
                case 3:
                    addProcedure(conn, scnr);
                    break;
                case 4:
                    addDoctor(conn, scnr);
                    break;
                case 5:
                    addInteraction(conn, scnr);
                    break;
                case 6:
                    generateRecord(conn, scnr);
                    break;
                case 7:
                    ProceduresByDepartment(conn, scnr);
                    break;
                case 8:
                    ProceduresByDoctor(conn, scnr);
                    break;
                case 9:
                    operating = 0;
                    break;
                default:
                    System.out.println("Not an option please try again.");
                    break;

            }


        }

        System.out.println("Database closing! Bye!");


        //Inserting Tuples

        //  PreparedStatement Department = conn.prepareStatement("INSERT INTO DEPARTMENT(Dname,Dcode,officeNumber,officePhone,dHead)" + "VALUES(?,?,?,?,?)");
        //  PreparedStatement Patient = conn.prepareStatement ("INSERT INTO PATIENT(Fname,Minit,Lname,PatientId,SSN,Sex,Bdate,PhoneNumber,Condition,City,State,Zip)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        //PreparedStatement Doctor = conn.prepareStatement("INSERT INTO DOCTOR");


        conn.close();
        scnr.close();
        // end of main
    }


    // adds patient to database
    private static void addPatient(Connection conn, Scanner scnr) {
        try {
            PreparedStatement Patient = conn.prepareStatement("INSERT INTO PATIENT(PID,ssn,fname,minitial,lname,sex,birthdate,condit,curraddress,currphone,permaddress,permcity,permstate,permzipp,permphone,doctorID)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            System.out.println("Insert PID\n");
            Patient.setString(1, getString());
            System.out.println("Insert ssn\n");
            Patient.setInt(2, getInt());
            System.out.println("Insert fname\n");
            Patient.setString(3, getString());
            System.out.println("Insert mininitial\n");
            Patient.setString(4, getString());
            System.out.println("Insert lname\n");
            Patient.setString(5, getString());
            System.out.println("Insert sex\n");
            Patient.setString(6, getString());
            System.out.println("Insert birthdate\n");
            Patient.setString(7, getString());
            System.out.println("Insert condit\n");
            Patient.setString(8, getString());
            System.out.println("Insert curraddress\n");
            Patient.setString(9, getString());
            System.out.println("Insert currphone\n");
            Patient.setInt(10, getInt());
            System.out.println("Insert permaddress");
            Patient.setString(11, getString());
            System.out.println("Insert permcity");
            Patient.setString(12, getString());
            System.out.println("Insert permstate");
            Patient.setString(13, getString());
            System.out.println("Insert permzipp");
            Patient.setInt(14, getInt());
            System.out.println("Inser permphone");
            Patient.setInt(15, getInt());
            System.out.println("Insert DoctorId");
            Patient.setString(16, getString());


            Patient.executeUpdate();
            System.out.println("Patient Added!");


        } catch (SQLException e) {
            System.out.println("Error please try a different patient!");
        }// end of try/catch


    }//end of addPatient

    private static void addDepartment(Connection conn, Scanner scnr) {
        PreparedStatement Department = conn.prepareStatement("INSERT INTO DEPARTMENT(");


    }


    private static void addProcedure(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }

    private static void addDoctor(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }

    private static void addInteraction(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }

    private static void generateRecord(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }

    private static void ProceduresByDepartment(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }

    private static void ProceduresByDoctor(Connection conn, Scanner scnr) {
        // TODO Auto-generated method stub

    }


    public static String getString() {
        try {
            StringBuffer buffer = new StringBuffer();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }

    public static int getInt() {
        String s = getString();
        return Integer.parseInt(s);
    }


}// end of class


//Extras
//String departmentD = "INSERT INTO DEPARTMENT(Dname,Dcode,officeNumber,officePhone,dHead)" + "VALUES(?,?,?,?,?)";
