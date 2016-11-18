package BusinessLayer;

/**
 * Created by Naufal on 11/18/2016.
 */
public abstract class Penumpang {
    private String title;
    private String fName;
    private String lName;
    private String nomorTelepon;
    private String email;

    public Penumpang(){
        title = "";
        fName = "";
        lName = "";
        nomorTelepon = "";
        email = "";
    }

    public Penumpang(String inTitle, String inFName, String inLName, String inNomorTelp, String inEmail){
        this.title = inTitle;
        this.fName = inFName;
        this.lName = inLName;
        this.nomorTelepon = inNomorTelp;
        this.email = inEmail;
    }

    public String getTitle(){
        return title;
    }

    public String getfName(){
        return fName;
    }

    public String getlName(){
        return lName;
    }

    public String getNomorTelepon(){
        return nomorTelepon;
    }

    public String getEmail(){
        return email;
    }
}
