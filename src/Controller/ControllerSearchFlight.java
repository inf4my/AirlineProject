package Controller;

import BusinessLayer.Penerbangan;
import DataLinkLayer.FlightAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Taksu on 12/12/2016.
 */
public class ControllerSearchFlight {
    @FXML
    Label lblPB, lblPS, lblPD, lblPT, lblWaktuPergi, lblWaktuSampai, lblDetailSampai, lblDetailPergi;
    @FXML
    TableView<Penerbangan> tblBerangkat;
    @FXML
    TableColumn colTujuan, colBerangkat, colSampai, colTransit;
    @FXML
    ImageView Icon;
    @FXML
    AnchorPane achDetail, achPergi;
    @FXML
    TabPane tabBerangkat;
    @FXML
    Tab TabDetail, TabRincian;

    List<Penerbangan> lstOfPenerbangan = new ArrayList<Penerbangan>();
    ObservableList<Penerbangan> showList = FXCollections.observableArrayList();

    private void filter(){
        for(Penerbangan x: lstOfPenerbangan){
            showList.add(x);
        }
    }
    public void initialize(){
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
    @FXML
    protected void handlePick(){
        Penerbangan hightlight = tblBerangkat.getSelectionModel().getSelectedItem();
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
}
