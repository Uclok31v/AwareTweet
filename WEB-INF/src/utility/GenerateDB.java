package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import utility.PasswordEncryption;

public class GenerateDB {

    private String driver = "org.h2.Driver";
    private String protocol = "jdbc:h2:";

    public void generateDB(){
    	loadDriver();

        Properties props = new Properties();
        props.put("user", "sa");

        Connection conn = null;

        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String dbName = "~/awaretweet";
            conn = DriverManager.getConnection(protocol + dbName, props);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();

            stmt.execute("create table  if not exists profile("
            		+ "id varchar(16) PRIMARY KEY NOT NULL,"
            		+ "name varchar(64) NOT NULL,"
            		+ "password text NOT NULL)");

            stmt.execute("create table  if not exists ip_history("
            		+ "ip varchar(40) PRIMARY KEY NOT NULL,"
            		+ "fail_count int(11) NOT NULL DEFAULT 0)");

            stmt.execute("create table  if not exists tweet("
            		+ "date varchar(40) AS CURRENT_TIMESTAMP,"
            		+ "commenter varchar(64) NOT NULL,"
            		+ "comment text NOT NULL,"
            		+ "avator_path varchar(255) DEFAULT NULL)");


            pstmt = conn.prepareStatement("insert into profile values (?,?,?)");
            pstmt.setString(1, "root");
            pstmt.setString(2, "root");
            PasswordEncryption passenc = new PasswordEncryption();
    		String password = passenc.getPassword_encryption("root");
    		pstmt.setString(3, password);

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException sqle) {
            printSQLException(sqle);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }

            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }

            // Connection
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
    }


    private void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println("\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println("\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }

    public static void printSQLException(SQLException e) {
        while (e != null) {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            e = e.getNextException();
        }
    }
}
