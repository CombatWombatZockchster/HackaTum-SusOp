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
    public DeviceRenderer()
    {
        setOpaque(true);

        Border border = getBorder();
        Border offset = new EmptyBorder(16, 16, 16, 16);
        CompoundBorder margin = new CompoundBorder(border, offset);
        setBorder(margin);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Device> list, Device value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String iconPath = "question.png";
        switch (value.type)
        {
            case MOBILE:
                iconPath = "smartphone.png";
                break;
            case DESKTOP:
                iconPath = "desktop-pc.png";
                break;
            default:
                iconPath = "question.png";
                break;
        }

        ImageIcon icon = ImageLoader.loadImage(iconPath).get();
        icon = ImageLoader.resizeIcon(icon, 64, 64);

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
            setBackground(Style.highLightColor);
            setForeground(Style.backgroundColor);
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
