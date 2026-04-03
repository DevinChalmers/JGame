package Cards;


import Cards.CardClasses.Attack;
import main.ArtLoader;

import java.util.ArrayList;

public class CardInitializer
{
    ArrayList<Card> allCards = new ArrayList<>();
    
    public CardInitializer()
    {
        allCards.add(new Attack("Block", "Defend", 20, ArtLoader.cardArt));
        allCards.add(new Attack("Strike", "Attack", 20, ArtLoader.cardArt));
        allCards.add(new Attack("Heal", "Heal", 20, ArtLoader.cardArt));
        allCards.add(new Attack("Card", "Attack", 20, ArtLoader.cardArt));
    }

    public Card randomCard()
    {
        int rand = (int)(Math.random() * allCards.size());
        return allCards.get(rand);
    }
}
