package main;

//import Cards.Card;
import Cards.CardArt;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    static final int originalTileSize = 76; //16x16 tile
    public static final int scale = 3;


    public static final int shrinkCards = 0; //by pixel

    public static final int tileSize = originalTileSize * scale; //40 x 40
    //final int maxScreenCol = 16;
    //final int maxScreenRow = 12;

    public static final int screenWidth = 450 * scale;  //tileSize * maxScreenCol;
    public static final int screenHeight = 250 * scale;  //tileSize * maxScreenRow;

    final int fps = 60;
    
    LevelHandler LevelH;
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;

    public GamePanel ()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);

        CardArt.load();
        LevelH = new LevelHandler();
    }

    @Override
    public void run() //handles screen rendering and timer
    {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        double lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null)
        {
            //TimeLoop (how does this work)
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
            }
        }
    }


    public void update()
    {

    }

    public void paintComponent(Graphics g) //what is this
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //what is this

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        LevelH.updateLevel(g2);

        g2.dispose();

    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }



}
