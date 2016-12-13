package BusinessLayer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Naufal on 11/18/2016.
 *
 *
 * PLEASE BACA:
 * UPDATE 1
 * 1. Modifier untuk para variabel aku ganti menjadi Proctected, agar childnya (yaitu Tiket) bisa menggunakannya,
 * 2. Aku tambahkan waktuBerangkant, waktuPulang dan harga.
 * 3. jenisPesawat BELUM digunakan karena di database gk ada.
 *
 */
public abstract class Penerbangan {
    protected String keberangkatan;
    protected String tujuan;
    protected String kodePenerbangan;
    protected String jenisPesawat;
    protected LocalDateTime waktuBerangkat;
    protected LocalDateTime waktuPulang;
    protected int harga;

    public Penerbangan(){
        setKeberangkatan("");
        setTujuan("");
        setKodePenerbangan("");
        setJenisPesawat("");
    }

    public Penerbangan(String inKeberangkatan, String inTujuan, String inKodePenerbangan, /*String inJenisPesawat,*/
                       String waktuBerangkat, String waktuPulang, int harga){
        this.setKeberangkatan(inKeberangkatan);
        this.setTujuan(inTujuan);
        this.setKodePenerbangan(inKodePenerbangan);
        //this.setJenisPesawat(inJenisPesawat);
        this.setWaktuBerangkat(LocalDateTime.parse(waktuBerangkat, DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        this.setWaktuPulang(LocalDateTime.parse(waktuPulang, DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        this.setHarga(harga);
    }

    public String getKeberangkatan() {
        return keberangkatan;
    }

    public void setKeberangkatan(String keberangkatan) {
        this.keberangkatan = keberangkatan;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getKodePenerbangan() {
        return kodePenerbangan;
    }

    public void setKodePenerbangan(String kodePenerbangan) {
        this.kodePenerbangan = kodePenerbangan;
    }

    public String getJenisPesawat() {
        return jenisPesawat;
    }

    public void setJenisPesawat(String jenisPesawat) {
        this.jenisPesawat = jenisPesawat;
    }

    public LocalDateTime getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public void setWaktuBerangkat(LocalDateTime waktuPenerbangan) {
        this.waktuBerangkat = waktuPenerbangan;
    }

    public LocalDateTime getWaktuPulang() {
        return waktuPulang;
    }

    public void setWaktuPulang(LocalDateTime waktuPulang) {
        this.waktuPulang = waktuPulang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
