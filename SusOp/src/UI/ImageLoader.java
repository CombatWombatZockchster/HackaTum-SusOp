package UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Optional;

public class ImageLoader
{
    //Load images from resource folder
    public static Optional<ImageIcon> loadImage(String path)
    {
        try
        {
            URL url = Window.class.getClassLoader().getResource(path);
            ImageIcon image = new ImageIcon(url);

            return Optional.of(image);
        }
        catch (Exception e)
        {
            System.out.println("Coudlnt read icon " + path + " from resources. Caused error: " + e);

            return Optional.empty();
        }
    }
}
