package UI;

import Data.Device;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.LinkedList;


//https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
public class ListRenderer extends JPanel
{
    //LinkedList<Device> devices = new LinkedList<Device>();
    DefaultListModel<Device> listModel = new DefaultListModel<Device>();

    JList<Device> deviceJList;
    JScrollPane scrollP;

    String title = "Devices";
    JLabel titleLabel;

    public ListRenderer()
    {
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setLayout(new BorderLayout());

        Box.Filler emptySpaceLeft = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        Box.Filler emptySpaceRight = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        add(emptySpaceLeft, BorderLayout.LINE_START);
        add(emptySpaceRight, BorderLayout.LINE_END);


        setBackground(Style.backgroundColor);
        setBorder(null);
        setOpaque(true);


        setSize(new Dimension(Window.width/5, Window.height));
        setMinimumSize(new Dimension(Window.width/4, Window.height/5));
        setMaximumSize(new Dimension(Window.width, Window.height));
        setPreferredSize(new Dimension(Window.width/3*2, Window.height));

        //Title

        titleLabel = new JLabel();

        titleLabel.setText(title);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setBackground(Style.accentColor);
        titleLabel.setForeground(Style.backgroundColor);
        titleLabel.setOpaque(true);

        Border border = titleLabel.getBorder();
        Border offset = new EmptyBorder(16, 64, 16, 64);
        CompoundBorder margin = new CompoundBorder(border, offset);
        titleLabel.setBorder(margin);

        add(titleLabel, BorderLayout.PAGE_START);


        //List

        deviceJList = new JList<>(listModel);
        deviceJList.setCellRenderer(new DeviceRenderer());

        deviceJList.setBackground(Style.backgroundColor);
        deviceJList.setBorder(null);

        scrollP = new JScrollPane(deviceJList);
        scrollP.setBackground(Style.midgroundColor);
        scrollP.setBorder(null);
        scrollP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollP.setPreferredSize(null);


        //Make it Scrollable
        JScrollBar scrollBar = scrollP.getVerticalScrollBar();
        scrollBar.setBackground(Style.midgroundColor);
        scrollBar.setForeground(Style.accentColor);
        scrollBar.setUI(new BasicScrollBarUI()
        {
            @Override
            protected void configureScrollBarColors()
            {
                setBackground(Style.backgroundColor);
                setForeground(Style.backgroundColor);
                thumbColor = Style.accentColor;
            }

            @Override
            protected JButton createDecreaseButton(int orientation)
            {
                JButton me = super.createDecreaseButton(orientation);
                me.setBackground(Style.midgroundColor);
                return me;
            }

            @Override
            protected JButton createIncreaseButton(int orientation)
            {
                JButton me = super.createDecreaseButton(orientation);
                me.setBackground(Style.midgroundColor);
                return me;
            }
        });

        add(scrollP, BorderLayout.CENTER);

        /*
        Border border = getBorder();
        Border offset = new EmptyBorder(32, 32, 32, 32);
        CompoundBorder margin = new CompoundBorder(border, offset);
        setBorder(margin);
        */

        setVisible(true);
    }

    @Override
    public void repaint()
    {
        super.repaint();

        if(deviceJList != null)
        {
            deviceJList.repaint();
            deviceJList.revalidate();
        }
       //if(scrollP != null) scrollP.repaint();
       //if(titleLabel != null) titleLabel.repaint();
    }

    public void addElement(Device device)
    {
        //devices.add(device);
        listModel.addElement(device);

        //FIXME: list size needs to look somewhat sensible
        deviceJList.setPreferredSize(null);
        scrollP.setPreferredSize(null);
        setPreferredSize(null);

        setMinimumSize(new Dimension(16, Window.height));
    }

    public void removeElement(Device device)
    {
        listModel.removeElement(device);
    }
}
