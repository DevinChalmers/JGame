package Cards;
import main.ArtLoader;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import Entity.*;

public class Card
{
    double defaultY = 3.65;
    public double x = 0 , y = defaultY; //y works by how close to the bottom

    public BufferedImage sprite;
    public String name;
    public String type;
    public int value;

    public boolean Hovered = false;

    public int cardWbyPixels = 73;
    public int cardHbyPixels = 103;

    public int cardW = (cardWbyPixels * GamePanel.scaleWindow - GamePanel.shrinkCards);
    public int cardH = (cardHbyPixels * GamePanel.scaleWindow - GamePanel.shrinkCards);

    public Card(String name, String type, int value, BufferedImage sprite)
    {
        this.name = name;
        this.type = type;
        this.value= value;
        this.sprite = sprite;
    }

    public void drawToScreen(Graphics2D g2, Card card, int x, int y)
    {

        if (card.sprite != null)
        {
            g2.drawImage(card.sprite, x, y, cardW, cardH, null);
        }
        else
        {
            System.out.println("Not found");
            System.out.println(ArtLoader.class.getResource("/"));
        }

    }

    public void cardAction(Entity player, Entity enemy)
    {
        //insert card actions
    }

}
