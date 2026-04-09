package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class Segfault extends Card
{

    public Segfault(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        player.damage(27);
        CH.cardAmount +=1;
        System.out.println(CH.cardAmount);
        ArtLoader.playSound(ArtLoader.skillSound, -19);
    }
}
