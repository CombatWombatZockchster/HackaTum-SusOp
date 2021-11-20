package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel
{
    public JPanel homeScreen, listScreen, settingsScreen;

    public SideBar()
    {
        setBackground(Style.midgroundColor);

        setSize(new Dimension(Window.width/10, Window.height));
        setMinimumSize(new Dimension(Window.width/20, Window.height/3));
        setPreferredSize(new Dimension(Window.width/15, Window.height));

        Dimension minFiller = new Dimension(0, 0);
        Dimension prefFiller = new Dimension(32, 32);
        Dimension maxFiller = new Dimension(64, 64);

        Box.Filler emptySpace1 = new Box.Filler(minFiller, prefFiller,maxFiller);
        Box.Filler emptySpace2 = new Box.Filler(minFiller, prefFiller,maxFiller);
        Box.Filler emptySpace3 = new Box.Filler(minFiller, prefFiller,maxFiller);


        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        ImageIcon mainIcon = ImageLoader.loadImage("logoClear.png");
        if(mainIcon != null)
        {
            //Rescale
            mainIcon = ImageLoader.resizeIcon(mainIcon, 72, 72);

            JLabel iconWrapper = new JLabel("");
            iconWrapper.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            iconWrapper.setIcon(mainIcon);


            add( new Box.Filler(new Dimension(8,8), new Dimension(16,16),new Dimension(32, 32)));

            add(iconWrapper);
        }

        JButton homeButton = new JButton();
        JButton listButton = new JButton();
        JButton settingsButton = new JButton();

        homeButton.setBackground(Style.midgroundColor);
        listButton.setBackground(Style.midgroundColor);
        settingsButton.setBackground(Style.midgroundColor);

        homeButton.setOpaque(false);
        listButton.setOpaque(false);
        settingsButton.setOpaque(false);
        /*
        homeButton.setForeground(Style.backgroundColor);
        listButton.setForeground(Style.backgroundColor);
        graphButton.setForeground(Style.backgroundColor);
        */
        UIManager.put("Button.select", Style.highLightColor);

        homeButton.setBorder(null);
        listButton.setBorder(null);
        settingsButton.setBorder(null);

        homeButton.setBorderPainted(false);
        listButton.setBorderPainted(false);
        settingsButton.setBorderPainted(false);

        ImageIcon homeIcon = ImageLoader.loadImage("home.png");
        ImageIcon listIcon = ImageLoader.loadImage("list.png");
        ImageIcon settingsIcon = ImageLoader.loadImage("gear.png");

        if(homeIcon != null)
        {
            homeIcon = ImageLoader.resizeIcon(homeIcon, 32, 32);
            homeButton.setIcon(homeIcon);
        }
        if(listIcon != null)
        {
            listIcon = ImageLoader.resizeIcon(listIcon, 32, 32);
            listButton.setIcon(listIcon);
        }
        if(settingsIcon != null)
        {
            settingsIcon = ImageLoader.resizeIcon(settingsIcon, 32, 32);
            settingsButton.setIcon(settingsIcon);
        }


        Border border = homeButton.getBorder();
        Border offset = new EmptyBorder(32, 32, 32, 32);
        CompoundBorder margin = new CompoundBorder(border, offset);

        homeButton.setBorder(margin);
        listButton.setBorder(margin);
        settingsButton.setBorder(margin);

        homeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        listButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);


        homeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window.getInstance().setScreen(homeScreen);
                    }
                }
        );

        listButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window.getInstance().setScreen(listScreen);
                    }
                }
        );

        settingsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window.getInstance().setScreen(settingsScreen);
                    }
                }
        );

        add(emptySpace1);
        add(homeButton);

        add(emptySpace2);
        add(listButton);

        add(emptySpace3);
        add(settingsButton);
    }
}
