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
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private MessageDigest digest;

    public String getfName(){
        return fName;
    }

    public String getlName(){
        return lName;
    }

    public String getEmail(){
        return getEmail();
    }

    public String getPhoneNumber(){
        return getPhoneNumber();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

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

    public Customer(String fName, String lName, String email, String phoneNumber, String username, String password)throws EmptyPropertyException{
        if(fName.equals("")) throw new EmptyPropertyException("Firstname field is required");
        if(lName.equals(""))  throw new EmptyPropertyException("LastName field is required");
        if(email.equals(""))  throw new EmptyPropertyException("Email field is required");
        if(phoneNumber.equals(""))  throw new EmptyPropertyException("Phone Number field is required");
        if(username.equals("")) throw new EmptyPropertyException("Username field is required");
        if(password.equals("")) throw new EmptyPropertyException("Password field is required");

        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
