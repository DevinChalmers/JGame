package Level;

import Cards.CardHandler;
import Cards.CardInitializer;
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


    public BaseLevel(LevelHandler LevelH, TurnHandler turnH)
    {

    }


    public void updateLevel(Graphics2D g2, TurnHandler turnH)
    {
        if (initialized)
        {

        }
    }


    public void init()
    {

    }
}
