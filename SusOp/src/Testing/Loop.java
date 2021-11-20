package Testing;

import Data.Device;
import Networking.NetworkDevices;
import UI.ListRenderer;

import java.util.List;

public class Loop extends Thread
{
    List<Device> devices;
    ListRenderer list;

    public Loop(List<Device> devices, ListRenderer list)
    {
        this.devices = devices;
        this.list = list;
    }

    public void run()
    {
        while (true)
        {
            List<Device> currentDevices = NetworkDevices.getInstance().getDevices();

            for (Device d : currentDevices)
            {
                if (!devices.contains(d))
                {
                    devices.add(d);

                    list.addElement(d);
                }
            }

            try
            {
                sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println("Crashed Ping Loop");
            }

            list.repaint();
            list.revalidate();
        }
    }
}

