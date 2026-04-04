package Cards.CardClasses;

import Cards.Card;
import Cards.CardHandler;
import Entity.Entity;

import java.awt.image.BufferedImage;

public class Block extends Card
{

    public Block(String name, String type, int energyCost, BufferedImage sprite, CardHandler CH)
    {
        super(name, type, energyCost, sprite, CH);
    }

    @Override
    public void cardAction(Entity player, Entity enemy)
    {
        System.out.println(CH.energy + " energy remaining");
        CH.energy -= energyCost;
        player.addBlock(20);
    }
}
