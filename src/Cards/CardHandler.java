package Cards;
import java.awt.*;
import java.util.ArrayList;

import main.GamePanel;

public class CardHandler
{
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Rectangle> cardBounds = new ArrayList<>(); //this handles card interaction with mouse

    public void handleCardBounds(Graphics2D g2)
    {
        cardBounds.clear(); //clears every frame

        for (int i = 0; i < hand.size(); i++)
        {
            int x = calculateCardX(i);
            int y = calculateCardY(i);

            cardBounds.add(new Rectangle(x, y, hand.get(i).cardW, hand.get(i).cardH)); //creates inv rectangle to use as collision

            g2.setColor(Color.red); //debugging visuals
            for (Rectangle r : cardBounds) {
                g2.drawRect(r.x, r.y, r.width, r.height);
            }
        }
    }

    public void buildDeck()
    {/*
        for (int i = 0; i < 5; i++)
        {
            hand.add(new CardKeeper().randomCard());
        }
     */
    }

    public void renderDeck(Graphics2D g2)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            hand.get(i).drawToScreen(
                    g2,
                    hand.get(i),
                    calculateCardX(i),
                    calculateCardY(i)); //cards take the last 4th of the screen by default
        }
    }

    public int calculateCardX(int i)
    {
        return (GamePanel.screenWidth - (hand.size() * hand.get(i).cardW)) / 2 + (i * hand.get(i).cardW);
    }

    public int calculateCardY(int i)
    {
        return GamePanel.screenHeight - GamePanel.screenHeight / hand.get(i).y;
    }

    public void checkCardClick(int mouseX, int mouseY)
    {
        for (int i = 0; i < cardBounds.size(); i++)
        {
            if (cardBounds.get(i).contains(mouseX, mouseY))
            {
                hand.get(i).cardAction();
                hand.remove(i); //removes card from hand after click
            }
        }
    }
}
