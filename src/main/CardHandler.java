package main;
import Cards.Card;
import Cards.CardArt;


import java.awt.*;
import java.util.ArrayList;

public class CardHandler
{
    ArrayList<Card> cards = new ArrayList<>();


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
                    (int) ((GamePanel.screenWidth - (cards.size() * cards.get(i).cardW)) /2 + (i * cards.get(i).cardW)),
                    GamePanel.screenHeight - GamePanel.screenHeight / cards.get(i).y); //cards take the last 4th of the screen by default
        }
    }
}
