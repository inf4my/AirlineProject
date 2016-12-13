package BusinessLayer;

/**
 * Created by Naufal on 11/18/2016.
 *
 * Pleace BACA:
 * UPDATE 1
 * 1. baseharga dimatikan karena di parentnya dah ada harga.
 * 2. JenistPewawat dimatikan karena tidak ada di database.
 */
public class Tiket extends Penerbangan {
    //private int baseharga;

    public Tiket(){
        super();
    }

    public Tiket(String inKeberangkatan, String inTujuan, String inKodePenerbangan, String waktuBerangkat
    , String waktuPulang, int harga){
        super(inKeberangkatan, inTujuan, inKodePenerbangan, /*String inJenisPesawat,*/ waktuBerangkat, waktuPulang, harga);
    }


}
