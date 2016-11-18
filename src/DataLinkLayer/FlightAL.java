package DataLinkLayer;

import BusinessLayer.Penerbangan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naufal on 11/18/2016.
 */
public class FlightAL {
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

    /*public static List<Penerbangan> getAllEmployee(){
        List<Penerbangan> employees = new ArrayList<Penerbangan>();
        if(connect()){
            String query = "SELECT id, first_name, last_name, pos, email FROM employees;";
            PreparedStatement stmt = null;
            try{
                stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    Penerbangan employee = null;

                    int id = rs.getInt("id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String position = rs.getString("pos");
                    String email = rs.getString("email");

                    switch(position.toLowerCase()){
                        case "manager":
                            employee = new Manager(id, firstName, lastName, position, email);
                            break;
                        case "staff":
                            employee = new Staff(id,firstName, lastName, position,email);
                            break;
                    }
                    if(employee != null){
                        employees.add(employee);
                    }
                }
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
        return employees;
    }*/
}
