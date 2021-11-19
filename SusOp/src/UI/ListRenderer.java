package UI;

import Data.Device;

import javax.swing.*;
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

        scrollP = new JScrollPane(deviceJList);
        scrollP.setBackground(Style.midgroundColor);

        scrollP.getVerticalScrollBar().setBackground(Style.midgroundColor);
        //scrollP.getVerticalScrollBar().setForeground(Style.accentColor);
        scrollP.getVerticalScrollBar().setOpaque(false);

        add(scrollP);

        //Style
        setBackground(Style.backgroundColor);

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
