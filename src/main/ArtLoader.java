package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class ArtLoader
{
    public static BufferedImage cardArt;
    public static BufferedImage endTurnArt;
    public static BufferedImage logoArt;
    public static BufferedImage shieldArt;
    public static BufferedImage parryArt;
    public static BufferedImage javaArt;
    public static BufferedImage infiniteArt;
    public static BufferedImage firewallArt;
    public static BufferedImage memoryArt;
    public static BufferedImage segfaultArt;
    public static BufferedImage compileArt;
    public static BufferedImage pingArt;
    public static BufferedImage polyArt;


    public static BufferedImage seaFrame1;
    public static BufferedImage seaFrame2;
    public static BufferedImage seaFrameHit;

    public static BufferedImage pythonFrame1;
    public static BufferedImage pythonFrame2;
    public static BufferedImage pythonFrameHit;

    public static Clip shieldSound;
    public static Clip cardHover;
    public static Clip attackSound;
    public static Clip skillSound;
    public static Clip enemyHurtSound;
    public static Clip playerHurtSound;
    public static Clip noEnergySound;

    public static Font perfectFont;
    public static Font smallPerfectFont;

    public static void load() throws IOException, FontFormatException
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try
        {
            cardArt = ImageIO.read(new File("cardAssets/card2.png"));
            parryArt = ImageIO.read(new File("cardAssets/parry.png"));
            javaArt = ImageIO.read(new File("cardAssets/java.png"));
            infiniteArt = ImageIO.read(new File("cardAssets/infinite.png"));
            firewallArt = ImageIO.read(new File("cardAssets/firewall.png"));
            memoryArt = ImageIO.read(new File("cardAssets/memory.png"));
            segfaultArt = ImageIO.read(new File("cardAssets/segfault.png"));
            pingArt = ImageIO.read(new File("cardAssets/ping.png"));
            compileArt = ImageIO.read(new File("cardAssets/compile.png"));
            polyArt = ImageIO.read(new File("cardAssets/poly.png"));

            cardHover = loadSound("SoundEffects/cardHover.wav");
            attackSound = loadSound("SoundEffects/attack.wav");
            shieldSound = loadSound("SoundEffects/shield.wav");
            skillSound = loadSound("SoundEffects/skill.wav");
            enemyHurtSound = loadSound("SoundEffects/hithurt.wav");
            playerHurtSound = loadSound("SoundEffects/playerhurt.wav");
            noEnergySound = loadSound("SoundEffects/energysound.wav");

            pythonFrame1 = ImageIO.read(new File("UIAssets/pythonframe1.png"));
            pythonFrame2 = ImageIO.read(new File("UIAssets/pythonframe2.png"));
            pythonFrameHit = ImageIO.read(new File("UIAssets/pythonframehit3.png"));
            seaFrame1 = ImageIO.read(new File("UIAssets/seaframe1.png"));
            seaFrame2 = ImageIO.read(new File("UIAssets/seaframe2.png"));
            seaFrameHit = ImageIO.read(new File("UIAssets/seaframehit.png"));

            endTurnArt = ImageIO.read(new File("UIAssets/endturn.png"));
            shieldArt = ImageIO.read(new File("UIAssets/shield.png"));
            logoArt = ImageIO.read(new File("UIAssets/logo.png"));

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        perfectFont = Font.createFont(Font.TRUETYPE_FONT, new File("UIAssets/fonts/Perfect.ttf")).deriveFont(10f * GamePanel.scaleWindow);
        smallPerfectFont = Font.createFont(Font.TRUETYPE_FONT, new File("UIAssets/fonts/Perfect.ttf")).deriveFont(9.35f * GamePanel.scaleWindow);

        ge.registerFont(perfectFont);


    }

    private static Clip loadSound(String path) throws Exception
    {
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        return clip;
    }

    public static void playSound(Clip clip, float volume)
    {
        if (clip == null) return;
        clip.setFramePosition(0);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume);
        clip.start();
    }


}
