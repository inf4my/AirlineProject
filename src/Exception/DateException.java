package Exception;

import javafx.scene.control.Alert;

/**
 * Created by inf4my on 11/30/2016.
 */
public class DateException extends Exception {
    public DateException(){
        super("Cek kembali tanggal yang dimasukkan");
    }
    public DateException(String msg){
        super(msg);
    }

    public void periksaTanggal(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kesalahan pada tanggal");
        alert.setHeaderText("Masalah pada input");
        alert.setContentText("Periksa kembali tanggal yang dimasukkan");

        alert.showAndWait();
    }
}
