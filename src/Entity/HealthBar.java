package Entity;

import main.ArtLoader;
import main.GamePanel;
import main.TextRenderer;

import java.awt.*;

public class HealthBar
{
    Entity entity;

    public HealthBar(Entity entity)
    {
        this.entity = entity;
    }

    public void renderHealthBar(int maxHealth, int health, int block, Graphics2D g2, boolean topLeft, int shiftRight, int shiftDown, Font font)
    {
        int x = 0;
        int y = 0;
        double percentHealth = ((double)health / (double)maxHealth);
        double percentShield= ((double)block / (double)maxHealth);

        shiftDown *= GamePanel.scaleWindow;
        shiftRight *= GamePanel.scaleWindow;

        double widthOfBar = (GamePanel.screenWidth / 3.2);
        int blockWidth = (int)(percentShield * widthOfBar);
        int heightOfBar = 13 * GamePanel.scaleWindow;

        if (topLeft)
        {
            x = GamePanel.screenWidth - (2 * (GamePanel.screenWidth / 2)) + shiftRight;
            y = GamePanel.screenHeight - (2 * (GamePanel.screenHeight / 2)) + shiftDown;
        }
        else
        {
            x = GamePanel.screenWidth - (int) (widthOfBar) + shiftRight;
            y = GamePanel.screenHeight - (2 * (GamePanel.screenHeight / 2)) + shiftDown;
        }

        //render max health bar
        g2.setColor(Color.darkGray);
        g2.fillRect(x, y, (int)widthOfBar, heightOfBar );

        //render health bar
        g2.setColor(Color.red);
        g2.fillRect(x, y, (int)(percentHealth * widthOfBar), heightOfBar );

        //render shield bar
        g2.setColor(Color.cyan);
        g2.fillRect(x, y, blockWidth, heightOfBar);

        String healthString = String.valueOf(health + "/" + maxHealth);
        String shieldString = String.valueOf(block);

        FontMetrics fm = g2.getFontMetrics(font);
        int yCorrection = -2; //in pixels


        //render health amount
        TextRenderer.renderText(g2, healthString, font, Color.white, x + (int)(widthOfBar/2 - fm.stringWidth(healthString)/2),  y + fm.getAscent()/2 + heightOfBar/2 + yCorrection);

        int iconWH = (int) (20 * GamePanel.scaleWindow);


        //render block amount
        if (block > 0)
        {
            if (!topLeft)
            {
                //draw shield icon
                int blockX = (int) (GamePanel.screenWidth - (int)(widthOfBar) - iconWH*1.45);
                int blockY = y + fm.getAscent()/2 - iconWH/3;
                g2.drawImage(ArtLoader.shieldArt, blockX, blockY, iconWH, iconWH, null);
                //TextRenderer.renderText(g2, shieldString, font, Color.white, (int)(blockX + fm.stringWidth(shieldString)/2), blockY + fm.getAscent() + 10);
                TextRenderer.renderText(g2, shieldString, font, Color.white, (int)(blockX + (iconWH - fm.stringWidth(shieldString))/2), blockY + (iconWH + fm.getAscent())/2 - 5);
            }
            if (topLeft)
            {
                //draw shield icon
                int blockX = GamePanel.screenWidth - (int) (GamePanel.screenWidth - iconWH * 1.45 + iconWH);
                int blockY = y + fm.getAscent()/2 - iconWH/3;
                g2.drawImage(ArtLoader.shieldArt, blockX, blockY, iconWH, iconWH, null);
                TextRenderer.renderText(g2, shieldString, font, Color.white, (int)(blockX + (iconWH - fm.stringWidth(shieldString))/2), blockY + (iconWH + fm.getAscent())/2 - 5);
            }

        }

    }
}
