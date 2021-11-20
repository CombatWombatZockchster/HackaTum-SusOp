package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

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
        background.setBackground(Style.midgroundColor);
        background.setLayout(new FlowLayout());

        add(background, BorderLayout.CENTER);


        //Table
        JPanel center = new JPanel();
        center.setBackground(Style.midgroundColor);

        background.add(center);

        center.setLayout(new GridLayout(4, 3));
        //center.setPreferredSize(new Dimension(Window.width/4, Window.height/4));

        JLabel statLabel = new JLabel("Statistics");
        JLabel avgLabel = new JLabel("Average");
        JLabel totalLabel = new JLabel("Total");
        JLabel co2Label = new JLabel("CO2");
        JLabel wattLabel = new JLabel("Wattage");
        JLabel wattHourLabel = new JLabel("Watt Hours");

        statLabel.setForeground(Style.textColor);
        avgLabel.setForeground(Style.textColor);
        totalLabel.setForeground(Style.textColor);
        co2Label.setForeground(Style.textColor);
        wattLabel.setForeground(Style.textColor);
        wattHourLabel.setForeground(Style.textColor);

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

        //Graph

        //JPanel graphWrapper =

        LineGraph lineGraph = new LineGraph();
        HashMap<Integer, Integer> graphData = new HashMap<Integer, Integer>();
        Random random = new Random();
        for(int i = 0; i < 10; i++)
        {
            graphData.put(i, random.nextInt());
        }
        lineGraph.setData(graphData);

    }

    public void setStatistics(long avgWatt, long totalWatt, long avgWattHour, long totalWattHour, long avgCO2, long totalCO2)
    {
        this.avgWatt.setText("" + avgWatt + " W");
        this.totalWatt.setText("" + totalWatt + " W");
        this.avgWattHour.setText("" + avgWatt + " Wh");
        this.totalWattHour.setText("" + avgWatt + " Wh");
        this.avgCo2.setText("" + avgCO2 + " g");
        this.totalCo2.setText("" + totalCO2 + " g");
    }
}
