package UI;

import Data.Device;

import javax.swing.*;
import java.awt.*;

//https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
public class DeviceRenderer extends JLabel implements ListCellRenderer<Device>
{
    public DeviceRenderer()
    {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Device> list, Device value, int index, boolean isSelected, boolean cellHasFocus)
    {
        //TODO: handle different types here
        ImageIcon icon = ImageLoader.loadImage("desktop-pc.png").get();
        icon = new ImageIcon(icon.getImage().getScaledInstance(64,64, Image.SCALE_DEFAULT));

        if(icon != null)
            setIcon(icon);
        else
            System.out.println("Couldnt load Icon desktop-pc.png");

        setText(value.name);

        if(!isSelected && !cellHasFocus)
        {
            setBackground(Style.midgroundColor);
            setForeground(Style.textColor);
        }
        else if(isSelected)
        {
            setBackground(Style.accentColor);
            setForeground(Style.highLightColor);
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
