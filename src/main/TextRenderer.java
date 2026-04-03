package main;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextRenderer
{
    public TextRenderer() throws IOException, FontFormatException
    {
        loadFont();
    }

    public void loadFont() throws IOException, FontFormatException
    {

    }

    public static void renderText(Graphics2D g2, String text, Font font, Color color, int x, int y)
    {
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, x, y);

    }


}
