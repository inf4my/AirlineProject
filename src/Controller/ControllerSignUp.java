package Controller;

import DataLinkLayer.CustomerAL;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import BusinessLayer.Customer;
import Exception.EmptyPropertyException;
import DataLinkLayer.ConnectionConfiguration;
import javafx.scene.control.Alert;

/**
 * Created by inf4my on 11/30/2016.
 */
public class ControllerSignUp {
    Customer user;
    @FXML
    JFXTextField txtNamaDepan, txtNamaBelakang, txtEmail, txtNomorTelepon, txtNamaAkun;

    @FXML
    JFXPasswordField txtPassword, txtPasswordUlang;

    @FXML
    public void handleBtnDaftar() throws EmptyPropertyException {
        if (!txtPassword.getText().toString().equals(txtPasswordUlang.getText().toString())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan pada password");
            alert.setHeaderText("Masalah pada input");
            alert.setContentText("Kata sandi yang dimasukkan tidak sama");

            alert.showAndWait();
            return;
        }
        user = new Customer(txtNamaDepan.getText(), txtNamaBelakang.getText(), txtEmail.getText(), txtNomorTelepon.getText(),  txtNamaAkun.getText(), txtPassword.getText());
        CustomerAL input = new CustomerAL();
        input.insertUser(user.getfName(), user.getlName(), user.getEmail(), user.getPhoneNumber(), user.getUsername(), user.getPassword());

    }
}
