package Cards;

import java.awt.image.BufferedImage;

public class Attack extends Card
{
    public Attack(String name, String type, int value, BufferedImage sprite)
    {
        super(name, type, value, sprite);
    }

    @Override
    public void cardAction()
    {
        // Implement the specific action for the attack card here
        System.out.println("Attack card used: " + name + " with value " + value);
    }
}
