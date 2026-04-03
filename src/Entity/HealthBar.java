package Entity;

import main.GamePanel;

import java.awt.*;

public class HealthBar
{
    int health;
    Entity entity;
    //int shiftRight = 20;
    //int shiftDown = 40;
    double pixelPerHP = 1.7;

    public HealthBar(Entity entity)
    {
        this.entity = entity;
    }

    public void renderHealthBar(int maxHealth, int health, int block, Graphics2D g2, boolean topLeft, int shiftRight, int shiftDown)
    {
        int x = 0;
        int y = 0;
        double percentHealth = (double) health / maxHealth;
        double percentShield= (double) block / maxHealth;

        int width = GamePanel.screenWidth / 4;

        if (topLeft)
        {
            x = GamePanel.screenWidth - (2 * (GamePanel.screenWidth / 2)) + shiftRight;
            y = GamePanel.screenHeight - (2 * (GamePanel.screenHeight / 2)) + shiftDown;
        }
        else
        {
            x = GamePanel.screenWidth - (int) (width) + shiftRight;
            y = GamePanel.screenHeight - (2 * (GamePanel.screenHeight / 2)) + shiftDown;
        }

        
        //render max health bar
        g2.setColor(Color.darkGray);
        g2.fillRect(x, y, width, 30 );

        //render health bar
        g2.setColor(Color.red);
        g2.fillRect(x, y, (int)(percentHealth * width), 30 );

        //render shield bar
        g2.setColor(Color.cyan);
        g2.fillRect(x, y, (int)(percentShield * width), 30 );

        //System.out.println((double) health / maxHealth);
    }
}
