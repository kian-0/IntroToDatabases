/* Example4.java
 * This sample shows how to update a tuple from VENDOR table using
 * prepared statement. Update uses some column values that are 
 * retrieved from the database.
 * It uses the JDBC THIN driver.
 */

// You need to import the java.sql package to use JDBC
import java.sql.*;
import java.io.*;
import java.text.*;

class Example4
{
  public static void main (String args [])
       throws SQLException
  {

      System.out.print("userid: ");
      String uid = getString();

      System.out.print("password: ");
      String pword = getString();

      String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";

    // Load the Oracle JDBC driver
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

    // Connect to the database
    Connection conn =
      DriverManager.getConnection (url, uid, pword);

    Statement stmt = conn.createStatement ();

    System.out.print("\nEnter existing vendor code: ");
    int v = getInt();

      // Select the V_NAME column from the VENDOR table

      String q = "SELECT * " +
               "FROM VENDOR " +
               "WHERE V_CODE= " + v ;
	  
     
     ResultSet rset = stmt.executeQuery(q);

     if (rset.next ()) {
       String vname = rset.getString("V_NAME");
       String vcontact = rset.getString("V_CONTACT");
       int vareacode = rset.getInt("V_AREACODE");
       String vphone = rset.getString("V_PHONE");       
       String vstate = rset.getString("V_STATE");       
       

       System.out.println("\nVendor name is: " + vname);
       System.out.println("Vendor contact is: " + vcontact);
       System.out.println("Vendor phone is: (" + vareacode + ")" + vphone);
       System.out.println("Vendor state is: " + vstate);
     } //if

     stmt.close();

     System.out.print("\nEnter new vendor contact: ");
     String newvcontact = getString();

     System.out.print("Enter new area code: ");
     int newvareacode = getInt();

     System.out.print("Enter new phone: ");
     String newvphone = getString();

     System.out.print("Enter new state: ");
     String newvstate = getString();

     PreparedStatement pstmt;

     String pinst = "UPDATE VENDOR "
     				 + "SET V_CONTACT= ?, "
     				 + "V_AREACODE= ?, "
     				 + "V_PHONE= ?, "
     				 + "V_STATE= ? "
     				 +"WHERE V_CODE= ? ";
		 
     pstmt = conn.prepareStatement(pinst);

     pstmt.setString(1, newvcontact);
     pstmt.setInt(2, newvareacode);
     pstmt.setString(3, newvphone);
     pstmt.setString(4, newvstate);
     pstmt.setInt(5, v);     

     int NumRows = pstmt.executeUpdate();
     System.out.println(NumRows + " row updated");

	 Statement nstmt = conn.createStatement ();
	 ResultSet nset = nstmt.executeQuery(q);
	 nset.next ();
	 
       String vname = nset.getString("V_NAME");
       String vcontact = nset.getString("V_CONTACT");
       int vareacode = nset.getInt("V_AREACODE");
       String vphone = nset.getString("V_PHONE");       
       String vstate = nset.getString("V_STATE");       
       

       System.out.println("\nVendor name is: " + vname);
       System.out.println("Vendor contact is: " + vcontact);
       System.out.println("Vendor phone is: (" + vareacode + ")" + vphone);
       System.out.println("Vendor state is: " + vstate);
      
       nstmt.close();
       conn.close();

  } // main

 public static String getStr() {
	try {
	    StringBuffer buffer = new StringBuffer();
            System.out.flush();
	    int c = System.in.read();
	    while (c != '\n' && c != -1) {
		  buffer.append((char)c);
		  c = System.in.read();
	    }
	    return buffer.toString().trim();
	}
	catch (IOException e){return "";}
    }

public static String getString() 
      {

      try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
      } // try
      catch (IOException e) {return "";}
      } //getString

  public static int getInt() 

  {
      String s= getString();
      return Integer.parseInt(s);
  }

} // Example4












