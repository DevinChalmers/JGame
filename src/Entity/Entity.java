package Entity;

public class Entity
{
    public int health;
    public int maxHealth;
    public int block;
    public HealthBar healthBar;
    public String name;
    public int vulnerability = 0;
    public OpponentAI opponentAI;

    public Entity(int initialHealth, int MaxHealth, int initialBlock, String name, OpponentAI opponentAI)
    {
        health = initialHealth;
        this.maxHealth = MaxHealth; //stores max health for later
        block = initialBlock;
        this.name = name;
        this.opponentAI = opponentAI;

        healthBar = new HealthBar(this, name);
    }

    public Entity(int initialHealth, int MaxHealth, int initialBlock, String name)
    {
        health = initialHealth;
        this.maxHealth = MaxHealth; //stores max health for later
        block = initialBlock;
        this.name = name;

        healthBar = new HealthBar(this, name);
    }

    public void damage(int incoming)
    {
        if (vulnerability > 0 )
        {
            incoming = (int) (incoming * 1.25); //if the entity has vulnerability, apply 25% more damage
        }

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

    public void applyVulnerability(int amount)
    {
        vulnerability += amount;
    }

    public void lowerVulnerability()
    {
        if (vulnerability > 0)
        {
            vulnerability -= 1;
        }
    }
}
