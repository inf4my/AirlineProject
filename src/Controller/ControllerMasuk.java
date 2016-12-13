package Controller;

import BusinessLayer.Customer;
import DataLinkLayer.CustomerAL;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by lionery on 30/11/2016.
 */
public class ControllerMasuk {
    ArrayList<Customer> user;
    Customer temp;
    private String firstName;
    @FXML
    JFXButton btnBatal, btnMasuk;

    @FXML
    JFXTextField txtUsername;

    @FXML
    JFXPasswordField txtPassword;


    public void operObjek(ArrayList<Customer> user){
        this.user = user;
    }

    public void handleBtnBatal(){
        btnBatal.getScene().getWindow().hide();
    }

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

    public void set(String f){
        this.firstName = f;
        //System.out.println(firstName);
    }

    public String getFirstName(){
        return firstName;
    }

    public void handleBtnMasuk() throws Exception{
        String usernameIn = txtUsername.getText();
        String pass = txtPassword.getText();
        String passwordIn = hash(pass);
        //System.out.println(passwordIn);
        CustomerAL check = new CustomerAL();
        temp = check.getUser(usernameIn,passwordIn);
        user.add(temp);
        btnMasuk.getScene().getWindow().hide();

    }

    @FXML
    public void handleBtnDaftar(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Pendaftaran");
            entryStage.setScene(new Scene(entryForm,489,357));
            entryStage.show();
            entryStage.requestFocus();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
