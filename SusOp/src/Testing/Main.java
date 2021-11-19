package Testing;

import Data.Device;
import UI.ListRenderer;
import UI.Style;
import UI.Window;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        Window window = new Window();

        window.setIcon("logo.png");

        //JPanel testPanel = new JPanel();
        //testPanel.setBackground(Style.backgroundColor);

        ListRenderer list = new ListRenderer();

        window.setScreen(list);


        Device[] devices = new Device[10];
        for(int i = 0; i < 10; i++)
        {
            devices[i] = new Device("Device " + (i+1));
            list.addElement(devices[i]);
        }


    }
}
