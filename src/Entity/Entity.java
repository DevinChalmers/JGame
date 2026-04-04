package Entity;

public class Entity
{
    public int health;
    public int maxHealth;
    public int block;
    public HealthBar healthBar;

    //public String name;

    public Entity(int MaxHealth, int initialBlock, String name)
    {
        health = MaxHealth;
        this.maxHealth = MaxHealth; //stores max health for later
        block = initialBlock;

        healthBar = new HealthBar(this, name);
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

    public void addBlock(int blockAmount)
    {
        block += blockAmount;
    }

    public void setBlock(int blockAmount)
    {
        block = blockAmount;
    }
}
