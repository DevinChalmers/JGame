package Cards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardArt
{
    public static BufferedImage shield;

    public static void load()
    {

        try
        {
            shield = ImageIO.read(new File("cardAssets/card2.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}
