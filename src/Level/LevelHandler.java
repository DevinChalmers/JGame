package Level;

import main.ArtLoader;
import main.TurnHandler;

import java.awt.*;

public class LevelHandler
{
    public TurnHandler turnH;

    public BaseLevel currentLevel;
    public StartMenu startMenu;
    public Level1 Level1;
    public Level2 Level2;

    public LevelHandler()
    {
        turnH = new TurnHandler(this);
        Level1 = new Level1(this, turnH);
        startMenu = new StartMenu(this, turnH);
        Level2 = new Level2(this, turnH);
        currentLevel = startMenu;
        currentLevel.init(100);
    }

    public void renderLevel(Graphics2D g2) throws InterruptedException
    {
        currentLevel.updateLevel(g2, turnH);
        currentLevel.checkEndGame();
        if (currentLevel.enemyAI != null)
        {
            currentLevel.enemyAI.renderOpponentDecision(g2, ArtLoader.perfectFont);
        }
    }





}
