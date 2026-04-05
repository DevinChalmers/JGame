package Cards;


import Cards.CardClasses.*;
import main.ArtLoader;

import java.util.ArrayList;

public class CardInitializer
{
    ArrayList<Card> allCards = new ArrayList<>();
    
    public CardInitializer(CardHandler CH)
    {
        allCards.add(new Parry("Parry", "Defend", 1, ArtLoader.parryArt, CH));
        allCards.add(new JavaAttack("Hot Java", "Attack", 1, ArtLoader.javaArt, CH));
        allCards.add(new Infinite("Infinite Loop", "Attack", 2, ArtLoader.infiniteArt, CH));
    }

    public Card randomCard()
    {
        int rand = (int)(Math.random() * allCards.size());
        return allCards.get(rand);
    }
}
