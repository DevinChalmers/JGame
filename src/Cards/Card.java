package Cards;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Card
{
    public int x = 0 , y = 4; //y works by how close to the bottom

    //public int speed;

    public BufferedImage sprite;
    public String name;
    public String type;
    public int value;

    public int cardWbyPixels = 73;
    public int cardHbyPixels = 103;

    public int cardW = cardWbyPixels * GamePanel.scale - GamePanel.shrinkCards;
    public int cardH = cardWbyPixels * GamePanel.scale - GamePanel.shrinkCards;

    public Card(String name, String type, int value, BufferedImage sprite)
    {
        this.name = name;
        this.type = type;
        this.value= value;
        this.sprite = sprite;
    }

    public void drawToScreen(Graphics2D g2, Card card, int x, int y)
    {

        int drawY = y; //add hover

        if (card.sprite != null)
        {
            g2.drawImage(card.sprite, x, drawY, cardW, cardH, null);
        }
        else
        {
            System.out.println("Not found");
            System.out.println(CardArt.class.getResource("/"));
        }

    }

    public void cardAction()
    {
        
    }
    
    

}
