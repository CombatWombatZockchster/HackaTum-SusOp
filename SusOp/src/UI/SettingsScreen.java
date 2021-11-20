package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SettingsScreen extends JPanel
{
    JLabel titleLabel;
    JComboBox powerSelect;

    public SettingsScreen()
    {
        setLayout(new BorderLayout());
        setBackground(Style.backgroundColor);

        titleLabel = new JLabel();

        titleLabel.setText("Settings");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setBackground(Style.accentColor);
        titleLabel.setForeground(Style.backgroundColor);
        titleLabel.setOpaque(true);

        Border border = titleLabel.getBorder();
        Border offset = new EmptyBorder(16, 64, 16, 64);
        CompoundBorder margin = new CompoundBorder(border, offset);
        titleLabel.setBorder(margin);

        add(titleLabel, BorderLayout.PAGE_START);


        Box.Filler emptySpaceLeft = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        Box.Filler emptySpaceRight = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        add(emptySpaceLeft, BorderLayout.LINE_START);
        add(emptySpaceRight, BorderLayout.LINE_END);

        //Debug Values
        JPanel selection = new JPanel();
        selection.setBackground(Style.midgroundColor);

        JLabel sourceTitle = new JLabel("Power Source:");
        //sourceTitle.setBackground(Style.accentColor);
        sourceTitle.setForeground(Style.textColor);
        sourceTitle.setOpaque(false);

        selection.add(sourceTitle, BorderLayout.LINE_START);

        Box.Filler emptySpace = new Box.Filler(new Dimension(8,8), new Dimension(16,16), new Dimension(32,32));
        selection.add(emptySpace, BorderLayout.PAGE_START);

        String sources[] = {"Wind", "Gas", "Coal", "Nuclear", "Solar"};

        powerSelect = new JComboBox(sources);

        //powerSelect.setMaximumSize(new Dimension(Window.width/4, Window.height/4));
        //powerSelect.setPreferredSize(new Dimension(Window.width/8, Window.height/8));

        powerSelect.setBackground(Style.midgroundColor);
        powerSelect.setForeground(Style.textColor);
        powerSelect.setBorder(null);

        selection.add(powerSelect, BorderLayout.CENTER);

        add(selection, BorderLayout.CENTER);
    }
}
