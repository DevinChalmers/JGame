package main;

//import Cards.Card;

import Level.LevelHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable
{
    public static final int scaleWindow = 3; //USE THIS TO SCALE WINDOW (RECOMMENDED = 3)

    public static final int screenWidth = 450 * scaleWindow;  //tileSize * maxScreenCol;
    public static final int screenHeight = 250 * scaleWindow;  //tileSize * maxScreenRow;

    final int fps = 60;
    
    LevelHandler LevelH;

    Thread gameThread;

    public GamePanel() throws IOException, FontFormatException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        ArtLoader.load(); //load all card art
        LevelH = new LevelHandler(); //sets up level handler

        MouseListener MouseH = new MouseListener(this);
        this.addMouseListener(MouseH); // click events
        this.addMouseMotionListener(MouseH);
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

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR); //makes pixel art correct

        try
        {
            LevelH.renderLevel(g2);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        g2.dispose();
    }

    public void startGameThread() //handles game rendering loop
    {
        gameThread = new Thread(this);
        gameThread.start();
    }



}
