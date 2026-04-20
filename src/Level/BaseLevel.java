package Level;

import Cards.CardHandler;
import Entity.*;
import main.*;

import java.awt.*;

public class BaseLevel
{
    public int energyReplenishAmount;
    public Entity enemy;
    public Entity player;
    public CardHandler CH;
    //CardInitializer CK = new CardInitializer(this);
    public OpponentAI enemyAI;
    LevelHandler LevelH;
    TurnHandler turnH;
    public boolean initialized;
    public int playerStartingHealth = 100;

    public boolean enemyHit;
    public int frameCount = 0;
    public boolean frameStatus;


    public BaseLevel(LevelHandler LevelH, TurnHandler turnH, int playerStartingHealth)
    {

    }


    public void updateLevel(Graphics2D g2, TurnHandler turnH)
    {
        if (initialized)
        {

        }
    }


    public void init(int playerStartingHealth)
    {

    }

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

    public void renderBackground(Graphics2D g2) throws InterruptedException
    {

    }


}
