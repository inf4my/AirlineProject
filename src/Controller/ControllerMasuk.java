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

/**
 * Created by lionery on 30/11/2016.
 */
public class ControllerMasuk {
    @FXML
    JFXButton btnBatal;

    @FXML
    JFXTextField txtUsername;

    @FXML
    JFXPasswordField txtPassword;

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
    private String firstName;

    public void set(String f){
        firstName = f;
    }

    public String get(){
        return firstName;
    }

    public void handleBtnMasuk() throws Exception{
        //udh bs
        //Customer customer = null;
        String usernameIn = txtUsername.getText();
        String pass = txtPassword.getText();
        String passwordIn = hash(pass);
        //System.out.println(passwordIn);
        //customer.login(usernameIn, passwordIn);
        CustomerAL check = new CustomerAL();
        check.getUser(usernameIn,passwordIn);
        //String a = get();
        //System.out.println(a); //masih belum bisa ngoper yang di select

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
