package Entity;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy1 extends OpponentAI
{
    String[] moves = {"Attack", "Block", "Heal"};
    int index = 0;

    Entity player;
    Entity self;

    public Enemy1(Entity player, Entity self)
    {
        super(player, self);
        this.player = player;
        this.self = self;
    }

    @Override
    public void damagePlayer(int incoming)
    {
        player.damage(getRandomNumber(0,40));
    }

    @Override
    public void decision()
    {
        System.out.println("Opponent will "+ moves[index]);
    }

    @Override
    public void opponentAction()
    {
        if(moves[index] == "Attack")
        {
            damagePlayer(getRandomNumber(0,40));
        }
        
        else if(moves[index] == "Block")
        {
            self.setBlock(getRandomNumber(0,20));
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
