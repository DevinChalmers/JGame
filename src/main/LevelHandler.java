package main;

import java.awt.*;

public class LevelHandler
{
    CardHandler CH = new CardHandler();

    public LevelHandler()
    {
        CH.buildDeck();
    }

    public void updateLevel(Graphics2D g2)
    {
        CH.renderDeck(g2);
        CH.handleCardBounds(g2); //renders the hand always
    }



}
