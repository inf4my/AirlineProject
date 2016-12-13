package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * Created by aldofebrian on 13/12/2016.
 */
public class MetodeBayarController {
    public void handleBtnBca(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");

        alert.setGraphic(new ImageView(this.getClass().getResource("bca.png").toString()));
    }

    public void handleBtnKlik(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");
        alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
    }

    public void handleBtnMandiri(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");
        alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
    }

    public void handleBtnMaybank(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");
        alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
    }

    public void handleBtnCimb(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");
        alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
    }

    public void handleBtnVisa(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Silahkan lakukan pembayaran di bank yang anda pilih");
        alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
    }
}
