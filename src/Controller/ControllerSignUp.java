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
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

/**
 * Created by inf4my on 11/30/2016.
 */
public class ControllerSignUp {
    ArrayList<Customer> user;
    Customer temp;
    @FXML
    JFXTextField txtNamaDepan, txtNamaBelakang, txtEmail, txtNomorTelepon, txtNamaAkun;

    @FXML
    ComboBox<String> cboSex;

    @FXML
    JFXPasswordField txtPassword, txtPasswordUlang;

    public void operObjek(ArrayList<Customer> user){
        this.user = user;
        //System.out.println(this.user.get(0).getUsername());
    }

    @FXML
    public void handleBtnDaftar() throws EmptyPropertyException {
        if(txtNamaDepan.getText().isEmpty() || txtNamaBelakang.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNomorTelepon.getText().isEmpty()
                ||txtNamaAkun.getText().isEmpty() || txtPassword.getText().isEmpty()|| txtPasswordUlang.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan pada Kolom Input");
            alert.setHeaderText("Masalah pada input");
            alert.setContentText("Harap isi semua kolom isian");

            alert.showAndWait();
            return;
        }
        if(!txtEmail.getText().contains("@")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan pada Kolom Email");
            alert.setHeaderText("Masalah pada input");
            alert.setContentText("Email yang dimasukkan tidak memenuhi standar");

            alert.showAndWait();
            return;
        }
        if (!txtPassword.getText().toString().equals(txtPasswordUlang.getText().toString())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan pada password");
            alert.setHeaderText("Masalah pada input");
            alert.setContentText("Kata sandi yang dimasukkan tidak sama");

            alert.showAndWait();
            return;
        }
        if(!txtNomorTelepon.getText().matches("[0-9]+")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Keasalahan pada Kolom Nomor telepon");
            alert.setHeaderText("Masalah pada input");
            alert.setContentText("Nomor telepon mengandung selain angka");

            alert.showAndWait();
            return;
        }
        String sex;
        if (cboSex.getValue().toString().equals("Pria")){
            sex = "l";
        }
        else{
            sex = "p";
        }
        temp = new Customer(txtNamaDepan.getText(), txtNamaBelakang.getText(), txtEmail.getText(), sex , txtNomorTelepon.getText(),  txtNamaAkun.getText(), txtPassword.getText());
        //System.out.println(user.getSex());
        CustomerAL input = new CustomerAL();
        input.insertUser(temp.getfName(), temp.getlName(), temp.getEmail(), temp.getSex(), temp.getPhoneNumber(), temp.getUsername(), temp.getPassword());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Pendaftaran berhasil");

        alert.showAndWait();

    }


}
