package Exception;

/**
 * Created by GDC on 11/24/16.
 */
public class AuthenticationException extends Exception{
    public AuthenticationException(){
        super();
    }
    public AuthenticationException(String message){
        super(message);
    }
}
