package Exception;

import javafx.scene.control.Alert;

/**
 * Created by GDC on 11/24/16.
 */
public class EmptyPropertyException extends Exception{
    public EmptyPropertyException(){
        super("All fields are required");
    }
    public EmptyPropertyException(String message){
        super(message);
    }

    public void periksaSemua(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error pada input");
        alert.setHeaderText("Masalah pada input");
        alert.setContentText("Periksa kembali tujuan, tanggal, dan tiket dewasa ");

        alert.showAndWait();
    }
}
