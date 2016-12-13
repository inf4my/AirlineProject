package Controller;

import BusinessLayer.Penerbangan;
import DataLinkLayer.FlightAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Taksu on 12/12/2016.
 */
public class ControllerSearchFlight {
    @FXML
    Label lblPB, lblPS, lblPD, lblPT, lblWaktuPergi, lblWaktuSampai, lblDetailSampai, lblDetailPergi, lblRaja;
     @FXML
    Label lblHD, lblHA, lblHB, lblID, lblIA, lblIB, lblHT, lblIT, lblTahap;
    @FXML
    TableView<Penerbangan> tblBerangkat;
   @FXML
    TableColumn colTujuan, colBerangkat, colSampai, colTransit;
    @FXML
    ImageView Icon, Icon2;
    @FXML
    AnchorPane achDetail, achPergi;
   @FXML
    TabPane tabBerangkat;
   @FXML
    Tab TabDetail, TabRincian;
   @FXML
    Button btnBeli, btnBeli1;

    Penerbangan hightlight;
    List<Penerbangan> lstOfPenerbangan = new ArrayList<Penerbangan>();
    ObservableList<Penerbangan> showList = FXCollections.observableArrayList(), showList2 = FXCollections.observableArrayList();
    LocalDate pergi, pulang;
    String tiketDewasa, tiketAnak, tiketBayi, asal, tujuan, kelas;

    String kode1, berangkat1, tujuan1, waktuBerangkat1, waktuSampai1, kelas1, totalBiaya1;

    private void filter(){
        for(Penerbangan x: lstOfPenerbangan){
            if(x.getWaktuBerangkat().toLocalDate().equals(pergi) && (x.getKeberangkatan().contains(asal)||asal.contains(x.getKeberangkatan()))&&
                    (x.getTujuan().contains(tujuan)||tujuan.contains(x.getTujuan()))){
            showList.add(x);
                System.out.println(x.getKeberangkatan());}
        }
    }

    public void initialize(LocalDate dtpPergi, LocalDate dtpPulang, String cboTiketDewasa, String cboTiketAnak, String cboTiketBayi,
                           String cboAsal, String cboTujuan, String cboKelasPenerbangan){
        pergi = dtpPergi;
        pulang = dtpPulang;
        tiketDewasa = cboTiketDewasa;
        tiketAnak = cboTiketAnak;
        tiketBayi = cboTiketBayi;
        asal = cboAsal;
        tujuan = cboTujuan;
        kelas = cboKelasPenerbangan;
        System.out.println(tiketDewasa + " + " + tiketAnak + " + " + tiketBayi+ " + " + kelas + " " + pulang);
        blmPilih();
        lstOfPenerbangan = FlightAL.getAllPenerbangan();
        filter();
        colBerangkat.setCellValueFactory(new PropertyValueFactory<Penerbangan, LocalDateTime>("waktuBerangkat"));
        colTujuan.setCellValueFactory(new PropertyValueFactory<Penerbangan, String>("tujuan"));
        colSampai.setCellValueFactory(new PropertyValueFactory<Penerbangan, LocalDateTime>("waktuPulang"));
        tblBerangkat.setItems(showList);


       /* for(Penerbangan x: lstOfPenerbangan){
            System.out.println(x.getKeberangkatan()+ " - " + x.getWaktuBerangkat() + " - " + x.getWaktuPulang() + " - "+ x.getHarga());
        }*/
    }
    public void blmPilih(){
        tblBerangkat.setLayoutY(360);
        tblBerangkat.setPrefHeight(341);
        tabBerangkat.setPrefHeight(44);
        Icon.setVisible(false);
        lblRaja.setVisible(false);
        lblPB.setVisible(false);
        lblPS.setVisible(false);
        lblPD.setVisible(false);
        lblPT.setVisible(false);
        lblHD.setVisible(false);
        lblHA.setVisible(false);
        lblHB.setVisible(false);
        lblID.setVisible(false);
        lblIA.setVisible(false);
        lblIB.setVisible(false);
        lblHT.setVisible(false);
        lblIT.setVisible(false);
        Icon2.setVisible(true);
    }
    protected void pilih(){
        tblBerangkat.setLayoutY(498);
        tblBerangkat.setPrefHeight(185);
        tabBerangkat.setPrefHeight(155);
        Icon.setVisible(true);
        lblRaja.setVisible(true);
        lblPB.setVisible(true);
        lblPS.setVisible(true);
        lblPD.setVisible(true);
        lblPT.setVisible(true);
        Icon2.setVisible(false);

        lblHD.setVisible(true);
        lblHA.setVisible(true);
        lblHB.setVisible(true);
        lblID.setVisible(true);
        lblIA.setVisible(true);
        lblIB.setVisible(true);
        lblHT.setVisible(true);
        lblIT.setVisible(true);
    }
    public void hitung(Penerbangan h){
        if(kelas.equals("Ekonomi")){

            lblHD.setText("Harga Dewasa ("+tiketDewasa+"x)");
            lblID.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketDewasa))));

            lblHA.setText("Harga Anak ("+tiketAnak+"x)");
            lblIA.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketAnak) /2)));

            lblHB.setText("Harga Anak ("+tiketBayi+"x)");
            lblIB.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketBayi) /4)));
        }
        else if(kelas.equals("Bisnis")){
            lblHD.setText("Harga Dewasa ("+tiketDewasa+"x)");
            lblID.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketDewasa)*2)));

            lblHA.setText("Harga Anak ("+tiketAnak+"x)");
            lblIA.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketAnak) /2 *2)));

            lblHB.setText("Harga Anak ("+tiketBayi+"x)");
            lblIB.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketBayi) /4 *2)));
        }
        else if(kelas.equals("First Class")){
            lblHD.setText("Harga Dewasa ("+tiketDewasa+"x)");
            lblID.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketDewasa)*3)));

            lblHA.setText("Harga Anak ("+tiketAnak+"x)");
            lblIA.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketAnak) /2*3)));

            lblHB.setText("Harga Bayi ("+tiketBayi+"x)");
            lblIB.setText(Integer.toString((h.getHarga() * Integer.parseInt(tiketBayi) /4*3)));

            //lblIT.setText(Integer.toString(Integer.parseInt(lblID.getText()) + Integer.parseInt(lblIA.getText()) + Integer.parseInt(lblIB.getText())));
        }
        lblIT.setText(Integer.toString(Integer.parseInt(lblID.getText()) + Integer.parseInt(lblIA.getText()) + Integer.parseInt(lblIB.getText())));
    }
    @FXML
    public void handleLook(){
        blmPilih();
    }
    @FXML
    public void handlePick(){
        pilih();
        hightlight = tblBerangkat.getSelectionModel().getSelectedItem();
        hitung(hightlight);
        Icon.setVisible(true);
        lblRaja.setVisible(true);
        System.out.println(hightlight.getWaktuBerangkat().format(DateTimeFormatter.ofPattern("HH:mm")));
        lblPB.setText(hightlight.getWaktuBerangkat().format(DateTimeFormatter.ofPattern("HH:mm")));
        lblPS.setText(hightlight.getWaktuPulang().format(DateTimeFormatter.ofPattern("HH:mm")));
        lblPD.setText(hightlight.getKeberangkatan());
        lblPT.setText(hightlight.getTujuan());

        lblWaktuPergi.setText(hightlight.getWaktuBerangkat().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        lblWaktuSampai.setText(hightlight.getWaktuPulang().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        lblDetailPergi.setText(hightlight.getKeberangkatan());
        lblDetailSampai.setText(hightlight.getTujuan());
    }


    private void filter2(){
        showList = null;
        showList = FXCollections.observableArrayList();
        for(Penerbangan x: lstOfPenerbangan){
            if(x.getWaktuBerangkat().toLocalDate().equals(pulang) && (x.getKeberangkatan().contains(tujuan)||tujuan.contains(x.getKeberangkatan()))&&
                    (x.getTujuan().contains(asal)||asal.contains(x.getTujuan()))){
                showList.add(x);System.out.println(x.getKeberangkatan());}

        }
    }
    public void setTable2(){
        colBerangkat.setCellValueFactory(new PropertyValueFactory<Penerbangan, LocalDateTime>("waktuBerangkat"));
        colTujuan.setCellValueFactory(new PropertyValueFactory<Penerbangan, String>("tujuan"));
        colSampai.setCellValueFactory(new PropertyValueFactory<Penerbangan, LocalDateTime>("waktuPulang"));
        tblBerangkat.setItems(showList);
    }
    @FXML
    public void handleBeli(){
        if(pulang==null) {
            try {
                //System.out.println(cboTujuan.getValue());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
                Parent entryForm = loader.load();
                Stage entryStage = new Stage();
                entryStage.setTitle("Searching Flight");
                entryStage.setScene(new Scene(entryForm, 455, 600));
                entryStage.show();
                entryStage.requestFocus();
                entryStage.getIcons().add(new Image(this.getClass().getResource("search.png").toString()));
                ControllerConfirmation x = (ControllerConfirmation) loader.getController();
                x.initialize(hightlight.getKodePenerbangan(), hightlight.getKeberangkatan(), hightlight.getTujuan(), lblWaktuPergi.getText(), lblWaktuSampai.getText(), kelas, lblIT.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            lblTahap.setText("2");
            btnBeli.setVisible(false);
            btnBeli1.setVisible(true);
            kode1 = hightlight.getKodePenerbangan();
            berangkat1 = hightlight.getKeberangkatan();
            tujuan1 = hightlight.getTujuan();
            waktuBerangkat1 = lblWaktuPergi.getText();
            waktuSampai1 = lblWaktuSampai.getText();
            kelas1 = kelas;
            totalBiaya1 = lblIT.getText();
            blmPilih();
            filter2();
            setTable2();
        }
    }
    @FXML
    public void handleBeli1(){
        try {
            //System.out.println(cboTujuan.getValue());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Searching Flight");
            entryStage.setScene(new Scene(entryForm, 1200, 600));
            entryStage.show();
            entryStage.requestFocus();
            entryStage.getIcons().add(new Image(this.getClass().getResource("search.png").toString()));
            ControllerConfirmation x = (ControllerConfirmation) loader.getController();
            x.initialize(kode1, berangkat1, tujuan1, waktuBerangkat1,  waktuSampai1,  kelas,  totalBiaya1,  hightlight.getKodePenerbangan()
                    , tujuan1, berangkat1, lblWaktuPergi.getText(), lblWaktuSampai.getText(),  lblIT.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
