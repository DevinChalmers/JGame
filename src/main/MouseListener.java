package main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;

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
    public void mousePressed(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();

        gp.LevelH.CH.checkCardClick(mouseX, mouseY);
    }

}
