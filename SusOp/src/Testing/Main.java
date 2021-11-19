package Testing;

import Data.Device;
import Data.DeviceType;
import UI.ListRenderer;
import UI.Style;
import UI.Window;

import javax.swing.*;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Window window = new Window();

        window.setIcon("logo.png");

        //JPanel testPanel = new JPanel();
        //testPanel.setBackground(Style.backgroundColor);

        ListRenderer list = new ListRenderer();



        Device[] devices = new Device[10];
        for(int i = 0; i < 10; i++)
        {
            String name = "Device " + (i+1);
            DeviceType type = DeviceType.values()[new Random().nextInt(DeviceType.values().length)];
            devices[i] = new Device(name, type);

            list.addElement(devices[i]);
        }

        window.setScreen(list);

    }
}
