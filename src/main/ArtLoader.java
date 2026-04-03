package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArtLoader
{
    public static BufferedImage cardArt;
    public static BufferedImage endTurnArt;
    public static BufferedImage shieldArt;

    public static Font perfectFont;
    public static Font smallPerfectFont;


    public static void load() throws IOException, FontFormatException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try
        {
            cardArt = ImageIO.read(new File("cardAssets/card2.png"));
            endTurnArt = ImageIO.read(new File("UIAssets/endturn.png"));
            shieldArt = ImageIO.read(new File("UIAssets/shield.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }


        perfectFont = Font.createFont(Font.TRUETYPE_FONT, new File("UIAssets/fonts/Perfect.ttf")).deriveFont(10f * GamePanel.scaleWindow);
        smallPerfectFont = Font.createFont(Font.TRUETYPE_FONT, new File("UIAssets/fonts/Perfect.ttf")).deriveFont(9.35f * GamePanel.scaleWindow);

        ge.registerFont(perfectFont);






    }


}
