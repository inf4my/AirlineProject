package DataLinkLayer;

import BusinessLayer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            //System.out.println(query);
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

    //Get User for Login
    public void getUser(String usernameIn, String passwordIn){
        if(connect()){
            String query = "SELECT firstName, lastName, email, phoneNumber, username, password FROM customer WHERE username="+usernameIn+" AND password="+passwordIn+";";
            System.out.println(query);
            PreparedStatement statement = null;


            try{
                statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    Customer customer = null;

                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");

                }
            }
            catch (Exception e){
                System.out.println("ga bisa");
                e.printStackTrace();
            }
            finally {
                try{
                    if(statement != null){
                        statement.close();
                    }
                    closeConnection();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return;
    }
}
