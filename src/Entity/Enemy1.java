package Entity;

import Level.LevelHandler;
import main.TextRenderer;

import java.awt.*;
import java.util.Random;

public class Enemy1 extends OpponentAI
{
    String[] moves = {"Block", "Attack", "Attack", "Attack", "Block", "Heal"};
    int index = 0;

    Entity player;
    Entity self;

    public Enemy1(Entity player, Entity self, LevelHandler LH)
    {
        super(player, self, LH);
        this.player = player;
        this.self = self;
        this.LH = LH;
    }

    @Override
    public void damagePlayer(int incoming)
    {
        player.damage(incoming);
    }

    int damageAmount = 30;
    @Override
    public void decision()
    {
        damageAmount = getRandomNumber(10, damageAmount);
        if (moves[index] == "Attack")
        {
            System.out.println("Opponent will " + moves[index] + " for " + damageAmount);
        }
        else
        {
            System.out.println("Opponent will " + moves[index]);
        }


    }

    @Override
    public void opponentAction()
    {
        if(moves[index] == "Attack")
        {
            System.out.println(damageAmount);
            damagePlayer(damageAmount);
        }
        
        else if(moves[index] == "Block")
        {
            self.addBlock(getRandomNumber(0,20));
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

    @Override
    public int getRandomNumber(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
