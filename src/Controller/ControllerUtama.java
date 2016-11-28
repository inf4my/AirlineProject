package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import Exception.EmptyPropertyException;

public class ControllerUtama {

    @FXML
    private JFXButton btnSearch, btnLogin, btnSignUp;

    @FXML
    private JFXComboBox<java.lang.String> cboAsal, cboTujuan, cboKelasPenerbangan;

    @FXML
    private JFXDatePicker dtpPergi, dtpPulang;

    @FXML
    private JFXComboBox<java.lang.String> cboTiketDewasa, cboTiketAnak, cboTiketBayi;

    @FXML
    private ToggleGroup jenisTiket;

    @FXML
    public void handleBtnSearch() throws EmptyPropertyException{
        try{
            if(dtpPergi.getValue() == null || dtpPulang.getValue() == null){
                throw new EmptyPropertyException();
            }
            if(cboTujuan.getValue().equals("Tujuan")){
                throw new EmptyPropertyException();
            }
            if(cboTiketDewasa.getValue().equals("0")){
                throw new EmptyPropertyException();
            }
            //System.out.println(cboTujuan.getValue());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchFlight.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Searching Flight");
            entryStage.setScene(new Scene(entryForm, 800,600));
            entryStage.show();
            entryStage.requestFocus();
            /*SignUpController signUpController = (SignUpController) loader.getController();
            signUpController.setLstOfUser(lstOfUser);
            */
        }
        catch (EmptyPropertyException e){
            e.periksaSemua();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleButtonSignUp(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Searching Flight");
            entryStage.setScene(new Scene(entryForm, 800,600));
            entryStage.show();
            entryStage.requestFocus();
            /*SignUpController signUpController = (SignUpController) loader.getController();
            signUpController.setLstOfUser(lstOfUser);
            */
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
