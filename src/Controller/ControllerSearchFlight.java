package Controller;

import BusinessLayer.Penerbangan;
import DataLinkLayer.FlightAL;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Taksu on 12/12/2016.
 */
public class ControllerSearchFlight {
    List<Penerbangan> lstOfPenerbangan = new ArrayList<Penerbangan>();

    public void initialize(){
        lstOfPenerbangan = FlightAL.getAllPenerbangan();
        for(Penerbangan x: lstOfPenerbangan){
            System.out.println(x.getKeberangkatan()+ " - " + x.getWaktuBerangkat() + " - " + x.getWaktuPulang() + " - "+ x.getHarga());
        }
    }
}
