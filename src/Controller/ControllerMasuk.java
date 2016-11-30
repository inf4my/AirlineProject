package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    JFXTextField txtNamaakun;

    @FXML
    JFXPasswordField passAkun;

    public void handleBtnBatal(){
        btnBatal.getScene().getWindow().hide();
    }

    public void handleBtnMasuk(){
        String username = txtNamaakun.getText();
        String password = passAkun.getText();

    }

    @FXML
    public void handleBtnDaftar(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Pendaftaran");
            entryStage.setScene(new Scene(entryForm, 800,600));
            entryStage.show();
            entryStage.requestFocus();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
