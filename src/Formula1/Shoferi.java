package Formula1;

import java.io.Serializable;

//Klasa Shoferi perfaqeson cdo shofer ne kampionat
public abstract class Shoferi implements Serializable {

    String emri;
    String vendndodhja;
    String ekipi;
    /**
     * Konstruktori Shoferi me te dhenat kryesore
     * emri- emri i shoferit.
     *vendndodhja- vendndodhja e shoferit.
     * ekipi-ekipi i cdo shoferi.
     */
    public Shoferi( String emri, String vendndodhja, String ekipi)
    {
        this.emri= emri;
        this.vendndodhja = vendndodhja;
        this.ekipi = ekipi;
    }
    //metodat get dhe set
    public void setEmri(String emri)
    {
        this.emri = emri;
    }

    public void setVendndodhja(String vendndodhja)
    {
        this.vendndodhja = vendndodhja;
    }

    public void setEkipi(String ekipi)
    {
        this.ekipi = ekipi;
    }

    public String getEmri()
    {
        return emri;
    }

    public String getVendndodhja()
    {
        return vendndodhja;
    }

    public String getEkipi()
    {
        return ekipi;
    }

}