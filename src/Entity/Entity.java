package Entity;

public class Entity
{
    public int health;
    public int block;

    public Entity(int MaxHealth, int initialBlock)
    {
        health = MaxHealth;
        block = initialBlock;
    }

    public void damage(int incoming)
    {
        if (block > 0)
        {
            int remainingBlock =  block - incoming;

            if (remainingBlock <= 0)
            {
                int remainingDamage = block - incoming;
                block = 0;
                health = health + remainingDamage; //always - value so it subtracts
            }
            else if (remainingBlock > 0)
            {
                block = block - incoming;
            }
        }
        else if (block <= 0)
        {
            health = health - incoming;
        }

        System.out.println("HEALTH: " + health + " SHIELD: " + block);
    }
}
