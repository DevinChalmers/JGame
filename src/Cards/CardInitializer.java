package Cards;


import Cards.CardClasses.*;
import main.ArtLoader;

import java.util.ArrayList;

public class CardInitializer
{
    ArrayList<Card> allCards = new ArrayList<>();
    
    public CardInitializer(CardHandler CH)
    {
        allCards.add(new Block("Block", "Defend", 1, ArtLoader.cardArt, CH));
        allCards.add(new Attack("Strike", "Attack", 1, ArtLoader.cardArt, CH));
        allCards.add(new Attack("Heal", "Heal", 1, ArtLoader.cardArt, CH));
        allCards.add(new Attack("Card", "Attack", 1, ArtLoader.cardArt,CH));
    }

    public Card randomCard()
    {
        int rand = (int)(Math.random() * allCards.size());
        return allCards.get(rand);
    }
}
