/*  Example5.java
 * This sample shows how to insert a tuple to PRODUCT table using
 * prepared statement. Insert uses column values entered by the user.
 *
 * It uses the JDBC THIN driver.
 */

// You need to import the java.sql package to use JDBC
import java.sql.*;
import java.io.*;  

class Example5
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

    // Prepare to insert new products in the PRODUCT table
    PreparedStatement pstmt =
      conn.prepareStatement ("INSERT INTO PRODUCT(P_CODE, P_DESCRIPT, P_INDATE, P_ONHAND, P_MIN, P_PRICE, P_DISCOUNT, V_CODE) " +
      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

    int done = 1;

    while (done != 0) {
      System.out.println("\nEnter product code: ");
      String pcode = getString();
      System.out.println("\nEnter product description: ");
      String pdescript = getString();

      System.out.println("\nEnter product in-date (yyyy-mm-dd): ");
      String tmppindate = getString();   //the date is read as a String object in the specified format
      Date pindate=Date.valueOf(tmppindate); // this converts the String object into a Date object
      
      System.out.println("\nEnter quantity on hand: ");
      int ponhand = getInt();
      System.out.println("\nEnter minimum stock allowed: ");
      int pmin = getInt();
      System.out.println("\nEnter product sale price: ");
      float pprice = getFloat();
      System.out.println("\nEnter product discount (must be less than 1.0): "); //Must be a fraction ( <1.0 )
      float pdiscount = getFloat();
      System.out.println("\nEnter vendor code: ");
      int vcode = getInt();


      pstmt.setString(1, pcode);
      pstmt.setString(2, pdescript);
      pstmt.setDate(3, pindate);
      pstmt.setInt(4, ponhand);
      pstmt.setInt(5, pmin);
      pstmt.setFloat(6, pprice);
      pstmt.setFloat(7, pdiscount);      
      pstmt.setInt(8, vcode);  


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

  public static float getFloat() 

  {
      String s= getString();
      return Float.parseFloat(s);
  }
} // Example5













