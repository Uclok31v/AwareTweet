package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class H2Driver {

    private String driver = "org.h2.Driver";
    private String protocol = "jdbc:h2:";

    public static void main(String[] args) {
        new H2Driver().go();
        System.out.println("SimpleApp finished");
    }

    void go() {
        loadDriver();

        Properties props = new Properties();
        props.put("user", "sa");

        Connection conn = null;

        PreparedStatement psInsert = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            String dbName = "~/awaretweet";
            conn = DriverManager.getConnection(protocol + dbName, props);
            conn.setAutoCommit(false);

            s = conn.createStatement();
            s.execute("create table location(num int, addr varchar(40))");

            psInsert = conn.prepareStatement("insert into location values (?, ?)");
            psInsert.setInt(1, 1956);
            psInsert.setString(2, "Webster St.");
            psInsert.executeUpdate();

            rs = s.executeQuery("SELECT num, addr FROM location ORDER BY num");
            while(rs.next()) {
                System.out.println("num="+rs.getInt("num") + " addr=" + rs.getString("addr"));
            }
            s.execute("drop table location");
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
                if (psInsert != null) {
                    psInsert.close();
                    psInsert = null;
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
