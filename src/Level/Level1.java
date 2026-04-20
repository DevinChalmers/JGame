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
        enemy = new Entity(250, 250, 50, "Python", this);
        enemyAI = new PythonEnemyAI(player, enemy, LevelH);

        CH = new CardHandler(player, enemy, LevelH, 5);

        turnH.endEnemyTurn();

        initialized = true;
    }






    //RENDERING BACKGROUND
    public void renderBackground(Graphics2D g2)
    {
        frameCount++;

        if (frameCount >= 60)
        {
            frameStatus = !frameStatus;
            frameCount = 0;
            canGetFrameCount = true;
        }

        if (frameStatus && !enemyHit)
        {
            g2.drawImage(ArtLoader.pythonFrame1, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null); //idleframe
        }
        else if (!frameStatus && !enemyHit)
        {
            g2.drawImage(ArtLoader.pythonFrame2, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null); //idleframe2
        }
        else
        {
            g2.drawImage(ArtLoader.pythonFrameHit, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null); //hit frame
            getPreviousFrameCount();

            if (frameCount >= previousframeCount + 5)
            {
                enemyHit = false;
            }
            else
            {
                System.out.println(previousframeCount);
            }

        }
    }

    int previousframeCount;
    boolean canGetFrameCount = true;
    public void getPreviousFrameCount()
    {
        if (canGetFrameCount)
        {
            previousframeCount = frameCount;
            canGetFrameCount = false;
        }
    }

    @Override
    public void checkEndGame()
{
    if (player != null && player.health <= 0)
    {
        System.exit(0); //closes game
    }
    if (player != null && enemy.health <= 0)
    {
        LevelH.currentLevel = LevelH.Level2;
        LevelH.currentLevel.init(player.health);
    }
}

}
