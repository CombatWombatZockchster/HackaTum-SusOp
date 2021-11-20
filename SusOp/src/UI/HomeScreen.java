package UI;

import Networking.NetworkDevices;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class HomeScreen extends JPanel
{
    JLabel titleLabel;

    JLabel avgCo2;
    JLabel totalCo2;
    JLabel avgWatt;
    JLabel totalWatt;
    JLabel avgWattHour;
    JLabel totalWattHour;

    LineGraph lineGraph = new LineGraph();


    public HomeScreen()
    {
        setLayout(new BorderLayout());
        setBackground(Style.backgroundColor);


        //Title
        titleLabel = new JLabel();

        titleLabel.setText("Overview");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setBackground(Style.accentColor);
        titleLabel.setForeground(Style.backgroundColor);
        titleLabel.setOpaque(true);

        Border border = titleLabel.getBorder();
        Border offset = new EmptyBorder(16, 64, 16, 64);
        CompoundBorder margin = new CompoundBorder(border, offset);
        titleLabel.setBorder(margin);

        add(titleLabel, BorderLayout.PAGE_START);

        //Margins
        Box.Filler emptySpaceLeft = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        Box.Filler emptySpaceRight = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        add(emptySpaceLeft, BorderLayout.LINE_START);
        add(emptySpaceRight, BorderLayout.LINE_END);

        JPanel background = new JPanel();
        background.setBackground(Style.backgroundColor);
        //background.setLayout(new BorderLayout());
        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));

        add(background, BorderLayout.CENTER);


        //Table
        JPanel center = new JPanel();
        center.setBackground(Style.midgroundColor);
        //center.setPreferredSize(new Dimension(Window.width/2, Window.height/3));

        Box.Filler emptySpaceTop = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        background.add(emptySpaceTop);

        background.add(center);

        center.setLayout(new GridLayout(4, 3));
        //center.setPreferredSize(new Dimension(Window.width/4, Window.height/4));

        JLabel statLabel = new JLabel("Statistics");
        JLabel avgLabel = new JLabel("Average");
        JLabel totalLabel = new JLabel("Total");
        JLabel co2Label = new JLabel("CO2");
        JLabel wattLabel = new JLabel("Wattage");
        JLabel wattHourLabel = new JLabel("Watt Hours");

        statLabel.setForeground(Style.backgroundColor);
        avgLabel.setForeground(Style.backgroundColor);
        totalLabel.setForeground(Style.backgroundColor);
        co2Label.setForeground(Style.backgroundColor);
        wattLabel.setForeground(Style.backgroundColor);
        wattHourLabel.setForeground(Style.backgroundColor);

        statLabel.setBackground(Style.accentColor);
        avgLabel.setBackground(Style.accentColor);
        totalLabel.setBackground(Style.accentColor);
        co2Label.setBackground(Style.accentColor);
        wattLabel.setBackground(Style.accentColor);
        wattHourLabel.setBackground(Style.accentColor);

        statLabel.setOpaque(true);
        avgLabel.setOpaque(true);
        totalLabel.setOpaque(true);
        co2Label.setOpaque(true);
        wattLabel.setOpaque(true);
        wattHourLabel.setOpaque(true);


        avgCo2 = new JLabel();
        totalCo2 = new JLabel();
        avgWatt = new JLabel();
        totalWatt = new JLabel();
        avgWattHour = new JLabel();
        totalWattHour = new JLabel();

        avgCo2.setForeground(Style.textColor);
        totalCo2.setForeground(Style.textColor);
        avgWatt.setForeground(Style.textColor);
        totalWatt.setForeground(Style.textColor);
        avgWattHour.setForeground(Style.textColor);
        totalWattHour.setForeground(Style.textColor);

        Dimension cellSize = new Dimension(Window.width/16, Window.height/16);
        avgCo2.setPreferredSize(cellSize);
        totalCo2.setPreferredSize(cellSize);
        avgWatt.setPreferredSize(cellSize);
        totalWatt.setPreferredSize(cellSize);
        avgWattHour.setPreferredSize(cellSize);
        totalWattHour.setPreferredSize(cellSize);


        statLabel.setHorizontalAlignment(JLabel.CENTER);
        avgLabel.setHorizontalAlignment(JLabel.CENTER);
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        co2Label.setHorizontalAlignment(JLabel.CENTER);
        wattLabel.setHorizontalAlignment(JLabel.CENTER);
        wattHourLabel.setHorizontalAlignment(JLabel.CENTER);


        avgCo2.setHorizontalAlignment(JLabel.CENTER);
        totalCo2.setHorizontalAlignment(JLabel.CENTER);
        avgWatt.setHorizontalAlignment(JLabel.CENTER);
        totalWatt.setHorizontalAlignment(JLabel.CENTER);
        avgWattHour.setHorizontalAlignment(JLabel.CENTER);
        totalWattHour.setHorizontalAlignment(JLabel.CENTER);

        center.add(statLabel);
        center.add(avgLabel);
        center.add(totalLabel);

        center.add(wattLabel);
        center.add(avgWatt);
        center.add(totalWatt);

        center.add(wattHourLabel);
        center.add(avgWattHour);
        center.add(totalWattHour);

        center.add(co2Label);
        center.add(avgCo2);
        center.add(totalCo2);



        //--- System Information ---

        JPanel information = new JPanel();
        information.setBackground(Style.midgroundColor);
        information.setLayout(new GridLayout(3, 2));
        //information.setPreferredSize(new Dimension(Window.width/4, Window.height/4));

        Box.Filler emptySpaceTop2 = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        background.add(emptySpaceTop2);

        background.add(information, BorderLayout.CENTER);

        JLabel systemSpecs = new JLabel("System");
        JLabel empty = new JLabel("");

        empty.setForeground(Style.backgroundColor);
        systemSpecs.setForeground(Style.backgroundColor);
        systemSpecs.setBackground(Style.accentColor);
        empty.setBackground(Style.accentColor);
        systemSpecs.setOpaque(true);
        empty.setOpaque(true);


        systemSpecs.setPreferredSize(cellSize);
        empty.setPreferredSize(cellSize);
        systemSpecs.setHorizontalAlignment(JLabel.CENTER);
        empty.setHorizontalAlignment(JLabel.CENTER);

        information.add(systemSpecs);
        information.add(empty);

        JLabel empty2 = new JLabel("");
        empty2.setBackground(Style.accentColor);
        empty2.setOpaque(true);
        information.add(empty2);

        JLabel userName = new JLabel("User:");
        JLabel name = new JLabel(System.getProperty("user.name"));

        userName.setForeground(Style.backgroundColor);
        name.setForeground(Style.textColor);
        userName.setBackground(Style.accentColor);
        name.setBackground(Style.midgroundColor);
        userName.setOpaque(true);
        name.setOpaque(true);

        userName.setPreferredSize(cellSize);
        name.setPreferredSize(cellSize);
        userName.setHorizontalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.LEFT);

        information.add(userName);

        JLabel empty3 = new JLabel("");
        empty3.setBackground(Style.midgroundColor);
        information.add(empty3);

        information.add(name);

        JLabel ipAddress = new JLabel("IPv4:");
        JLabel address = new JLabel("");
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            address = new JLabel(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ipAddress.setForeground(Style.backgroundColor);
        address.setForeground(Style.textColor);
        ipAddress.setBackground(Style.accentColor);
        address.setBackground(Style.midgroundColor);
        ipAddress.setOpaque(true);
        address.setOpaque(true);

        ipAddress.setPreferredSize(cellSize);
        address.setPreferredSize(cellSize);
        ipAddress.setHorizontalAlignment(JLabel.CENTER);
        address.setHorizontalAlignment(JLabel.CENTER);
        address.setHorizontalAlignment(JLabel.LEFT);

        information.add(ipAddress);

        JLabel empty4 = new JLabel("");
        empty4.setBackground(Style.midgroundColor);
        information.add(empty4);

        information.add(address);



        //Graph

        Box.Filler emptySpaceTop3 = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        background.add(emptySpaceTop3);

        JPanel graphWrapper = new JPanel();
        graphWrapper.setLayout(new BorderLayout());

        background.add(graphWrapper);

        JLabel graphTitle = new JLabel("Cuncurrent Devices");
        graphTitle.setForeground(Style.backgroundColor);
        graphTitle.setHorizontalAlignment(JLabel.CENTER);
        graphTitle.setBackground(Style.accentColor);
        graphTitle.setOpaque(true);
        graphTitle.setPreferredSize(new Dimension(getWidth(), 32));
        graphWrapper.add(graphTitle, BorderLayout.PAGE_START);

        LineGraph lineGraph = new LineGraph();
        graphWrapper.add(lineGraph, BorderLayout.CENTER);



        //Dummy Data
        /*
        HashMap<Integer, Integer> graphData = new HashMap<Integer, Integer>();
        Random random = new Random();
        for(int i = 0; i < 100; i++)
        {
            //graphData.put(i, random.nextInt());
            graphData.put(i, i % 10 + random.nextInt(10));
        }
        */
        LinkedHashMap<Integer, Integer> graphData = NetworkDevices.getInstance().getGraphData();
        graphData.put(0, 0);
        lineGraph.setData(graphData);


        Box.Filler emptySpaceTop4 = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        background.add(emptySpaceTop4);
    }


    public void setStatistics(long avgWatt, long totalWatt, long avgWattHour, long totalWattHour, long avgCO2, long totalCO2)
    {
        this.avgWatt.setText("" + avgWatt + " W");
        this.totalWatt.setText("" + totalWatt + " W");
        this.avgWattHour.setText("" + avgWatt + " Wh");
        this.totalWattHour.setText("" + avgWatt + " Wh");
        this.avgCo2.setText("" + avgCO2 + " g");
        this.totalCo2.setText("" + totalCO2 + " g");

        LinkedHashMap<Integer, Integer> graphData = NetworkDevices.getInstance().getGraphData();
        graphData.put(0, 0);
        lineGraph.setData(graphData);
    }
}
