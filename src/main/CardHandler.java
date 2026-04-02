package main;
import Cards.Card;
import Cards.CardArt;


import java.awt.*;
import java.util.ArrayList;

public class CardHandler
{
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<Rectangle> cardBounds = new ArrayList<>(); //this handles card interaction with mouse

    public void handleCardBounds(Graphics2D g2)
    {
        cardBounds.clear(); //clears every frame

        for (int i = 0; i < cards.size(); i++)
        {
            int x = calculateCardX(i);
            int y = calculateCardY(i);

            cardBounds.add(new Rectangle(x, y, cards.get(i).cardW, cards.get(i).cardH)); //creates inv rectangle to use as collision

            g2.setColor(Color.red); //debugging visuals
            for (Rectangle r : cardBounds) {
                g2.drawRect(r.x, r.y, r.width, r.height);
            }
        }
    }

    public void buildDeck()
    {
        cards.add(new Card("Slash", "attack", 10, CardArt.shield));
        cards.add(new Card("Slash", "attack", 10, CardArt.shield));
        cards.add(new Card("Slash", "attack", 10, CardArt.shield));

    }

    public void renderDeck(Graphics2D g2)
    {
        for (int i = 0; i < cards.size(); i++)
        {
            cards.get(i).drawToScreen(
                    g2,
                    cards.get(i),
                    calculateCardX(i),
                    calculateCardY(i)); //cards take the last 4th of the screen by default
        }
    }

    public int calculateCardX(int i)
    {
        return (GamePanel.screenWidth - (cards.size() * cards.get(i).cardW)) / 2 + (i * cards.get(i).cardW);
    }

    public int calculateCardY(int i)
    {
        return GamePanel.screenHeight - GamePanel.screenHeight / cards.get(i).y;
    }
}
