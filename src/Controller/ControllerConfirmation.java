package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Taksu on 12/14/2016.
 */
public class ControllerConfirmation {
    @FXML
    TextField txtKodePenerbangan, txtBerangkat, txtTujuan, txtWaktuBerangkat, txtWaktuSampai, txtKelas, txtTotalBiaya;
    @FXML
    TextField txtKodePenerbangan1, txtBerangkat1, txtTujuan1, txtWaktuBerangkat1, txtWaktuSampai1, txtKelas1, txtTotalBiaya1;

    public void initialize(String kode, String berangkat, String tujuan, String waktuBerangkat, String waktuSampai, String kelas, String totalBiaya){
        txtKodePenerbangan.setText(kode);
        txtBerangkat.setText(berangkat);
        txtTujuan.setText(tujuan);
        txtWaktuBerangkat.setText(waktuBerangkat);
        txtWaktuSampai.setText(waktuSampai);
        txtKelas.setText(kelas);
        txtTotalBiaya.setText(totalBiaya);
    }

    public void initialize(String kode, String berangkat, String tujuan, String waktuBerangkat, String waktuSampai, String kelas, String totalBiaya, String kodePenerbangan2
    , String berangkat2, String tujuan2, String waktuBerangkat2, String waktuSampai2, String totalBiaya2){
        txtKodePenerbangan.setText(kode);
        txtBerangkat.setText(berangkat);
        txtTujuan.setText(tujuan);
        txtWaktuBerangkat.setText(waktuBerangkat);
        txtWaktuSampai.setText(waktuSampai);
        txtKelas.setText(kelas);
        txtTotalBiaya.setText(totalBiaya);

        txtKodePenerbangan1.setText(kodePenerbangan2);
        txtBerangkat1.setText(berangkat2);
        txtTujuan1.setText(tujuan2);
        txtWaktuBerangkat1.setText(waktuBerangkat2);
        txtWaktuSampai1.setText(waktuSampai2);
        txtTotalBiaya.setText(totalBiaya2);
    }
    @FXML
    public void handleBtnConfirm(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("metodeBayar.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Searching Flight");
            entryStage.setScene(new Scene(entryForm, 1200,720));
            entryStage.show();
            entryStage.requestFocus();
            entryStage.getIcons().add(new Image(this.getClass().getResource("search.png").toString()));
            MetodeBayarController z = (MetodeBayarController) loader.getController();

        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
