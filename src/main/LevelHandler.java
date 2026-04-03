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
        player = new Entity(50, 0);
        enemy = new Entity(100, 50);
        turnH = new TurnHandler();

        CH = new CardHandler(player, enemy, turnH);
        CH.buildDeck(6);
    }

    public void updateLevel(Graphics2D g2)
    {
        CH.renderDeck(g2); //renders the hand always
        CH.handleCardBounds(g2); //renders collision boxes
        turnH.renderTurnButton(g2);
        enemy.healthBar.renderHealthBar(enemy.maxHealth, enemy.health, enemy.block, g2, false, -10, 40);
        player.healthBar.renderHealthBar(player.maxHealth, player.health, player.block, g2, true, 10, 40);
    }



}
