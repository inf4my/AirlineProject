package Exception;

import javafx.scene.control.Alert;

/**
 * Created by GDC on 11/24/16.
 */
public class EmptyPropertyException extends Exception{
    private String pesan;
    public EmptyPropertyException(){
        super("All fields are required");
    }
    public EmptyPropertyException(String message){
        super(message);
        this.pesan = message;
    }

    public void errorInput(){

    }
}
