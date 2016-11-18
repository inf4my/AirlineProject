package BusinessLayer;

/**
 * Created by Naufal on 11/18/2016.
 */
public abstract class Penerbangan {
    private String keberangkatan;
    private String tujuan;
    private String kodePenerbangan;
    private String jenisPesawat;

    public Penerbangan(){
        keberangkatan = "";
        tujuan  = "";
        kodePenerbangan = "";
        jenisPesawat = "";
    }

    public Penerbangan(String inKeberangkatan, String inTujuan, String inKodePenerbangan, String inJenisPesawat){
        this.keberangkatan = inKeberangkatan;
        this.tujuan = inTujuan;
        this.kodePenerbangan = inKodePenerbangan;
        this.jenisPesawat = inJenisPesawat;
    }
}
