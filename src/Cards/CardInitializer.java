package Cards;


import Cards.*;
import Cards.CardClasses.*;
import main.ArtLoader;

import java.util.ArrayList;

public class CardInitializer
{
    ArrayList<Card> allCards = new ArrayList<>();
    
    public CardInitializer(CardHandler CH)
    {
        allCards.add(new Parry("Parry", "Defend", 1, ArtLoader.parryArt, CH));
        //allCards.add(new JavaAttack("Hot Java", "Attack", 1, ArtLoader.javaArt, CH));
        allCards.add(new Infinite("Infinite Loop", "Attack", 2, ArtLoader.infiniteArt, CH));
        allCards.add(new Memory("Memory Leak", "Attack", 1, ArtLoader.memoryArt, CH));
        allCards.add(new Firewall("Firewall", "Attack", 2, ArtLoader.firewallArt, CH));
        allCards.add(new Segfault("Segfault", "Bug", 1, ArtLoader.segfaultArt, CH));
        allCards.add(new Ping("Ping", "Skill", 1, ArtLoader.pingArt, CH));
        allCards.add(new Compile("Compile", "Attack", 1, ArtLoader.compileArt, CH));
    }

    public Card randomCard()
    {
        int rand = (int)(Math.random() * allCards.size());
        return allCards.get(rand);
    }
}
