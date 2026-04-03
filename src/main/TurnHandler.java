package main;

import Cards.CardHandler;

import java.awt.*;


public class TurnHandler
{
    public boolean playerTurn = true;
    boolean enemyTurn = false;
    float buttonX;
    float buttonY;
    int widthInPixels = 73;
    int heightInPixels= 25;
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
    }

    public void startEnemyTurn()
    {
        playerTurn = true;
        LH.CH.hand.clear();
        LH.CH.buildDeck(6);
    }


}
