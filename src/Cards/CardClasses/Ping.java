package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;
import main.ArtLoader;

import java.awt.image.BufferedImage;

public class Ping extends Card
{

    public Ping(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        CH.energy -= energyCost;
        enemy.applyVulnerability(2);
        System.out.println(enemy.vulnerability);
        ArtLoader.playSound(ArtLoader.skillSound, -19);
    }
}
