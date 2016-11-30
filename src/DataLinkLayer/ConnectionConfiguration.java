package DataLinkLayer;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Naufal on 11/18/2016.
 */
public class ConnectionConfiguration {
    private static final String connectionString = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, username, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
