package Entity;

import Level.LevelHandler;
import main.GamePanel;
import main.TextRenderer;

import java.awt.*;
import java.util.Random;
import java.util.logging.Level;

public class OpponentAI
{
    String[] moves = {"Attack", "Block", "Heal"};
    int index = 0;

    Entity player;
    Entity self;
    int x;
    int y;
    LevelHandler LH;

    String decisionString = "YO";


    public OpponentAI(Entity player, Entity self, LevelHandler LH)
    {
        this.player = player;
        this.self = self;
        this.LH = LH;
    }

    public void damagePlayer(int incoming)
    {

    }

    public void decision()
    {
        decisionString = "Opponent will " + moves[index];
    }

    public int getRandomNumber(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public void opponentAction()
    {
        if(moves[index] == "Attack")
        {
            damagePlayer(getRandomNumber(0,40));
        }

        else if(moves[index] == "Block")
        {
            self.setBlock(20);
        }

        else if(moves[index] == "Heal")
        {
            int maxHealAmt = 20;

            if (self.health < self.maxHealth && (self.maxHealth - self.health) > maxHealAmt)
            {
                self.health += getRandomNumber(0, maxHealAmt);
            }
            else
            {
                self.health += getRandomNumber(0, self.maxHealth - self.health);
            }

        }

        index++;

        if (index >= moves.length)
        {
            index = 0;
        }
    }

    public void renderOpponentDecision(Graphics2D g2, Font font)
    {
        //render decision
        TextRenderer.renderText(g2, decisionString, font, Color.white, GamePanel.screenWidth/2, GamePanel.screenHeight/2);
    }
}
