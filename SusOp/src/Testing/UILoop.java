package Testing;

import Data.Device;
import Networking.NetworkDevices;
import UI.HomeScreen;
import UI.ListRenderer;

import java.util.LinkedList;
import java.util.List;

public class UILoop extends Thread
{
    List<Device> devices;
    ListRenderer list;
    HomeScreen homeScreen;

    public UILoop(List<Device> devices, ListRenderer list, HomeScreen homeScreen)
    {
        this.devices = devices;
        this.list = list;
        this.homeScreen = homeScreen;
    }

    public void run()
    {
        while (true)
        {
            List<Device> currentDevices = NetworkDevices.getInstance().getDevices();

            List<Device> added = new LinkedList<Device>();
            for (Device d : currentDevices)
            {
                if (!devices.contains(d))
                {
                    added.add(d);

                    list.addElement(d);
                }
            }
            for (Device d : added)
            {
                devices.add(d);
            }

            List<Device> removed = new LinkedList<Device>();
            for (Device d : devices)
            {
                if (!currentDevices.contains(d))
                {
                    //devices.remove(d);
                    removed.add(d);

                    list.removeElement(d);
                }
            }

            for(Device d : removed)
            {
                devices.remove(d);
            }

            try
            {
                sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println("Crashed Ping Loop");
            }

            NetworkDevices nd = NetworkDevices.getInstance();
            homeScreen.setStatistics
                    (
                        Math.round(nd.getAvgOfWatt()),     Math.round(nd.getSumOfWatt()),
                        Math.round(nd.getAvgOfWattHour()), Math.round(nd.getSumOfWattHour()),
                        Math.round(nd.getAvgOfCo2()),      Math.round(nd.getSumOfCo2())
                    );

            homeScreen.repaint();
            homeScreen.revalidate();

            list.repaint();
            list.revalidate();
        }
    }
}

