/*  Example3.java
 * This sample shows how to insert a tuple to VENDOR table using
 * prepared statement. Insert uses column values entered by the user.
 *
 * It uses the JDBC THIN driver.
 */

// You need to import the java.sql package to use JDBC
import java.sql.*;
import java.io.*;  

class Example3
{
  public static void main (String args [])
       throws SQLException
  {

      System.out.print("userid: ");
      String uid;
      uid = getString();

      System.out.print("password: ");
      String pword;
      pword = getString();

    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    // Load the Oracle JDBC driver
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

    // Connect to the database
    Connection conn =
      DriverManager.getConnection (url, uid, pword);

    // Prepare to insert new vendors into the VENDOR table
    PreparedStatement pstmt =
      conn.prepareStatement ("INSERT INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREACODE, V_PHONE, V_STATE, V_ORDER) " +
      "VALUES (?, ?, ?, ?, ?, ?, ?)");

    int done = 1;

    while (done != 0) {
      System.out.println("\nEnter vendor code: ");
      int vcode = getInt();
      System.out.println("\nEnter vendor name: ");
      String vname = getString();
      System.out.println("\nEnter vendor contact person: ");
      String vcontact = getString();
      System.out.println("\nEnter area code: ");
      int vareacode = getInt();
      System.out.println("\nEnter phone number: ");
      String vphone = getString();
      System.out.println("\nEnter state code: ");
      String vstate = getString();
      System.out.println("\nEnter vendor status (Y/N): ");
      String vorder = getString();


      pstmt.setInt(1, vcode);
      pstmt.setString(2, vname);
      pstmt.setString(3, vcontact);
      pstmt.setInt(4, vareacode);
      pstmt.setString(5, vphone);
      pstmt.setString(6, vstate);
      pstmt.setString(7, vorder);      
      int NumRows = pstmt.executeUpdate();
      System.out.println("\n" + NumRows + " row(s) inserted");

      System.out.println("\nHit 0 for exit, " +
	     "or enter any other number for another insert: ");
      done = getInt();
      } // while done
    conn.close();

  } // main

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



} // Example3












