package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class Memory extends Card
{

    public Memory(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        enemy.damage(15);
        CH.hand.add(CH.CI.randomCard()); //draw random cards
        CH.hand.add(CH.CI.randomCard());
        ArtLoader.playSound(ArtLoader.attackSound, -10);
    }
}
