package Level;

import Cards.CardHandler;
import Entity.*;
import main.ArtLoader;
import main.*;

import java.awt.*;

public class Level2 extends BaseLevel
{
    public Level2(LevelHandler LevelH, TurnHandler turnH)
    {
        super(LevelH, turnH, 100);
        energyReplenishAmount = 3;
        this.LevelH = LevelH;
        this.turnH = turnH;
    }

    @Override
    public void updateLevel(Graphics2D g2, TurnHandler turnH)
    {
        if (initialized)
        {
            renderBackground(g2);
            CH.renderDeck(g2); //renders the hand always
            CH.handleCardBounds(g2); //renders collision boxes
            turnH.renderTurnButton(g2);
            enemy.healthBar.renderHealthBar(enemy.maxHealth, enemy.health, enemy.block, g2, false, -30, 13, ArtLoader.smallPerfectFont);
            player.healthBar.renderHealthBar(player.maxHealth, player.health, player.block, g2, true, 30, 13, ArtLoader.smallPerfectFont);
        }
    }

    @Override
    public void init(int playerStartingHealth)
    {
        player = new Entity(playerStartingHealth, 100, 0, "Player");
        enemy = new Entity(500, 500, 50, "C-Plus-Plus");
        enemyAI = new CPlusEnemyAI(player, enemy, LevelH);

        CH = new CardHandler(player, enemy, LevelH,5);

        turnH.endEnemyTurn();

        initialized = true;
    }

    public void renderBackground(Graphics2D g2)
    {
        g2.drawImage(ArtLoader.level1Background, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
    }
}
