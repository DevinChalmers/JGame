/*
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class Shield extends Card
{
    GamePanel gp;
    KeyHandler KeyH;


    public Shield(GamePanel gp, KeyHandler KeyH)
    {
        //super();
        this.gp = gp;
        //this. KeyH = KeyH;
        setDefaultValues();
    }

    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        //speed = 6;
    }

    public void getImage()
    {
        try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream(""));
        }
        catch(IOException e)
        {
            e.printStackTrace(); //what is this
        }
    }

    public void update()
    {
        /*
        if(KeyH.upPressed)
        {
            y -= speed;
        }
        else if(KeyH.rightPressed)
        {
            x += speed;
        }
        else if(KeyH.downPressed)
        {
            y += speed;
        }
        else if(KeyH.leftPressed)
        {
            x -= speed;
        }


    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }


}
*/