package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArtLoader
{
    public static BufferedImage cardArt;
    public static BufferedImage endTurnArt;

    public static void load()
    {

        try
        {
            cardArt = ImageIO.read(new File("cardAssets/card2.png"));

            endTurnArt = ImageIO.read(new File("UIAssets/endturn.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}
