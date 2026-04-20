package Level;

import Cards.CardHandler;
import Entity.Entity;
import Entity.PythonEnemyAI;
import main.ArtLoader;
import main.GamePanel;
import main.TurnHandler;

import java.awt.*;

public class StartMenu extends BaseLevel
{


    public StartMenu(LevelHandler LevelH, TurnHandler turnH)
    {
        super(LevelH, turnH, 100);
    }

    int logoWidth = 225 * GamePanel.scaleWindow;
    int logoHeight = 45 * GamePanel.scaleWindow;
    int textWidth = 150 * GamePanel.scaleWindow;
    int textHeight = 30 * GamePanel.scaleWindow;
    @Override
    public void updateLevel(Graphics2D g2, TurnHandler turnH)
    {
        g2.drawImage(ArtLoader.logoArt, GamePanel.screenWidth - GamePanel.screenWidth/2 - logoWidth/2, GamePanel.screenHeight/3 - logoHeight, logoWidth, logoHeight ,null);
        g2.drawImage(ArtLoader.menuTextArt, GamePanel.screenWidth/2 - textWidth/2, GamePanel.screenHeight - GamePanel.screenHeight/3, textWidth, textHeight ,null);
    }

    @Override
    public void init(int playerStartingHealth)
    {
        initialized = true;
    }






    //RENDERING BACKGROUND
    public void renderBackground(Graphics2D g2)
    {

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

}
