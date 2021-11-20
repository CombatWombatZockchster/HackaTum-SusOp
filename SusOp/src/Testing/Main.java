package Testing;

import Data.Device;
import Data.DeviceType;
import UI.ListRenderer;
import UI.Style;
import UI.Window;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Window window = new Window();
        window.setIcon("logo.png");


        ListRenderer list = new ListRenderer();

        /*
        //Add dummy devices
        Device[] devices = new Device[10];
        for(int i = 0; i < 2; i++)
        {
            String name = "Test Device " + (i+1);
            DeviceType type = DeviceType.values()[new Random().nextInt(DeviceType.values().length)];
            devices[i] = new Device(name, type);

            list.addElement(devices[i]);
        }
        */


        JPanel screen = new JPanel();
        screen.add(list, BorderLayout.LINE_START);
        screen.setBackground(Style.backgroundColor);

        window.setScreen(screen);




        //Test code to add real devices
        InetAddress localhost = InetAddress.getLocalHost();
        byte[] ip = localhost.getAddress();

        for (int i = 0; i <= 254; i++)
        {
            final int m = i;
            new Thread(new Runnable()
            {
                public void run() {
                    ip[3] = (byte) m;
                    try
                    {
                        InetAddress address = InetAddress.getByAddress(ip);
                        if (address.isReachable(1000))
                        {
                            Device device = new Device(" Test Name", DeviceType.DESKTOP, address);
                            list.addElement(device);
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                }
            }).start();
        }
    }
}
