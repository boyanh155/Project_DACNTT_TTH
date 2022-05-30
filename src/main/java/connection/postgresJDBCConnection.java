package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class postgresJDBCConnection {
    private static final String HOST = "ec2-3-209-65-193.compute-1.amazonaws.com";
    private static final String DB = "d1hhibnu5b35el";
    private static final int PORT = 5432;

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB;
    private static final String ID = "lqakffmnculcfp";
    private static final String PASS = "286663c6d0cf91e18e532880169b337f102084edd6f85b87e3f9ce71f4ad3305";

    public static Connection getJDBCConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
