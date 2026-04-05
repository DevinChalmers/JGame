package Entity;

import java.util.Objects;
import java.util.Random;

public class Enemy1 extends OpponentAI
{
    String[] moves = {"Block", "Attack", "Attack", "Attack", "Heal", "Block"};
    int index = 0;

    Entity player;
    Entity self;

    public Enemy1(Entity player, Entity self)
    {
        super(player, self);
        this.player = player;
        this.self = self;
        decisionString = "Hello2";
    }

    @Override
    public void damagePlayer(int incoming)
    {
        player.damage(incoming);
    }

    int maxDamageAmount = 30;
    int damageAmount;
    @Override
    public void decision()
    {
        damageAmount = getRandomNumber(10, maxDamageAmount);
        if (Objects.equals(moves[index], "Attack"))
        {
            decisionString = "Opponent will " + moves[index] + " for " + damageAmount;
            System.out.println(decisionString);
        }
        else
        {
            decisionString = "Opponent will " + moves[index];
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
