package UI;

import Data.Device;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.LinkedList;


//https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
public class ListRenderer extends JPanel
{
    //LinkedList<Device> devices = new LinkedList<Device>();
    DefaultListModel<Device> listModel = new DefaultListModel<Device>();

    JList<Device> deviceJList;
    JScrollPane scrollP;

    public ListRenderer()
    {
        deviceJList = new JList<>(listModel);
        deviceJList.setCellRenderer(new DeviceRenderer());

        setBackground(Style.backgroundColor);

        scrollP = new JScrollPane(deviceJList);
        scrollP.setBackground(Style.midgroundColor);

        JScrollBar scrollBar = scrollP.getVerticalScrollBar();
        scrollBar.setBackground(Style.midgroundColor);
        scrollBar.setForeground(Style.accentColor);
        scrollBar.setUI(new BasicScrollBarUI()
        {
            @Override
            protected void configureScrollBarColors()
            {
                setBackground(Style.backgroundColor);
                setForeground(Style.backgroundColor);
                thumbColor = Style.accentColor;
            }

            @Override
            protected JButton createDecreaseButton(int orientation)
            {
                JButton me = super.createDecreaseButton(orientation);
                me.setBackground(Style.midgroundColor);
                return me;
            }

            @Override
            protected JButton createIncreaseButton(int orientation)
            {
                JButton me = super.createDecreaseButton(orientation);
                me.setBackground(Style.midgroundColor);
                return me;
            }
        });

        add(scrollP);

        /*
        Border border = getBorder();
        Border offset = new EmptyBorder(32, 32, 32, 32);
        CompoundBorder margin = new CompoundBorder(border, offset);
        setBorder(margin);
        */

        setVisible(true);
    }

    public void addElement(Device device)
    {
        //devices.add(device);
        listModel.addElement(device);
    }

    public void removeElement(Device device)
    {
        listModel.removeElement(device);
    }
}
