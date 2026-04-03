package Cards;
import java.awt.*;
import java.util.ArrayList;
import Entity.*;

import main.GamePanel;
import main.TurnHandler;

public class CardHandler
{
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Rectangle> cardBounds = new ArrayList<>(); //this handles card interaction with mouse
    CardInitializer CK = new CardInitializer(); //initializes Cards

    TurnHandler turnH;
    Entity player;
    Entity enemy;

    int hoveredCard = -1;
    double hoverAmount = 11 * GamePanel.scaleWindow; //in pixels
    boolean debugBoundBox;

    public CardHandler(Entity player, Entity enemy, TurnHandler turnH)
    {
        this.player = player;
        this.enemy = enemy;
        this.turnH = turnH;
    }
    public int calculateCardX(int i)
    {
        return (GamePanel.screenWidth - (hand.size() * hand.get(i).cardW)) / 2 + (i * hand.get(i).cardW);
    }


    public int calculateCardY(int i)
    {
        if (i == hoveredCard)
        {
            return (int) (GamePanel.screenHeight - GamePanel.screenHeight / (hand.get(i).defaultY) - hoverAmount);
        }
        else
        {
            return (int) (GamePanel.screenHeight - GamePanel.screenHeight / (hand.get(i).defaultY));
        }
    }

    public void handleCardBounds(Graphics2D g2)
    {
        cardBounds.clear(); //clears every frame

        for (int i = 0; i < hand.size(); i++)
        {
            int x = calculateCardX(i);
            int y = calculateCardY(i);

            cardBounds.add(new Rectangle(x, y, hand.get(i).cardW, hand.get(i).cardH)); //creates inv rectangle to use as collision

            //debugging visuals
            if (debugBoundBox) 
            {
                g2.setColor(Color.red); 
                for (Rectangle r : cardBounds) {
                    g2.drawRect(r.x, r.y, r.width, r.height);
                }
            }
        }
    }

    public void buildDeck(int cardAmount)
    {
        for (int i = 0; i < cardAmount; i++)
        {
            hand.add(CK.randomCard());
        }
    }

    public void renderDeck(Graphics2D g2)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            hand.get(i).drawToScreen(
                    g2,
                    hand.get(i),
                    calculateCardX(i),
                    calculateCardY(i)); //cards take the last 4th of the screen by default
        }
    }







    //INPUTS
    public void checkCardClick(int mouseX, int mouseY)
    {

            for (int i = 0; i < cardBounds.size(); i++)
            {
                if (cardBounds.get(i).contains(mouseX, mouseY) && cardBounds.get(i) != null)
                {
                    if (turnH.playerTurn)
                    {
                        hand.get(i).cardAction(player, enemy); //passed all information needed for card Action
                        hand.remove(i); //removes card from hand after click
                    }
                    else
                    {
                        System.out.println("It is not your turn");
                    }
                }
            }
    }



    public void checkCardHover(int mouseX, int mouseY)
    {
        hoveredCard = -1; //resets hovered card
        for (int i = 0; i < cardBounds.size(); i++)
        {
            if (cardBounds.get(i).contains(mouseX, mouseY) && cardBounds.get(i) != null)
            {
                hoveredCard = i;
            }

        }
    }
}
