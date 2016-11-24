package BusinessLayer;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Created by GDC on 11/24/16.
 */
public class Customer {
    private String id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private MessageDigest digest;

    private String hash(String strToHash){
        try{
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(hash);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public Customer(String fname, String lname, String id, String username, String password){
        if(fname.equals("")){

        }
    }
}
