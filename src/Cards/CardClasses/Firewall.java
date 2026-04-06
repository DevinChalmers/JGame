package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class Firewall extends Card
{

    public Firewall(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        player.addBlock(12);
        player.health += 7;
        ArtLoader.playSound(ArtLoader.shieldSound, -18);
    }
}
