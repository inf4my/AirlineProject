package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import BusinessLayer.Customer;
import Exception.EmptyPropertyException;
import DataLinkLayer.ConnectionConfiguration;

/**
 * Created by inf4my on 11/30/2016.
 */
public class ControllerSignUp {
    Customer user;
    @FXML
    JFXTextField txtNamaLengkap, txtNamaAkun;

    @FXML
    JFXPasswordField txtPassword, txtPasswordUlang;

    /*@FXML
    public void handleBtnDaftar() throws EmptyPropertyException {
        user = new Customer(txtNamaLengkap.getText(), txtNamaAkun.getText(), txtPassword.getText());

    }*/
}
