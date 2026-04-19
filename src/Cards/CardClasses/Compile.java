package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Cards.CardInitializer;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class Compile extends Card
{

    public Compile(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        enemy.damage(15);
        ArtLoader.playSound(ArtLoader.attackSound, -23);

        if (player.block > 0)
        {
            CH.hand.add(new Compile("Compile", "Attack", 1, ArtLoader.compileArt, CH));
        }
    }
}
