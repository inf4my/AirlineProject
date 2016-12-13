package Controller;

import BusinessLayer.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.ParentBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Exception.DateException;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerUtama {
    ArrayList<Customer> user = new ArrayList<Customer>();
    @FXML
    private JFXButton btnSearch, btnLogin, btnSignUp;

    @FXML
    private MenuButton btnSdhMsk;

    @FXML
    private JFXComboBox<java.lang.String> cboAsal, cboTujuan, cboKelasPenerbangan;

    @FXML
    private JFXDatePicker dtpPergi, dtpPulang;

    @FXML
    private LocalDate datepergi, datepulang;

    @FXML
    private JFXComboBox<java.lang.String> cboTiketDewasa, cboTiketAnak, cboTiketBayi;

    @FXML
    private ToggleGroup tgJenis;

    @FXML
    private JFXRadioButton rbPP, rbSekali;

    @FXML public void initialize(){
        datepergi = LocalDate.now();
        datepulang = LocalDate.now();
        dtpPergi.setValue(datepergi);
        dtpPulang.setDisable(false);
    }

    public void handleBtnKal(){
        if(rbSekali.isSelected()){
            dtpPulang.setDisable(true);
        }
    }

    public void handleBtnKalpp(){
        if(rbPP.isSelected()){
            dtpPulang.setDisable(false);
        }
    }

    @FXML
    public void handleBtnSearch(){
        try{
            if(dtpPulang.isDisable()==false && dtpPulang.getValue() == null || dtpPulang.isDisable()==false && cboTujuan.getValue() == null || dtpPulang.isDisable()==false && cboTujuan.getValue() == null && dtpPulang.getValue() == null || cboTujuan.getValue() == null){
                throw new DateException();
            }
            /*if(cboTujuan.getValue().equals("Tujuan")){
                throw new EmptyPropertyException();
            }
            if(cboTiketDewasa.getValue().equals("0")){
                throw new EmptyPropertyException();
            }*/
            //System.out.println(cboTujuan.getValue());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchFlight.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Searching Flight");
            entryStage.setScene(new Scene(entryForm, 1200,720));
            entryStage.show();
            entryStage.requestFocus();
            entryStage.getIcons().add(new Image(this.getClass().getResource("search.png").toString()));
            /*SignUpController signUpController = (SignUpController) loader.getController();
            signUpController.setLstOfUser(lstOfUser);
            */
        }
        catch (DateException e){
            e.periksaTanggal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleButtonSignUp() {
        try{
            //System.out.println(user.getUsername());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Pendaftaran");
            entryStage.setScene(new Scene(entryForm, 454,426));
            entryStage.show();
            entryStage.requestFocus();
            entryStage.getIcons().add(new Image(this.getClass().getResource("signup.png").toString()));
            ControllerSignUp controllerdaftrar = (ControllerSignUp) loader.getController();
            controllerdaftrar.operObjek(user);
            /*SignUpController signUpController = (SignUpController) loader.getController();
            signUpController.setLstOfUser(lstOfUser);
            */
            /*
            Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            stage.setTitle("Searching Flight");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBtnLogin(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("masuk.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Masuk");
            entryStage.setScene(new Scene(entryForm, 360,319));
            entryStage.show();
            entryStage.requestFocus();
            entryStage.getIcons().add(new Image(this.getClass().getResource("login.png").toString()));
            ControllerMasuk loginController = (ControllerMasuk) loader.getController();
            loginController.operObjek(user, btnLogin, btnSignUp, btnSdhMsk);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML void handlerDateException(){
        if(dtpPergi.getValue().isAfter(dtpPulang.getValue())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date");
            alert.setHeaderText("Date Error");
            alert.setContentText("Tanggal Berangkat Lebih besar dari tanggal pergi");
            alert.showAndWait();
            dtpPulang.setValue(LocalDate.now());
        }
    }

    @FXML void handleBtnKeluar(){
        btnSdhMsk.setVisible(false);
        btnLogin.setVisible(true);
        btnSignUp.setVisible(true);
        cboAsal.setValue("JAKARTA (JKT)");
        cboTujuan.setValue("Tujuan");
        cboTiketDewasa.setValue("1");
        cboTiketAnak.setValue("0");
        cboTiketBayi.setValue("0");
        dtpPergi.setValue(LocalDate.now());
        dtpPulang.setValue(null);
        dtpPulang.setPromptText("Tanggal Kepulangan");
        cboKelasPenerbangan.setValue("Ekonomi");
    }


}
