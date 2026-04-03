package main;

import java.awt.*;

import Cards.CardHandler;
import Cards.CardInitializer;
import Entity.Entity;

public class LevelHandler
{
    Entity enemy;
    Entity player;
    CardHandler CH;
    CardInitializer CK = new CardInitializer();
    TurnHandler turnH;


    public LevelHandler()
    {
        player = new Entity(100, 0);
        enemy = new Entity(250, 50);
        turnH = new TurnHandler();

        CH = new CardHandler(player, enemy, turnH);
        CH.buildDeck();
    }

    public void updateLevel(Graphics2D g2)
    {
        CH.renderDeck(g2); //renders the hand always
        CH.handleCardBounds(g2); //renders collision boxes
        turnH.renderTurnButton(g2);
    }



}
