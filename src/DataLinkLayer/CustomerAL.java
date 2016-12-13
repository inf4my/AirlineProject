package DataLinkLayer;

import BusinessLayer.Customer;
import Controller.ControllerMasuk;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by inf4my on 11/30/2016.
 */
public class CustomerAL {
    Customer user;
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

    public void insertUser(String fName, String lName, String email, String sex, String phoneNumber, String userName, String password){
        if(connect()){
            String query = "INSERT INTO customer(firstName, lastName, email, jenisKelamin, phoneNumber, username, password) VALUES('"+fName+"', '"+lName+"', '"+email+"','"+sex+"', '"+phoneNumber+"', '"+userName+"', '"+password+"');";
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
    public Customer getUser(String usernameIn, String passwordIn){
        if(connect()){
           // String firstName = null;
            boolean isAvailable = false;
            String q = "SELECT firstName, lastName, jenisKelamin, email, phoneNumber, username, password FROM customer WHERE username='"+usernameIn+"' AND password='"+passwordIn+"';";
            System.out.println(q);
            PreparedStatement statement = null;

            try{
                statement = connection.prepareStatement(q);
                ResultSet resultSet = statement.executeQuery();

                if(resultSet.absolute(1)){
                    isAvailable = true;
                }else{
                    isAvailable = false;
                }

                System.out.println(isAvailable);

                if(isAvailable == false){
                    throw new Exception();
                }

                else{
                    System.out.println("Data ada");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String jenisKelamin = resultSet.getString("jenisKelamin");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println(firstName + " " +lastName);
                    user = new Customer(firstName, lastName, jenisKelamin, email, phoneNumber, username, password);


                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login Berhasil");
                    alert.setHeaderText("Hallo, "+firstName +" " +lastName);
                    alert.setContentText("Silahkan bertransaksi");
                    alert.showAndWait();
                    //ControllerMasuk controllerMasuk = new ControllerMasuk();
                   // controllerMasuk.benerGa('y');
                    user.setStatus('y');
                }
            }
            catch (Exception e){
                System.out.println("Data tidak ada");
                //e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Username/Password");
                alert.setHeaderText("Username/Password Anda Salah");
                alert.setContentText("Silahkan periksa kembali input Anda");
                alert.showAndWait();
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
       // return;
        return user;
    }


}
