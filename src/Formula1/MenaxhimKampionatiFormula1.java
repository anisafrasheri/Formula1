package Formula1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;



public class MenaxhimKampionatiFormula1 implements Serializable,MenaxhimKampionati {



    private static final long serialVersionUID = 1L;
    String shoferiEmri;
    String shoferiEkipi;
    String shoferiVendndodhja;
    int fstPos;
    int scndPos;
    int trdPos;
    int driverPoints;
    int raceCount;
    private static final Locale defaultFormattingLocale = Locale.getDefault(Locale.Category.FORMAT);
    private static final String defaultDateFormat = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, IsoChronology.INSTANCE, defaultFormattingLocale);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(defaultDateFormat, defaultFormattingLocale);
    static ArrayList<ShoferiFormula1> ShoferiF1 = new ArrayList<ShoferiFormula1>();
    static ArrayList<GaraFormula1> GaraF1 = new ArrayList<GaraFormula1>();
    static int[] ArrPiket= {25,18,15,12,10,8,6,4,2,1};
    static ArrayList<ShoferiFormula1> raceDrivers = new ArrayList<ShoferiFormula1>(10);
    static Scanner input = new Scanner (System.in);


    //metoda krijoshofer() sherben per te krijuar nje shofer te ri
    public void krijoShofer()
    {
        try {
            while (true)
            {
                System.out.print("Shkruani emrin e shoferit : ");    //kontrollojme nese stringa permban numra
                shoferiEmri= input.next();
                while(!shoferiEmri.matches("[a-z || A-Z ]+")){

                    System.out.println("Emri s'mund te permbaje numra!");
                    return;

                }
                boolean loop = false;
                //kontrollojme nese Shoferi i vendosur ekziston tashme

                for(ShoferiFormula1 driver : ShoferiF1) {
                    if(driver.getEmri().equalsIgnoreCase(shoferiEmri))
                    {
                        loop=true;
                        break;
                    }
                }
                if (loop)
                {
                    System.out.println(shoferiEmri+ " "+ "ekziston tashme ne sistem!" );
                    continue;
                }
                else {
                    while(true) {
                        System.out.print("Shkruani ekipin e shoferit: ");
                        shoferiEkipi= input.next();
                        while(!shoferiEkipi.matches("[a-z || A-Z ]+")){
                            System.out.println("Ekipi s'mund te permbaje numra!");
                            return;
                        }
                        loop=false;

                        //kontrollojme nese ekipi ku duam te shtojme shoferin e ka nje shofer
                        for (ShoferiFormula1 driver : ShoferiF1)
                        {
                            if (driver.getEkipi().equalsIgnoreCase(shoferiEkipi))
                            {
                                loop = true;
                                break;
                            }
                        }
                        if (loop)
                        {
                            System.out.println(shoferiEkipi+ " Ekipi e ka nje shofer!" );
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
            }


//lexon nga perdoruesi vendndodhjen,numrat e vendeve te para te dyta te treta piket totale dhe garat totale te shoferit te ri
            System.out.print("Shkruani vendndodhjen e shoferit : ");
            shoferiVendndodhja= input.next();
            while(!shoferiVendndodhja.matches("[a-z || A-Z ]+")){
                System.out.println("Vendndodhja s'mund te permbaje numra!");
                return;
            }
            System.out.print("Shkruani numrin e vendeve te para:");
            fstPos = input.nextInt();
            System.out.print("Shkruani numrin e vendeve te dyta : ");
            scndPos = input.nextInt();
            System.out.print("Shkruani numrin e vendeve te treta : ");
            trdPos = input.nextInt();
            System.out.print("Shkruani piket totale te shoferit : ");
            driverPoints = input.nextInt();

            while (true)
            {
                System.out.print("Shkruani numrin total te garave te shoferit: ");
                raceCount = input.nextInt();

//Shuma e pozicioneve te para ,te dyta, te treta duhet te jete me i vogel se numri total i garave
                if ((fstPos+scndPos+trdPos) <= raceCount)
                    break;
                else
                    System.out.println(" >>>Numri i garave nuk mund te jete me i vogel se shuma e vendeve te para ,te dyta ,te treta!");
            }
            input.nextLine();
//Krijojme nje objekt te ri driver nga klasa ShoferiFormula1 dhe e ruajme ate te arraylista ShoferiF1
            ShoferiF1.add(new ShoferiFormula1(shoferiEmri, shoferiVendndodhja, shoferiEkipi, fstPos, scndPos, trdPos, driverPoints, raceCount));

            System.out.println("\n >> Shoferi i ri u shtua me sukses!");

        }catch (Exception e)
        {
            System.out.println(" >> Ju lutem vendosni vlera te pranueshme!");
        }
    }


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    public void fshiShofer()
    {
        //iterator perdoret per te bere loop cdo collection objektesh si ArrayList

        Iterator <ShoferiFormula1> itr = ShoferiF1.iterator();

        try
        {
            System.out.print("Shkruani emrin e shoferit: ");
            String  shoferiEmri= input.next();

            //kontrollojme nese emri i shoferit ndodhet ne ShoferiF1 Arraylist dhe e fshijme ate
            while (itr.hasNext())

            {
                ShoferiFormula1 Dr1 = itr.next();
                if (Dr1.getEmri().equals(shoferiEmri))
                {
                    itr.remove();
                    System.out.println(" >>Shoferi u fshi me sukses!");

                    break;
                }
            }
        }catch (Exception e)
        {
            System.out.println("Ju lutem vendosni vlere te pranueshme!");
        }
    }


    // Metoda ndryshoShofer() lejon perdoruesin qe te ndryshoje nje shofer nga ShoferiF1 Arraylist .


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    public void ndryshoShofer()
    {
        try
        {
            System.out.print("Shkruani emrin e shoferit: ");
            shoferiEmri = input.next();
            for (int i = 0; i < ShoferiF1.size(); i++)
            {
                //Kontrollojme nese emri i shoferit i marre nga perdoruesi ndodhet ne ArrayList dhe e zevendesojme ate me te dhenat e reja.



                if (ShoferiF1.get(i).getEmri().equalsIgnoreCase(shoferiEmri))
                {
                    System.out.println("Shkruani emrin e shoferit te ri per skuadren " + ShoferiF1.get(i).getEkipi() +" : ");
                    String newShoferiEmri = input.next();

                    System.out.print("Shkruani vendndodhjen e shoferit te ri : ");
                    shoferiVendndodhja = input.next();
                    System.out.print("Shkruani numrin e vendeve te para : ");
                    fstPos = input.nextInt();
                    System.out.print("Shkruani numrin e vendeve te dyta : ");
                    scndPos = input.nextInt();
                    System.out.print("Shkruani numrin e vendeve te treta : ");
                    trdPos = input.nextInt();
                    System.out.print("Shkruani piket totale te shoferit : ");
                    driverPoints = input.nextInt();

                    while (true)
                    {
                        System.out.print("Shkruani numrin total te garave: ");
                        raceCount = input.nextInt();

                        if ((fstPos+scndPos+trdPos) <= raceCount)
                            break;
                        else
                            System.out.println(">>Numri i garave nuk mund te jete me i vogel se shuma e vendeve te para ,te dyta ,te treta!");}


                    //Perditesojme objektin ShoferiF1 me te dhenat e reja

                    ShoferiF1.get(i).setEmri(newShoferiEmri);
                    ShoferiF1.get(i).setVendndodhja(shoferiVendndodhja);
                    ShoferiF1.get(i).setFstPos(fstPos);
                    ShoferiF1.get(i).setScndPos(scndPos);
                    ShoferiF1.get(i).setTrdPos(trdPos);
                    ShoferiF1.get(i).setDriverPoints(driverPoints);
                    ShoferiF1.get(i).setRaceCount(raceCount);

                    System.out.println(" >> Emri i shoferit te ri u perditesua me sukses!");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(" >> Shoferi nuk ekziston");
        }

    }


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    //Metoda shfaqStatistikat() shfaq te dhenat e ruajtura per cdo shofer

    @Override
    public void shfaqStatistikat()
    {
        try
        {
            System.out.print("Shkruani emrin e shoferit: ");
            String shoferiEmri = input.next();
            for (int i = 0; i <= ShoferiF1.size(); i++)
            {
                //kontrollon nese emri i shoferit te marre ndodhet ne ArrayList dhe shfaq te dhenat per te

                if (ShoferiF1.get(i).getEmri().equalsIgnoreCase(shoferiEmri))
                {
                    System.out.println("\n >> Statistikat e "+ shoferiEmri );

                    System.out.println("+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+");
                    System.out.format("|"+" %-20s"+"|"+" %-15s"+"|"+" %-15s"+"|"+" %-12s"+"|"+" %-12s"+"|"+" %-12s"+"|"+" %-15s "+"|"+" %-15s"+"|", "Emri", "Vendndodhja", "Ekipi", "Nr.1st", " Nr. 2nd ", " Nr. 3rd .", "Piket totale", "Garart totale");
                    System.out.println("|====================================================================================================================================|");
                    System.out.println(ShoferiF1.get(i));
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(" >>Ky shofer nuk ekziston! ");
        }
    }


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    // Metoda shfaqTabelen() shfaq te gjithe shoferet e ShoferiF1 Arraylist te renditur


    @Override
    public void shfaqTabelen()
    {
        int driversCount = 0;
        int carCount = 0;

        if (ShoferiF1.size()==0)
            System.out.println(" >> Nuk ka te dhena akoma");
        else {
            renditTabelen();
            System.out.println(" >>Tabela e Formula 1 2023");
            System.out.println("+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+");
            System.out.format("|"+" %-20s"+"|"+" %-15s"+"|"+" %-15s"+"|"+" %-12s"+"|"+" %-12s"+"|"+" %-12s"+"|"+" %-15s "+"|"+" %-15s"+"|", "Emri", "Vendndodhja", "Ekipi", "Nr.1st", " Nr. 2nd ", " Nr. 3rd .", "Piket totale", "Garart totale");
            System.out.println("|====================================================================================================================================|");

            for (int i = 0; i < ShoferiF1.size(); i++)
            {
                System.out.println(ShoferiF1.get(i));
                driversCount++;
                carCount++;
            }
            System.out.println(" | Shofere Total : "+ driversCount);
            System.out.println(" | Makina Totale : "+ carCount);
        }
    }


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    //Metoda renditTabelen() ben renditjen e tabeles se shofereve sipas vendeve te para dhe pikeve

    public void renditTabelen()
    {
        Collections.sort(ShoferiF1, ShoferiFormula1.fstPosComparator);    // ne fillim i rendit shoferet sipas vendeve te para
        Collections.sort(ShoferiF1,ShoferiFormula1.pointsComparator);    // dhe me pas sipas pikeve totale
    }



    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    //shtoGare() lejon perdoruesin qe te shtoje nje gare te perfunduar te FORMULA 1
    // ruajme te dhenat e gares ne GaraF1 Arraylist

    @SuppressWarnings("unlikely-arg-type")
    @Override
    public void shtoGare()
    {

        LocalDate raceDate;
        while(true)
        {
            // Marrim daten nga perdoruesi
            System.out.println("Data e gares : Shkruani garen ne formatin (dd/mm/yy) ");
            String inputDate = input.next();


            try{
                raceDate = LocalDate.parse(inputDate, dateFormatter);
                break;
            }catch (DateTimeParseException e)
            {
                System.out.println("Date e pasakte: "+ inputDate );
            }

        }

        for (int i = 0; i < 10; i++)
        {
            //Marrim emrat e shofereve nga perdoruesi per vendet qe kane perfunduar garen

            System.out.print("Shkruani emrin e shoferit ne vendin "+ (i+1) +" : ");
            String shoferiEmri = input.next().toUpperCase();

            for (int j = 0; j < ShoferiF1.size(); j++)
            {
                if (ShoferiF1.get(j).getEmri().equalsIgnoreCase(shoferiEmri))
                {
                    if ((Arrays.asList(raceDrivers).contains(shoferiEmri)))
                    {
                        raceDrivers.add(ShoferiF1.get(j));
                        break;
                    }else
                    {
                        System.out.println(" >> Emri eshte shkruar me pare!");
                        i--;
                        break;
                    }
                }
                if (j == ShoferiF1.size()-1 )
                {
                    System.out.println(" >> Ky shofer nuk ekziston!");
                    i--;
                }
            }
        }
        pointCalc(raceDrivers);

        //Krijojme nje objekt te ri gare nga klasa GaraFormula1 dhe e shtojme ate te GaraF1 ArrayList

        GaraF1.add(new GaraFormula1(raceDate,  raceDrivers));
        System.out.println("\n >> Gara u shtua me sukses!");
        System.out.println(" >> Tabela  e Formula 1 u perditesua me sukses!");
    }


    /**Sipas dates se gares se shtuar nga perdoruesi
     * piket i shtohen shoferit sipas pozicionit te arritur
     * rrit nr e garave me nga 1 per shoferet pjesemarres
     * rrit vendet e para te dyta te treta me nga 1
     */


    @SuppressWarnings("rawtypes")
    public void pointCalc(ArrayList drivers)
    {
        // Llogarit piket e tre pozicioneve te gares dhe shto piket e meparshme te shofereve.
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < ShoferiF1.size(); j++)
            {
                if (ShoferiF1.get(j).equals(drivers.get(i)))                {
                    ShoferiF1.get(j).setDriverPoints(ShoferiF1.get(j).getDriverPoints() + ArrPiket[i]);
                    ShoferiF1.get(j).setRaceCount(ShoferiF1.get(j).getRaceCount() + 1);

                    if ((i+1) == 1)
                        ShoferiF1.get(j).setFstPos(ShoferiF1.get(j).getFstPos()+1);
                    else if ((i+1) == 2)
                        ShoferiF1.get(j).setScndPos(ShoferiF1.get(j).getScndPos()+1);
                    else if ((i+1) == 3)
                        ShoferiF1.get(j).setTrdPos(ShoferiF1.get(j).getTrdPos()+1);
                    break;
                }
            }
        }
    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    //Metoda ruajInfo lejon perdoruesin te ruaj te dhenat e marra ne nje file te jashtem

    public void ruajInfo()
    {
        writeFile(new File("F1DriverData.ser"),ShoferiF1);
        writeFile(new File("F1RaceData.ser"), GaraF1);

    }

    /**
     * Lejon perdoruesin te ruaje te dhenat e marra ne nje file te jashtem,
     * ruan te dhenat automatkisht pasi perdoruesi del nga programi
     */

    @SuppressWarnings("rawtypes")
    public void writeFile(File writer, ArrayList arrList)
    {
        try{
            FileOutputStream writeData = new FileOutputStream(writer);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);


            writeStream.writeObject(arrList);
            writeStream.flush();
            writeStream.close();

            System.out.println(" >> "+ writer +" File u perditesua!");

        }
        catch (IOException e ) {
            e.printStackTrace();
        }

    }
    @SuppressWarnings("unchecked")
    public void loadInfo()
    {
        try {
            FileInputStream readData = new FileInputStream("F1DriverData.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            ShoferiF1 = (ArrayList<ShoferiFormula1>) readStream.readObject();
            readStream.close();

            readData = new FileInputStream("F1RaceData.ser");
            readStream = new ObjectInputStream(readData);
            GaraF1 = (ArrayList<GaraFormula1>) readStream.readObject();
            readStream.close();

            System.out.println("\n >>Te dhenat e meparshme u ngarkuan me sukses!");

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    public static void main(String[] args) {
        MenaxhimKampionatiFormula1 fcm = new MenaxhimKampionatiFormula1();

        fcm.loadInfo();

        String option;

        boolean looper = true;
        while(looper)
        {

            System.out.println("======FORMULA 1======");
            System.out.println("A-Krijo shofer");
            System.out.println("B-Fshi shofer");
            System.out.println("C-Ndrysho shofer");
            System.out.println("D-Shfaq statistikat");
            System.out.println("E-Shfaq tabelen");
            System.out.println("F-Shto Gare ");
            System.out.println("G-Ruaj Info");
            System.out.println("X-Dil nga programi");
            System.out.println("H-Shfaq GUI");
            System.out.print("Shkruani zgjedhjen tuaj: ");
            option = input.next().toUpperCase();
            System.out.println("***********************************************************************");
            if (option.equals("X"))
            {
                looper = false;
                fcm.ruajInfo();
            }
            else
                fcm.lexoshkr(option);
        }

    }
    void lexoshkr(String option)
    {
        if (option.equals("A"))
            krijoShofer();
        else if (option.equals("B"))
            fshiShofer();
        else if (option.equals("C"))
            ndryshoShofer();
        else if (option.equals("D"))
            shfaqStatistikat();
        else if (option.equals("E"))
            shfaqTabelen();
        else if (option.equals("F"))
            shtoGare();
        else if (option.equals("G"))
            ruajInfo();
        else if(option.equals("H"))
            new GUI();
        else
            System.out.println(" >> Zgjedhja juaj nuk eshte e sakte!");

    }

}