package Cards.CardClasses;

import java.awt.image.BufferedImage;

import Cards.Card;
import Entity.*;

public class Attack extends Card
{
    public Attack(String name, String type, int value, BufferedImage sprite)
    {
        super(name, type, value, sprite);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        enemy.damage(value);
    }
}
