package Cards;
import java.awt.*;
import java.util.ArrayList;

import Entity.*;

import main.ArtLoader;
import main.GamePanel;
import Level.LevelHandler;
import main.TurnHandler;

public class CardHandler
{
    public ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Rectangle> cardBounds = new ArrayList<>(); //this handles card interaction with mouse
    public CardInitializer CI = new CardInitializer(this); //initializes Cards

    public int energy = 3;

    TurnHandler turnH;
    Entity player;
    Entity enemy;
    public int cardAmount = 6;

    int hoveredCard = -1;
    double hoverAmount = GamePanel.screenHeight / 15 * 2; //in pixels
    boolean debugBoundBox;

    public CardHandler(Entity player, Entity enemy, LevelHandler LH, int cardAmount)
    {
        this.player = player;
        this.enemy = enemy;
        this.turnH = LH.turnH;
        this.cardAmount = cardAmount;
    }

    public int calculateCardX(int i)
    {
        int cardW = getDynamicCardWidth();
        return (GamePanel.screenWidth - (hand.size() * cardW)) / 2 + (i * cardW);
    }


    public int calculateCardY(int i)
    {
        int cardH = getDynamicCardHeight();
        int baseY = GamePanel.screenHeight - (int)(cardH/1.8);
        if (i == hoveredCard)
        {
            return baseY - (int)(cardH/3);
        }
        else
        {
            return baseY;
        }
    }



    public int getDynamicCardWidth()
    {
        int maxWidth = (int)(80*GamePanel.scaleWindow);
        int minWidth = (int)(40*GamePanel.scaleWindow);

        int availableWidth = GamePanel.screenWidth - 100;
        int calculatedWidth = availableWidth / hand.size();
        return Math.max(minWidth, Math.min(maxWidth, calculatedWidth));
    }

    public int getDynamicCardHeight()
    {
        return (int)(getDynamicCardWidth() * 1.5f); // maintains aspect ratio
    }





    public void handleCardBounds(Graphics2D g2)
    {
        cardBounds.clear(); //clears every frame

        for (int i = 0; i < hand.size(); i++)
        {
            int cardW = getDynamicCardWidth();
            int cardH = getDynamicCardHeight();
            int x = calculateCardX(i);
            int y = calculateCardY(i);

            cardBounds.add(new Rectangle(x, y, cardW, cardH)); //creates inv rectangle to use as collision

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

    public void buildDeck()
    {
        for (int i = 0; i < cardAmount; i++)
        {
            hand.add(CI.randomCard());
        }
    }

    public void renderDeck(Graphics2D g2)
    {
        int cardW = getDynamicCardWidth();
        int cardH = getDynamicCardHeight();
        for (int i = 0; i < hand.size(); i++)
        {
            hand.get(i).drawToScreen(
                    g2,
                    hand.get(i),
                    calculateCardX(i),
                    calculateCardY(i), cardW, cardH,this); //cards take the last 4th of the screen by default
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
                        if (hand.get(i).energyCost <= energy)
                        {
                            hand.get(i).cardAction(player, enemy); //passed all information needed for card Action
                            hand.remove(i); //removes card from hand after click
                        }
                        else
                        {
                            System.out.println("Not enough energy!");
                        }
                    }
                    else
                    {
                        System.out.println("It is not your turn");
                    }
                }
            }
    }


    int lastHoveredCard = -1;
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

        if (hoveredCard != lastHoveredCard && hoveredCard != -1)
        {
            ArtLoader.playSound(ArtLoader.cardHover, -10); //plays card sound if the hovered card switches
        }

        lastHoveredCard = hoveredCard;
    }
}
