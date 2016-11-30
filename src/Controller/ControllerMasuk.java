package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

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


    }
