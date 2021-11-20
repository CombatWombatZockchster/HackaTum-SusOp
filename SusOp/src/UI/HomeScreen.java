package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeScreen extends JPanel
{
    JLabel titleLabel;

    public HomeScreen()
    {
        setLayout(new BorderLayout());
        setBackground(Style.backgroundColor);


        //Title
        titleLabel = new JLabel();

        titleLabel.setText("Your Device");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setBackground(Style.accentColor);
        titleLabel.setForeground(Style.backgroundColor);
        titleLabel.setOpaque(true);

        Border border = titleLabel.getBorder();
        Border offset = new EmptyBorder(16, 64, 16, 64);
        CompoundBorder margin = new CompoundBorder(border, offset);
        titleLabel.setBorder(margin);

        add(titleLabel, BorderLayout.PAGE_START);

        //Margins
        Box.Filler emptySpaceLeft = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        Box.Filler emptySpaceRight = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        add(emptySpaceLeft, BorderLayout.LINE_START);
        add(emptySpaceRight, BorderLayout.LINE_END);

        JPanel center = new JPanel();
        center.setBackground(Style.midgroundColor);

        add(center, BorderLayout.CENTER);
    }
}
