package Formula1;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 Klasa GaraFormula1 prezanton cdo gare ne kampionat
 */
public class GaraFormula1 implements Serializable
{

    LocalDate date;
    ArrayList <ShoferiFormula1> raceDrivers = new ArrayList<ShoferiFormula1>(10);

    /*
     Ky konstruktor permban garat e F1 me te dhenat e gares
     date-data e gares
     raceDrivers-Lista e shofereve qe moren pjese
     */

    public GaraFormula1(LocalDate date, ArrayList raceDrivers) {
        this.date = date;
        this.raceDrivers = raceDrivers;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public void setDriverPositions(ArrayList raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    public LocalDate getDate() {
        return date;
    }


    public ArrayList<ShoferiFormula1> getDriverPositions() {
        return raceDrivers;
    }
}
