package Level;

import main.ArtLoader;
import main.TurnHandler;

import java.awt.*;

public class LevelHandler
{
    public TurnHandler turnH;

    public BaseLevel currentLevel;
    public Level1 Level1;
    public Level2 Level2;

    public LevelHandler()
    {
        turnH = new TurnHandler(this);
        Level1 = new Level1(this, turnH);
        Level2 = new Level2(this, turnH);
        currentLevel = Level1;
        currentLevel.init(100);
    }

    public void renderLevel(Graphics2D g2)
    {
        currentLevel.updateLevel(g2, turnH);
        currentLevel.checkEndGame();
        currentLevel.enemyAI.renderOpponentDecision(g2, ArtLoader.perfectFont);
    }





}
