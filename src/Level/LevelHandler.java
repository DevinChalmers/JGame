package Level;

import main.TurnHandler;

import java.awt.*;

public class LevelHandler
{
    /*
    Entity enemy;
    Entity player;
    CardHandler CH;
    CardInitializer CK = new CardInitializer();
    public TurnHandler turnH;
    public OpponentAI basicAI;

    int level = 1;
    */
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
        currentLevel.init();



        /*
        player = new Entity(50, 2);
        enemy = new Entity(200, 50);
        turnH = new TurnHandler(this);
        basicAI = new OpponentAI(player, enemy);

        CH = new CardHandler(player, enemy, this);

        turnH.endEnemyTurn();

        */
    }

    public void renderLevel(Graphics2D g2)
    {
        currentLevel.updateLevel(g2, turnH);

        /*
        CH.renderDeck(g2); //renders the hand always
        CH.handleCardBounds(g2); //renders collision boxes
        turnH.renderTurnButton(g2);
        enemy.healthBar.renderHealthBar(enemy.maxHealth, enemy.health, enemy.block, g2, false, -30, 13, ArtLoader.smallPerfectFont);
        player.healthBar.renderHealthBar(player.maxHealth, player.health, player.block, g2, true, 30, 13, ArtLoader.smallPerfectFont);
        //TextRenderer.renderText(g2, "Player", ArtLoader.perfectFont, Color.white, 200, 200);

        */
    }





}
