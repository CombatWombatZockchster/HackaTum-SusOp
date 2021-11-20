package UI;

import Data.Device;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
public class DeviceRenderer extends JLabel implements ListCellRenderer<Device>
{
    JLabel iconWrapper;
    JLabel name;
    JLabel ip;
    JLabel time;
    JLabel wattage;
    JLabel wattHour;
    JLabel co2;

    /*
    Dimension minFiller = new Dimension(0, 0);
    Dimension prefFiller = new Dimension(32, 32);
    Dimension maxFiller = new Dimension(64, 64);

    Box.Filler emptySpace1 = new Box.Filler(minFiller, prefFiller,maxFiller);
    Box.Filler emptySpace2 = new Box.Filler(minFiller, prefFiller,maxFiller);
    Box.Filler emptySpace3 = new Box.Filler(minFiller, prefFiller,maxFiller);
    */

    public DeviceRenderer()
    {
        setOpaque(true);

        Border border = getBorder();
        Border offset = new EmptyBorder(16, 16, 16, 16);
        CompoundBorder margin = new CompoundBorder(border, offset);
        setBorder(margin);

        /*
        JLabel iconWrapper = new JLabel("");
        add(iconWrapper);

        JLabel name = new JLabel("");
        add(name);

        JLabel ip = new JLabel("");
        add(ip);
        */
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Device> list, Device value, int index, boolean isSelected, boolean cellHasFocus)
    {
        setMinimumSize(new Dimension(Window.width/10, 64));
        setPreferredSize(new Dimension(Window.width/2, 72));

        //BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
        //setLayout(layout);
        setLayout(new GridLayout(1, 7));

        String iconPath = "question.png";
        switch (value.type)
        {
            case DESKTOP:
                iconPath = "desktop-pc.png";
                break;
            case PHONE:
                iconPath = "smartphone.png";
                break;
            case LAPTOP:
                iconPath = "laptop.png";
                break;
            case ROUTER:
                iconPath = "wlan-router.png";
                break;
            case PRINTER:
                iconPath = "printing.png";
                break;
            case LIGHTBULB:
                iconPath = "bulb.png";
                break;
            case OTHER:
                iconPath = "question.png";
                break;
            default:
                iconPath = "question.png";
                break;
        }

        ImageIcon icon = ImageLoader.loadImage(iconPath);
        icon = ImageLoader.resizeIcon(icon, 32, 32);


        if(iconWrapper == null)
        {
            iconWrapper = new JLabel("");
            iconWrapper.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            add(iconWrapper);

            //add(emptySpace1);
        }

        if(name == null)
        {
            name = new JLabel("");
            add(name);

            //add(emptySpace2);
        }

        if(ip == null)
        {
            ip = new JLabel("");
            add(ip);
        }

        if(time == null)
        {
            time = new JLabel("");
            add(time);
        }

        if(wattage == null)
        {
            wattage = new JLabel("");
            add(wattage);
        }

        if(wattHour == null)
        {
            wattHour = new JLabel("");
            add(wattHour);
        }

        if(co2 == null)
        {
            co2 = new JLabel("");
            add(co2);
        }

        iconWrapper.setIcon(icon);

        name.setText(value.name);

        ip.setText(value.address);

        time.setText(value.upTimeToString());

        wattage.setText("" + value.getWattage() +" W");

        Double wh = Device.getWattHour(value.getWattage(), value.getLifeTime());
        wattHour.setText("" + Math.round(wh) + " Wh");

        String c = "" + Math.round(Device.getCO2(wh)) + " g";
        co2.setText(c);

        if(!isSelected && !cellHasFocus)
        {
            setBackground(Style.midgroundColor);
            //setForeground(Style.textColor);

            ip.setForeground(Style.textColor);
            name.setForeground(Style.textColor);
            time.setForeground(Style.textColor);
            wattage.setForeground(Style.textColor);
            wattHour.setForeground(Style.textColor);
            co2.setForeground(Style.textColor);
        }
        else if(isSelected)
        {
            setBackground(Style.highLightColor);
            //setForeground(Style.backgroundColor);

            ip.setForeground(Style.backgroundColor);
            name.setForeground(Style.backgroundColor);
            time.setForeground(Style.backgroundColor);
            wattage.setForeground(Style.backgroundColor);
            wattHour.setForeground(Style.backgroundColor);
            co2.setForeground(Style.backgroundColor);
        }
        /*
        else if(cellHasFocus)
        {
            setBackground(Style.accentColor);
            setForeground(Style.backgroundColor);
        }
        */

        return this;
    }
}
