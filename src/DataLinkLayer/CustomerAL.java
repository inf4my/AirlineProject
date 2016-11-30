package DataLinkLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        if(connect()){
            String query = "INSERT INTO customer(firstName, lastName, email, phoneNumber, username, password) VALUES('"+fName+"', '"+lName+"', '"+email+"', '"+phoneNumber+"', '"+userName+"', '"+password+"');";
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement(query);
                stmt.execute(query);
                System.out.println(query);
                System.out.println("query jalan");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try{
                    if(stmt != null){
                        stmt.close();
                    }
                    closeConnection();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
