package UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Window
{
    private JFrame frame;

    private int width=1920, height=1080;
    private int screenSizeFraction = 2;

    private String title = "SusOp";

    private Container currentScreen = null;


    public Window()
    {
        //Creation
        frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Window Size handling
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize);
        Dimension minScreenSize = new Dimension(width/screenSizeFraction, height/screenSizeFraction);
        frame.setMinimumSize(minScreenSize);


        //Style
        frame.getContentPane().setBackground(Style.backgroundColor);

        //Now show it to the world
        frame.setVisible(true);
    }

    /*
    //Lets try to properly wrap this
    public JFrame getFrame()
    {
        return frame;
    }
    */

    public void setIcon(String path)
    {
        ImageIcon icon = ImageLoader.loadImage(path).get();
        if(icon != null)
            frame.setIconImage(icon.getImage());
    }

    public void setScreen(JPanel content)
    {
        if(currentScreen != null)
            frame.remove(currentScreen);

        currentScreen = content;
        frame.add(content);
        frame.pack();
    }
}
