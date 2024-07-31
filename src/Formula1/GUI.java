package Formula1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GUI implements ActionListener{
    JPanel topPanel;
    JPanel leftPanel;
    JPanel midPanel;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel searchPanel;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JLabel label13;
    JLabel label14;
    JLabel label15;
    JLabel label16;
    JLabel label17;
    JLabel label18;
    JLabel label19;


    JButton searchButton;
    JButton pointsAscButton;
    JButton fposDscButton;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;

    JTextField searchField;
    JTextField locationField;



    JTable driverTable;
    JTable completedRaceTable;
    JTable newRaceTable;
    JTable allRaceTable;
    JTable driverSearchTable;

    JScrollPane scrollPane1;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;
    JScrollPane scrollPane4;
    JScrollPane scrollPane5;

    JLayeredPane layeredPane;

    LocalDate randomRaceDate;



    ArrayList <ShoferiFormula1> raceDriversData = new ArrayList<ShoferiFormula1>(10);
    ArrayList <ShoferiFormula1> finalPositions = new ArrayList<ShoferiFormula1>(10);

    MenaxhimKampionatiFormula1 fcm = new MenaxhimKampionatiFormula1();





    public static void main(String[] args) {

        new GUI();
    }
    public GUI()
    {
        Border border = BorderFactory.createLineBorder(Color.black,5);

        textFields();
        buttons();
        labels();
        driverTable();
        panels();


        JFrame frame = new JFrame();    //krijojme nje frame
        frame.setTitle("Menaxhimi i Kampionatit Formula1");    //vendosim titullin e frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //dalim nga programi
        frame.getRootPane().setBorder(border);
        frame.setSize(1200,700);  //vendosim dimensionet x dhe y te frame
        frame.getContentPane().setBackground(Color.gray);   //vendosim ngjyren e background
        frame.setVisible(true);                      //e bejme frame te shfaqet
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel,BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //inicializojme JFields

    public void textFields()
    {
        searchField = new JTextField();
        searchField.setBounds(20,60,280,30);

        locationField = new JTextField();
        locationField.setBounds(40,40,200,30);

    }


    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //inicializojme JLabels

    public void labels() {
        // Create and configure label1 with a modern font and styling
        label1 = new JLabel("Menaxhimi i Kampionatit FORMULA 1");
        label1.setBounds(15, 10, 1100, 150);
        label1.setFont(new Font("SansSerif", Font.BOLD, 40));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setForeground(new Color(0, 102, 204)); // Deep blue color

        // Create and configure label2
        label2 = new JLabel(">> Statistikat per shoferet <<");
        label2.setBounds(241, 20, 500, 50);
        label2.setFont(new Font("Roboto", Font.PLAIN, 30));
        label2.setForeground(new Color(255, 165, 0)); // Orange

        // Create and configure label3
        label3 = new JLabel(">> Gara rastesore <<");
        label3.setBounds(250, 20, 500, 50);
        label3.setFont(new Font("Roboto", Font.PLAIN, 30));
        label3.setForeground(new Color(255, 165, 0)); // Orange

        // Create and configure label4
        label4 = new JLabel(">> Shto gare <<");
        label4.setBounds(340, 20, 500, 50);
        label4.setFont(new Font("Roboto", Font.PLAIN, 30));
        label4.setForeground(new Color(255, 165, 0)); // Orange

        // Create and configure label5
        label5 = new JLabel(">> Garat e perfunduara <<");
        label5.setBounds(300, 20, 500, 50);
        label5.setFont(new Font("Roboto", Font.PLAIN, 30));
        label5.setForeground(new Color(255, 165, 0)); // Orange

        // Create and configure label7
        label7 = new JLabel("Vendndodhja");
        label7.setBounds(40, 15, 100, 20);
        label7.setFont(new Font("Verdana", Font.BOLD, 15));
        label7.setForeground(Color.GRAY);

        // Create and configure label9 with border and add label7 and locationField
        label9 = new JLabel();
        label9.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204))); // Deep blue border
        label9.setBounds(40, 100, 860, 100);
        label9.setLayout(null); // Use null layout for manual positioning
        label9.add(label7);
        label9.add(locationField);
        locationField.setBounds(120, 10, 720, 25); // Adjusted position for locationField

        // Create and configure label17
        label17 = new JLabel(">> Statistikat e shoferit <<");
        label17.setBounds(300, 20, 500, 50);
        label17.setFont(new Font("Roboto", Font.PLAIN, 30));
        label17.setForeground(new Color(0, 102, 204)); // Deep blue

        // Create and configure label18
        label18 = new JLabel(" ~ Vendosni cfare doni te kerkoni! ~ ");
        label18.setBounds(250, 250, 500, 50);
        label18.setFont(new Font("Roboto", Font.PLAIN, 30));
        label18.setForeground(Color.WHITE);
        label18.setHorizontalAlignment(JLabel.CENTER);

        // Create and configure label19
        label19 = new JLabel("~ Ky shofer nuk ekziston! ~");
        label19.setBounds(300, 250, 500, 50);
        label19.setFont(new Font("Roboto", Font.PLAIN, 30));
        label19.setForeground(Color.WHITE);
        label19.setHorizontalAlignment(JLabel.CENTER);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //inicializojme JButtons

    public void buttons()
    {
        searchButton = new JButton("Kerko");
        searchButton.setBounds(35, 100, 150, 30);
        searchButton.addActionListener(e -> {
            switchPanels(searchPanel);
            if (!searchField.getText().isEmpty()) {
                boolean found = false;
                for (int i = 0; i < MenaxhimKampionatiFormula1.ShoferiF1.size(); i++) {
                    if (MenaxhimKampionatiFormula1.ShoferiF1.get(i).getEmri().equalsIgnoreCase(searchField.getText())) {
                        driverSearch(i);
                        searchPanel.removeAll();
                        searchPanel.add(label17);
                        searchPanel.add(label16);
                        searchPanel.add(scrollPane4);
                        searchPanel.repaint();
                        searchPanel.revalidate();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    searchPanel.removeAll();
                    searchPanel.add(label17);
                    searchPanel.add(label19);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            } else {
                searchPanel.removeAll();
                searchPanel.add(label17);
                searchPanel.add(label18);
                searchPanel.repaint();
                searchPanel.revalidate();
            }
        });


        button1 = new JButton("Statistikat e shoferit");
        button1.setBounds(20,200,280,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.remove(scrollPane1);
                switchPanels(panel1);
                fcm.loadInfo();
                driverTable();
                panel1.add(scrollPane1);
            }
        });

        pointsAscButton = new JButton("Duke u ngritur : Piket");
        pointsAscButton.setBounds(40,120,200,30);
        pointsAscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableSorter(driverTable, 6, "A");
            }
        });

        fposDscButton = new JButton("Duke zbritur : Pozicionet e para");
        fposDscButton.setBounds(250,120,200,30);
        fposDscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableSorter(driverTable, 3, "D");
            }
        });

        button5 = new JButton("Tabela e perditesuar");
        button5.setBounds(600,120,225,30);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverTable();
                panel1.add(scrollPane1);
            }
        });


        button2 = new JButton("Shto nje gare te perfunduar");
        button2.setBounds(20,280,280,40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearData();
                completedRace();
                switchPanels(panel2);
                panel2.remove(label9);
                panel2.add(label3);
                panel2.add(label9);
                panel2.add(button6);
                panel2.add(scrollPane2);

            }
        });

        button3 = new JButton("Shto nje gare te re");
        button3.setBounds(20,360,280,40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearData();
                newRace();
                switchPanels(panel3);
                panel3.remove(label9);
                panel3.add(label4);
                panel3.add(label9);
                panel3.add(button7);
                panel3.add(scrollPane5);
            }
        });

        button4 = new JButton("Te gjitha garat");
        button4.setBounds(20,440,280,40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel4.removeAll();
                fcm.loadInfo();
                allRaces();
                switchPanels(panel4);
                panel4.add(label5);
                panel4.add(scrollPane3);
            }
        });


        button6 = new JButton("+ Add Random Race");
        button6.setBounds(720,140,150,30);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomDriverGenerator(6);
                fcm.pointCalc(raceDriversData);
                MenaxhimKampionatiFormula1.GaraF1.add(new GaraFormula1(randomRaceDate, raceDriversData));
                fcm.loadInfo();
                panel2.add(scrollPane2);
            }
        });

        button7 = new JButton("+ Shtoni nje gare te rastesishme");
        button7.setBounds(700,140,180,30);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomDriverGenerator(7);
                fcm.pointCalc(finalPositions);
                MenaxhimKampionatiFormula1.GaraF1.add(new GaraFormula1(randomRaceDate, finalPositions));
                fcm.ruajInfo();
                panel3.add(scrollPane5);
            }
        });
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //Fshin te dhenat nga JTextFields

    public void clearData()
    {
        locationField.setText("    ");

    }

    /**
     *  Shfaq detajet e shoferit te kerkuar
     *  Krijon nje tabele per te shfaqur gjithe garat ku shoferi ka marre pjese
     */


    public void driverSearch(int i)
    {
        driverSearchTable = new JTable();
        DefaultTableModel searchTableModel = (DefaultTableModel) driverSearchTable.getModel();

        // percakton emrin e kolonave
        String[] columnNames = {"Data", "Pozicioni"};
        searchTableModel.setColumnIdentifiers(columnNames);

        // merr te dhenat e shoferit nga ArrayList ShoferiFI
        String name = MenaxhimKampionatiFormula1.ShoferiF1.get(i).getEmri();
        String country =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getVendndodhja();
        String team =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getEkipi();
        int fpos =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getFstPos();
        int spos =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getScndPos();
        int tpos =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getTrdPos();
        int points =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getDriverPoints();
        int raceCount =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getRaceCount();

        for (int j = 0; j <  MenaxhimKampionatiFormula1.GaraF1.size(); j++)
        {
            for (int k = 0; k < 10; k++)
            {
                // kontrollon nese shoferi ka marre pjese ne gara dhe shfaq info ne tabele.

                if (MenaxhimKampionatiFormula1.GaraF1.get(j).getDriverPositions().get(k).getEmri().equalsIgnoreCase(name))
                {
                    LocalDate date = MenaxhimKampionatiFormula1.GaraF1.get(j).getDate();
                    int position = (k+1);

                    Object[] data = {date, position};
                    searchTableModel.addRow(data);
                }
            }
        }
        searchLabels(name, country, team, fpos, spos, tpos, points, raceCount);

        tableSorter(driverSearchTable, 0, "D");
        driverSearchTable.setBackground(Color.gray);
        driverSearchTable.setEnabled(false);
        scrollPane4 = new JScrollPane(driverSearchTable);
        scrollPane4.setBounds(500,80,400,450);
    }


    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    public void searchLabels(String name, String country, String team, int fpos, int spos, int tpos, int points, int raceCount)
    {
        label10 = new JLabel();
        label10.setBounds(10,10,400,150);
        label10.setText("Emri: "+ name+ "    Vendi: "+ country + "    Ekipi: " + team  );
        label10.setFont(new Font("Arimo",Font.BOLD,20));
        label10.setForeground(Color.blue);
        label10.setBackground(Color.black);
        label10.setOpaque(true);
        label10.setIconTextGap(40);
        label10.setHorizontalAlignment(JLabel.CENTER);

        label11 = new JLabel();
        label11.setText("Piket totale : " + points);
        label11.setFont(new Font("Poppins",Font.BOLD,18));
        label11.setForeground(new Color(180,180,180));
        label11.setBounds(35,180,350,50);
        label11.setBorder(new MatteBorder(0,0,1,0, new Color(255,195,104)));
        label11.setHorizontalAlignment(JLabel.CENTER);

        label12 = new JLabel();
        label12.setText("Numri i pozicioneve te para : " + fpos);
        label12.setFont(new Font("Poppins",Font.BOLD,18));
        label12.setForeground(new Color(180,180,180));
        label12.setBounds(35,230,350,50);
        label12.setBorder(new MatteBorder(0,0,1,0, new Color(255,195,104)));
        label12.setHorizontalAlignment(JLabel.CENTER);

        label13 = new JLabel();
        label13.setText("Numri i pozicioneve te dyta : " + spos);
        label13.setFont(new Font("Poppins",Font.BOLD,18));
        label13.setForeground(new Color(180,180,180));
        label13.setBounds(35,280,350,50);
        label13.setBorder(new MatteBorder(0,0,1,0, new Color(255,195,104)));
        label13.setHorizontalAlignment(JLabel.CENTER);

        label14 = new JLabel();
        label14.setText("Numri i pozicioneve te treta : " + tpos);
        label14.setFont(new Font("Poppins",Font.BOLD,18));
        label14.setForeground(new Color(180,180,180));
        label14.setBounds(35,330,350,50);
        label14.setBorder(new MatteBorder(0,0,1,0, new Color(255,195,104)));
        label14.setHorizontalAlignment(JLabel.CENTER);

        label15 = new JLabel();
        label15.setText("Gara totale : " + raceCount);
        label15.setFont(new Font("Poppins",Font.BOLD,18));
        label15.setForeground(new Color(180,180,180));
        label15.setBounds(35,380,350,50);
        label15.setHorizontalAlignment(JLabel.CENTER);

        label16 = new JLabel();
        label16.setBorder(BorderFactory.createLineBorder(new Color(48,48,48)));
        label16.setBounds(40,80,420,450);
        label16.add(label10);
        label16.add(label11);
        label16.add(label12);
        label16.add(label13);
        label16.add(label14);
        label16.add(label15);
    }


    /** shfaq te dhenat e shoferave ne DriverTable
     * shfaq tabelen e te dhenave ne rendin rrites sipas pikeve te shofereve
     * shfaq tabelen ne rendin zbrites sipas numrit te vendeve te para
     */

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    public void driverTable()
    {
        driverTable =  new JTable();
        DefaultTableModel driverTableModel = (DefaultTableModel) driverTable.getModel();

        String[] columnNames = {"Emri", "Vendi", "Ekipi", "Pozicione te para", "Pozicione te dyta", "Pozicione te treta", "Piket totale", "Garat e llogaritura"};
        driverTableModel.setColumnIdentifiers(columnNames);


        for (int i = 0; i <MenaxhimKampionatiFormula1.ShoferiF1.size(); i++)
        {
            String name =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getEmri();
            String country =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getVendndodhja();
            String team = MenaxhimKampionatiFormula1.ShoferiF1.get(i).getEkipi();
            int fpos = MenaxhimKampionatiFormula1.ShoferiF1.get(i).getFstPos();
            int spos =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getScndPos();
            int tpos =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getTrdPos();
            int points =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getDriverPoints();
            int raceCount =  MenaxhimKampionatiFormula1.ShoferiF1.get(i).getRaceCount();

            Object [] data = {name,country,team,fpos,spos,tpos,points,raceCount};
            driverTableModel.addRow(data);
        }

        tableSorter(driverTable, 6, "D");
        driverTable.setBackground(Color.gray);
        driverTable.setEnabled(false);
        scrollPane1 = new JScrollPane(driverTable);
        scrollPane1.setBounds(40, 170, 860, 315);
    }


    // krijon tabele me te dhenat e garave te perfunduara

    public void completedRace()
    {
        completedRaceTable = new JTable();
        DefaultTableModel raceTableModel = (DefaultTableModel) completedRaceTable.getModel();
        String[] columnNames = {"Data", "Pozicioni", "Emri", "Ekipi"};
        raceTableModel.setColumnIdentifiers(columnNames);

        randomDateGenerator();

        for (int i = 0; i< raceDriversData.size(); i++)
        {
            Object[] data = {randomRaceDate, (i+1), raceDriversData.get(i).getEmri(), raceDriversData.get(i).getEkipi()};
            raceTableModel.addRow(data);
        }

        completedRaceTable.setBackground(Color.gray);
        completedRaceTable.setEnabled(false);
        scrollPane2 = new JScrollPane(completedRaceTable);
        scrollPane2.setBounds(40, 300, 860, 185);
    }


    /*
     * krijon nje tabele me gare rastesore
     * me probabilitetin e fitimit
     * lejon perdoruesin te gjeneroje nje gare rastesore te perfunduar
     */

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    public void newRace()
    {
        newRaceTable = new JTable();
        DefaultTableModel newRaceTableModel = (DefaultTableModel) newRaceTable.getModel();

        String[] columnNames = {"Data", "Emri", "Ekipi", "Pozicioni i startit", "Pozicioni i finishit"};
        newRaceTableModel.setColumnIdentifiers(columnNames);

        randomDateGenerator();

        if (!(raceDriversData.size() == 0))
        {
            int random = (int) ((Math.random()*(99))+0);

            // Vendosim pozicionin e pare sipas probabiliteteve te dhena
            if (random < 40)
                switchArrayItems(raceDriversData.get(0));
            else if (random < 70)
                switchArrayItems(raceDriversData.get(1));
            else if (random < 80)
                switchArrayItems(raceDriversData.get(2));
            else if (random < 90)
                switchArrayItems(raceDriversData.get(3));
            else if (random < 92)
                switchArrayItems(raceDriversData.get(4));
            else if (random < 94)
                switchArrayItems(raceDriversData.get(5));
            else if (random < 96)
                switchArrayItems(raceDriversData.get(6));
            else if (random < 98)
                switchArrayItems(raceDriversData.get(7));
            else if (random < 100)
                switchArrayItems(raceDriversData.get(8));

        }

        // Shfaqim detajet e nje gare rastesore ne nje tabele
        for(int i = 0; i < finalPositions.size(); i++)
        {
            for (int j = 0; j < raceDriversData.size(); j++)
            {
                if(finalPositions.get(i).getEmri().equals(raceDriversData.get(j).getEmri()))
                {
                    Object[] data = {randomRaceDate, finalPositions.get(i).getEmri(), finalPositions.get(i).getEkipi(), (j + 1), (i + 1)};
                    newRaceTableModel.addRow(data);
                    break;
                }
            }
        }

        newRaceTable.setBackground(Color.gray);
        newRaceTable.setEnabled(false);
        scrollPane5 = new JScrollPane(newRaceTable);
        scrollPane5.setBounds(40, 300, 860, 185);
    }

    /*
     * Vendosim fituesin ne indeksin 0 te vektorit
     */

    public void switchArrayItems(ShoferiFormula1 shoferi)
    {
        finalPositions.removeAll(finalPositions);
        finalPositions.addAll(raceDriversData);
        Collections.shuffle(finalPositions);
        int itemIndex = finalPositions.indexOf(shoferi);
        finalPositions.remove(itemIndex);
        finalPositions.add(0,shoferi);
    }

    /*
     * Shfaqja e gjithe garave me detajet
     */

    public void allRaces()
    {
        allRaceTable = new JTable();
        DefaultTableModel allRaceTableModel = (DefaultTableModel) allRaceTable.getModel();
        String[] columnNames = {"Data", "Emri", "Pozicionet e para", "Ekipi", "Piket"};
        allRaceTableModel.setColumnIdentifiers(columnNames);

        for (int i = 0; i < MenaxhimKampionatiFormula1.GaraF1.size(); i++)
        {
            LocalDate date = MenaxhimKampionatiFormula1.GaraF1.get(i).getDate();

            for (int j = 0; j < MenaxhimKampionatiFormula1.GaraF1.get(i).getDriverPositions().size(); j++)
            {
                Object[] data =
                        {date,
                                MenaxhimKampionatiFormula1.GaraF1.get(i).getDriverPositions().get(j).getEmri(),
                                (j+1),
                                MenaxhimKampionatiFormula1.GaraF1.get(i).getDriverPositions().get(j).getEkipi(),
                                MenaxhimKampionatiFormula1.GaraF1.get(i).getDriverPositions().get(j).getDriverPoints()
                        };
                allRaceTableModel.addRow(data);
            }
        }

        tableSorter(allRaceTable, 0, "A");
        allRaceTable.setBackground(Color.gray);
        allRaceTable.setEnabled(false);
        scrollPane3 = new JScrollPane(allRaceTable);
        scrollPane3.setBounds(40,100,860,385);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    /*
     * Inicializojme JPanels
     */

    public void panels() {
        // Create and configure the layered pane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 960, 618);

        // Top panel with a lighter shade of blue
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(173, 216, 230)); // Light blue
        topPanel.setPreferredSize(new Dimension(1280, 150));
        topPanel.add(label1);

        // Left panel with a medium shade of blue
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(100, 149, 237)); // Cornflower blue
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(320, 100));
        leftPanel.add(searchField);
        leftPanel.add(searchButton);
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);

        // Middle panel with a dark blue shade
        midPanel = new JPanel();
        midPanel.setLayout(null);
        midPanel.setBackground(new Color(0, 0, 128)); // Navy blue
        midPanel.setPreferredSize(new Dimension(960, 618));
        midPanel.add(layeredPane);

        // Panel1 with a light blue gradient
        panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(135, 206, 250), 0, getHeight(), new Color(70, 130, 180));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 960, 618);
        panel1.add(label2);
        panel1.add(pointsAscButton);
        panel1.add(fposDscButton);
        panel1.add(button5);
        panel1.add(scrollPane1);
        layeredPane.add(panel1);

        // Panel2 with a slightly darker blue
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(70, 130, 180)); // Steel blue
        panel2.setBounds(0, 0, 960, 618);
        layeredPane.add(panel2);

        // Panel3 with a similar shade to panel2 but with different hue
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(0, 191, 255)); // Deep sky blue
        panel3.setBounds(0, 0, 960, 618);
        layeredPane.add(panel3);

        // Panel4 with a gradient of blue
        panel4 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 255, 255), 0, getHeight(), new Color(0, 128, 128));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel4.setLayout(null);
        panel4.setBounds(0, 0, 960, 618);
        layeredPane.add(panel4);

        // Search panel with a soft blue background
        searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(new Color(176, 224, 230)); // Powder blue
        searchPanel.setBounds(0, 0, 960, 618);
        layeredPane.add(searchPanel);
    }



    public void switchPanels(JPanel panel)
    {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();

    }

    /*
     * Rendisim kolonat e tabeles ne rendin zbrites(Descending) dhe rrites (Ascending)
     */

    public void tableSorter(JTable table, int index, String order)
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = index;

        if (order.equals("A"))
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        else
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();

    }

    /**
     * Generates random drivers for random positions
     * @param button The clicked button
     */
    public void randomDriverGenerator(int button)
    {
        raceDriversData.removeAll(raceDriversData);

        for (int i = 0; i < 10; i++)
        {
            int random = (int) ((Math.random()*(MenaxhimKampionatiFormula1.ShoferiF1.size()-1))+0);
            ShoferiFormula1 driver = MenaxhimKampionatiFormula1.ShoferiF1.get(random);

            if (!raceDriversData.contains(driver))
            {
                raceDriversData.add(driver);
            }

            else
                i--;
        }

        if (button == 6)
            completedRace();
        else if (button == 7)
            newRace();

    }

//gjeneron data random

    public void randomDateGenerator()
    {
        Random random = new Random();
        int startDay = (int) LocalDate.of(2018, 1, 1).toEpochDay();
        int endDay = (int) LocalDate.now().toEpochDay();
        long randomDay = startDay + random.nextInt(endDay - startDay);

        randomRaceDate = LocalDate.ofEpochDay(randomDay);

    }

}
