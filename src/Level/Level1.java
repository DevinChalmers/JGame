package Level;

import Cards.CardHandler;
import Entity.*;
import main.*;

import java.awt.*;

public class Level1 extends BaseLevel
{


    public Level1(LevelHandler LevelH, TurnHandler turnH)
    {
        super(LevelH, turnH, 100);
        energyReplenishAmount = 4;
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
        enemy = new Entity(250, 250, 50, "Python");
        enemyAI = new PythonEnemyAI(player, enemy, LevelH);

        CH = new CardHandler(player, enemy, LevelH, 5);

        turnH.endEnemyTurn();

        initialized = true;
    }

    public void renderBackground(Graphics2D g2)
    {
        g2.drawImage(ArtLoader.level2Background, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
    }
}
