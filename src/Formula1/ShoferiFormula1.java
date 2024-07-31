package Formula1;
import static java.lang.String.format;
import java.io.Serializable;
import java.util.Comparator;

//Klasa ShoferiFormula1 perfaqeson cdo shofer te Formula 1 ne kampionatin e formula 1

public class ShoferiFormula1 extends Shoferi implements Serializable{

    int fstPos;
    int scndPos;
    int trdPos;
    int raceCount;
    int driverPoints;

    /**Konstruktori ShoferiFormula1 me te dhenat e shoferit
     * emri- emri i shoferit.
     * vendndodhja- vendndodhja e shoferit.
     * ekipi-ekipi i cdo shoferi.
     * fstPos- Nr i vendeve te para per shofer.
     * scndPos-Nr i vendeve te dyta per shofer.
     * trdPos-Nr i vendeve te treta per shofer.
     * driverPoints -Nr total i pikeve per shofer.
     * raceCount-Nr total i garave per shofer.
     */

    public ShoferiFormula1(String emri, String vendndodhja, String ekipi, int fstPos, int scndPos, int trdPos, int driverPoints, int raceCount)
    {
        super(emri, vendndodhja, ekipi);
        this.fstPos = fstPos;
        this.scndPos = scndPos;
        this.trdPos = trdPos;
        this.driverPoints = driverPoints;
        this.raceCount = raceCount;
    }
    //metodat get dhe set
    public void setFstPos(int fstPos) {
        this.fstPos = fstPos;
    }

    public void setScndPos(int scndPos) {
        this.scndPos = scndPos;
    }

    public void setTrdPos(int trdPos) {
        this.trdPos = trdPos;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public int getFstPos() {
        return fstPos;
    }

    public int getScndPos() {
        return scndPos;
    }

    public int getTrdPos() {
        return trdPos;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    public int getRaceCount() {
        return raceCount;
    }


    @Override
    public String toString()
    {
        return  format("|"+" %-20s"+"|"+" %-15s"+"|"+" %-15s"+"|"+"%12d "+"|"+"%12d "+"|"+"%12d "+"|"+" %15d "+"|"+"%15d "+"|", emri,vendndodhja,ekipi,fstPos,scndPos,trdPos,driverPoints,raceCount)
                + "\n+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+";

    }
    // Comparator perdoret per te krahasuar objektet e nje klase=>
    //eshte perdorur per te krahasuar se cili shofer ka me shume vende te para
    public static Comparator<ShoferiFormula1>fstPosComparator = new Comparator<ShoferiFormula1>()
    {
        @Override
        public int compare(ShoferiFormula1 d1, ShoferiFormula1 d2)
        {
            int driver1FstPos = d1.getFstPos();
            int driver2FstPos = d2.getFstPos();
            return driver2FstPos-driver1FstPos;
        }
    };
    //e njejta gje por per te krahasuar piket
    public static Comparator<ShoferiFormula1> pointsComparator = new Comparator<ShoferiFormula1>()
    {
        @Override
        public int compare(ShoferiFormula1 d1, ShoferiFormula1 d2)
        {
            int driver1Points = d1.getDriverPoints();
            int driver2Points = d2.getDriverPoints();
            return driver2Points-driver1Points;
        }
    };



}
