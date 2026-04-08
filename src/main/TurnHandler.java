package main;

import Level.LevelHandler;

import java.awt.*;


public class TurnHandler
{
    public boolean playerTurn = true;
    boolean enemyTurn = false;
    float buttonX;
    float buttonY;
    int widthInPixels = 73;
    int heightInPixels= 26;
    int buttonW = widthInPixels * GamePanel.scaleWindow;
    int buttonH = heightInPixels * GamePanel.scaleWindow;
    Rectangle buttonBox;
    LevelHandler LH;


    public TurnHandler(LevelHandler LH)
    {
        this.LH = LH;
        buttonX = (float) (GamePanel.screenWidth - (GamePanel.screenWidth / 5.9));
        buttonY = (float) ((GamePanel.screenHeight) - (GamePanel.screenHeight / 2.35));
        buttonBox = new Rectangle((int) buttonX, (int) buttonY, buttonW, buttonH);
    }
    public void endTurn()
    {
        if (playerTurn)
        {
            playerTurn = false;
            System.out.println("TURN ENDED");
            startEnemyTurn();
        }
    }

    public void checkEndTurn(int x, int y)
    {
        if (buttonBox.contains(x, y))
        {
            endTurn();
        }

    }

    public void renderTurnButton(Graphics2D g2)
    {
        g2.drawImage(ArtLoader.endTurnArt, (int)buttonX, (int)buttonY, buttonW, buttonH, null);
        TextRenderer.renderText(g2, String.valueOf(LH.currentLevel.CH.energy), ArtLoader.perfectFont, Color.white, (int)buttonX + buttonW/2, (int)buttonY + buttonH + 30);
    }

    public void startEnemyTurn()
    {
        LH.currentLevel.enemy.setBlock(0);
        LH.currentLevel.enemyAI.opponentAction();

        endEnemyTurn();
    }

    public void endEnemyTurn()
    {

        LH.currentLevel.enemyAI.decision();
        LH.currentLevel.player.setBlock(0);
        playerTurn = true;
        LH.currentLevel.CH.energy = LH.currentLevel.energyReplenishAmount;
        LH.currentLevel.CH.hand.clear();
        LH.currentLevel.CH.buildDeck();
    }

    public void renderOpponentDecision(Graphics2D g2, Font font, int x, int y)
    {
        
    }


}
