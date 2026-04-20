package main;
import Level.StartMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter
{
    int mouseX;
    int mouseY;
    GamePanel gp;
    public MouseListener(GamePanel gp)
    {   
        this.gp = gp;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();

        if (gp.LevelH.currentLevel.CH != null)
        {
            gp.LevelH.currentLevel.CH.checkCardClick(mouseX, mouseY);
            gp.LevelH.turnH.checkEndTurn(mouseX, mouseY);
        }

        if (gp.LevelH.currentLevel instanceof StartMenu)
        {
            gp.LevelH.currentLevel = gp.LevelH.Level1;
            gp.LevelH.currentLevel.init(100); //THIS STARTS GAME WITH LEVEL 1
        }
    }


    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();

        if (gp.LevelH.currentLevel.CH != null)
        {
            gp.LevelH.currentLevel.CH.checkCardHover(mouseX, mouseY);
        }
    }

}
