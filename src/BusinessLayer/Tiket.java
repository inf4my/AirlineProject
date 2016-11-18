package BusinessLayer;

/**
 * Created by Naufal on 11/18/2016.
 */
public class Tiket extends Penerbangan {
    private int baseharga;

    public Tiket(){
        super();
    }

    public Tiket(String inKeberangkatan, String inTujuan, String inKodePenerbangan, String inJenisPesawat){
        super(inKeberangkatan, inTujuan, inKodePenerbangan, inJenisPesawat);
    }
}
