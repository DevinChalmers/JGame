package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class JavaAttack extends Card
{

    public JavaAttack(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        enemy.damage(10);
        ArtLoader.playSound(ArtLoader.attackSound, -23);
    }
}
