package Entity;

import Level.LevelHandler;

public class CPlusEnemyAI extends OpponentAI
{
    String[] moves = {"Attack", "Attack", "Block", "Attack", "Heal"};
    int index = 0;

    Entity player;
    Entity self;
    String name;

    public CPlusEnemyAI(Entity player, Entity self, LevelHandler LH)
    {
        super(player, self, LH);
        this.player = player;
        this.self = self;
        this.LH = LH;
        name = self.name;
    }

    @Override
    public void damagePlayer(int incoming)
    {
        player.damage(incoming);
    }

    int maxDamageAmount = 27;
    int minDamageAmount = 2;
    int randomDamageAmount = 0;
    @Override
    public void decision()
    {
        randomDamageAmount = getRandomNumber(minDamageAmount, maxDamageAmount);
        if (moves[index] == "Attack")
        {
            decisionString = name + " will " + moves[index] + " for " + randomDamageAmount;
            System.out.println(decisionString);
        }
        else
        {
            decisionString = name + " will " + moves[index];
            System.out.println(decisionString);
        }
    }

    @Override
    public void opponentAction()
    {
        if(moves[index] == "Attack")
        {
            System.out.println(randomDamageAmount);
            damagePlayer(randomDamageAmount);
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
