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
    public static BufferedImage parryArt;
    public static BufferedImage javaArt;
    public static BufferedImage infiniteArt;
    public static BufferedImage firewallArt;
    public static BufferedImage memoryArt;

    public static Font perfectFont;
    public static Font smallPerfectFont;


    public static void load() throws IOException, FontFormatException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try
        {
            cardArt = ImageIO.read(new File("cardAssets/card2.png"));
            parryArt = ImageIO.read(new File("cardAssets/parry.png"));
            javaArt = ImageIO.read(new File("cardAssets/java.png"));
            infiniteArt = ImageIO.read(new File("cardAssets/infinite.png"));
            firewallArt = ImageIO.read(new File("cardAssets/firewall.png"));
            memoryArt = ImageIO.read(new File("cardAssets/memory.png"));



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
