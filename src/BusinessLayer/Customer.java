package BusinessLayer;

import javafx.scene.control.Alert;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import Exception.*;
/**
 * Created by GDC on 11/24/16.
 */
public class Customer{
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

    public Customer(String fname, String lname, String username, String password)throws EmptyPropertyException{
        if(fname.equals("")) throw new EmptyPropertyException("Firstname field is required");
        if(lname.equals("")) throw new EmptyPropertyException("Lastname field is required");
        if(username.equals("")) throw new EmptyPropertyException("Username field is required");
        if(password.equals("")) throw new EmptyPropertyException("Password field is required");

        this.fname=fname;
        this.lname=lname;
        this.username=username;
        this.password=hash(password);
    }

    public boolean login(String username, String password) throws AuthenticationException{
        if(this.username.equals(username)){
            if(this.password.equals(hash(password))){
                return true;
            }
            throw new AuthenticationException("Incorrect username / password");
        }
        return false;
    }
}
