package DataLinkLayer;

import BusinessLayer.Penerbangan;
import BusinessLayer.Tiket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naufal on 11/18/2016.
 *
 * PLEACE BACA:
 * UPDATE 1:
 * 1. FlightAL sudah berfungsi untuk memanggil data yang ada di table penerbangan.
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

    public static List<Penerbangan> getAllPenerbangan(){
        List<Penerbangan> penerbangan = new ArrayList<Penerbangan>();
        if(connect()){
            String query = "SELECT kodePenerbangan, keberangkatan, tujuan, waktuBerangkat, waktuPulang, harga FROM penerbangan;";
            PreparedStatement stmt = null;
            try{
                stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    Penerbangan penerbanganAmbil = null;

                    String kodePenerbangan = rs.getString("kodePenerbangan");
                    String keberangkatan = rs.getString("keberangkatan");
                    String tujuan = rs.getString("tujuan");

                    String waktuBerangkat = rs.getString("waktuBerangkat");
                    String waktuPulang = rs.getString("waktuPulang");
                    int harga = rs.getInt("harga");

                    /*switch(position.toLowerCase()){
                        case "manager":
                            employee = new Manager(id, firstName, lastName, position, email);
                            break;
                        case "staff":
                            employee = new Staff(id,firstName, lastName, position,email);
                            break;
                    }*/
                    penerbanganAmbil = new Tiket(keberangkatan, tujuan, kodePenerbangan, waktuBerangkat, waktuPulang, harga);
                    if(penerbangan != null){
                        penerbangan.add(penerbanganAmbil);
                    }
                }
            }
            catch (Exception e){
                System.out.println("CHECK!");
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
        System.out.println(penerbangan.size());
        return penerbangan;
    }
}
