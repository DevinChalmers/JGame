package Entity;

import java.util.Random;

public class OpponentAI
{
    String[] moves = {"Attack", "Block", "Heal"};
    int index = 0;

    Entity player;
    Entity self;

    public OpponentAI(Entity player, Entity self)
    {
        this.player = player;
        this.self = self;
    }

    public void damagePlayer(int incoming)
    {
        player.damage(getRandomNumber(0,40));
    }

    public void decision()
    {
        System.out.println("Opponent will "+ moves[index]);
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
}
