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
        player = new Entity(50, 2);
        enemy = new Entity(500, 500);
        turnH = new TurnHandler();

        CH = new CardHandler(player, enemy, turnH);
        CH.buildDeck(6);
    }

    public void updateLevel(Graphics2D g2)
    {
        CH.renderDeck(g2); //renders the hand always
        CH.handleCardBounds(g2); //renders collision boxes
        turnH.renderTurnButton(g2);
        enemy.healthBar.renderHealthBar(enemy.maxHealth, enemy.health, enemy.block, g2, false, -18, 13, ArtLoader.smallPerfectFont);
        player.healthBar.renderHealthBar(player.maxHealth, player.health, player.block, g2, true, 18, 13, ArtLoader.smallPerfectFont);
        //TextRenderer.renderText(g2, "Player", ArtLoader.perfectFont, Color.white, 200, 200);
    }



}
