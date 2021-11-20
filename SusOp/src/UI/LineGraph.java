package UI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static java.util.Comparator.*;

//https://stackoverflow.com/questions/8693342/drawing-a-simple-line-graph-in-java
public class LineGraph extends JPanel
{
    private HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public LineGraph()
    {
        setBackground(Style.backgroundColor);
    }

    public void setData(HashMap data)
    {
        this.data = data;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        double xMul = (double) getWidth() / (double) data.size();
        double yMul = (double) getHeight() / (double) (data.values().stream().max(Comparator.<Integer>naturalOrder()).get());

        List<Point> points = new ArrayList<Point>();

        for (int key : data.keySet())
        {
            int x = (int) (key * xMul);
            int y = (int) (data.get(key) * yMul);

            points.add(new Point(x, y));
        }

        g2D.setColor(Style.highLightColor);
        for(int i = 0; i < points.size()-1; i++)
        {
            Point a = points.get(i);
            Point b = points.get(i+1);
            g2D.drawLine(a.x, a.y, b.x, b.y);
        }
    }
}
