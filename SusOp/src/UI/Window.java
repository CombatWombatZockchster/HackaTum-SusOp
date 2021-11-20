package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

public class Window
{
    private JFrame frame;

    public static int width=1920, height=1080;
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
        width = screenSize.width;
        height = screenSize.height;
        Dimension minScreenSize = new Dimension(width/screenSizeFraction, height/screenSizeFraction);
        frame.setMinimumSize(minScreenSize);


        //Style
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Style.backgroundColor);


        SideBar sideBar = new SideBar();
        frame.add(sideBar, BorderLayout.LINE_START);

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
        ImageIcon icon = ImageLoader.loadImage(path);
        if(icon != null)
            frame.setIconImage(icon.getImage());
    }

    public void setScreen(JPanel content)
    {
        if(currentScreen != null)
            frame.remove(currentScreen);

        currentScreen = content;
        frame.add(content, BorderLayout.CENTER);
        frame.pack();
    }
}
