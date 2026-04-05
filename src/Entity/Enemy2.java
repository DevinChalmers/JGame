package Entity;

import Level.LevelHandler;

public class Enemy2 extends OpponentAI
{
    String[] moves = {"Attack", "Attack", "Block", "Attack", "Heal"};
    int index = 0;

    Entity player;
    Entity self;

    public Enemy2(Entity player, Entity self, LevelHandler LH)
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
            decisionString = "Opponent will " + moves[index] + " for " + damageAmount;
            System.out.println(decisionString);
        }
        else
        {
            decisionString = "Opponent will " + moves[index];
            System.out.println(decisionString);
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
            self.addBlock(getRandomNumber(15,45));
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
