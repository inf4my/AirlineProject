package DataLinkLayer;

import java.sql.Connection;

/**
 * Created by inf4my on 11/30/2016.
 */
public class CustomerAL {
    private static Connection connection;
    private static boolean connect(){
        connection = null;

        try{
            connection = ConnectionConfiguration.getConnection();
            if(connection != null){
                System.out.println("Connection Established");
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private static void closeConnection(){
        try{
            if(connection !=null) {
                connection.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertUser(String fName, String lName, String email, String phoneNumber, String userName, String password){

    }
}
