package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

/**
 * Created by lionery on 30/11/2016.
 */
public class ControllerMasuk {
    @FXML
    JFXButton btnBatal;

    @FXML
    public void handleBtnBatal(){
        btnBatal.getScene().getWindow().hide();
    }
}
