package Cards;
import main.ArtLoader;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import Entity.*;

public class Card
{
    double defaultY = 4.25;
    public double x = 0 , y = defaultY; //y works by how close to the bottom

    public BufferedImage sprite;
    public String name;
    public String type;
    public int value;
    public CardHandler CH;
    public int energyCost;

    public boolean Hovered = false;

    public int cardWbyPixels = 73;
    public int cardHbyPixels = 103;
    public int shrinkWithSize = 0;

    //73x103

    //public int cardW = (cardWbyPixels * GamePanel.scaleWindow - GamePanel.finalShrinkCards);
    //public int cardH = (cardHbyPixels * GamePanel.scaleWindow - GamePanel.finalShrinkCards);

    public Card(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        this.name = name;
        this.type = type;
        this.energyCost = energyCost;
        this.sprite = sprite;
        this.CH = CH;
    }

    public void drawToScreen(Graphics2D g2, Card card, int x, int y, int cardW, int cardH, CardHandler CH)
    {
        cardW = CH.getDynamicCardWidth();
        cardH = (int)(cardW * 1.5f); // maintain aspect ratio

        if (CH.hand.size() == 7) //work on this
        {
            shrinkWithSize = 50;
        }

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
