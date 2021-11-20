package Testing;

import Data.Device;
import Networking.NetworkPing;
import UI.*;
import UI.Window;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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

        HomeScreen homeScreen = new HomeScreen();

        JPanel settingsScreen = new SettingsScreen();

        JPanel listScreen = list;//new JPanel();
        //listScreen.add(list, BorderLayout.LINE_START);
        //listScreen.setBackground(Style.backgroundColor);

        window.sideBar.homeScreen = homeScreen;
        window.sideBar.settingsScreen = settingsScreen;
        window.sideBar.listScreen = listScreen;

        window.setScreen(listScreen);

        List<Device> devices = new LinkedList<Device>();
        NetworkPing.getAllDevices();

        new UILoop(devices, list, homeScreen).start();
        new UtilityLoop().start();
    }
}