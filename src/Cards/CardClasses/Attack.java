package Cards.CardClasses;

import java.awt.image.BufferedImage;

import Cards.*;
import Entity.*;

public class Attack extends Card
{

    public Attack(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy);
        CH.energy -= energyCost;
        enemy.damage(20);
    }
}
