package Cards;

public class CardKeeper 
{
    static Card cards[] = new Card[5];
    static int min = 0;
    
    public static void CardKeeper() 
    {
        cards[0] = new Attack("Block", "Attack", 20, CardArt.shield);
        cards[1] = new Attack("Slash", "Attack", 50, CardArt.shield);
        cards[2] = new Attack("Heal", "Attack", 90, CardArt.shield);
    }

    public Card randomCard()
    {
        return cards[(int) (Math.random() * (cards.length - min) + min)];
    }
}
