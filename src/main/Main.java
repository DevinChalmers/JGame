package main;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("JGame");
        window.setLocationRelativeTo(null); //what does this do

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);
        gamePanel.requestFocusInWindow();
        gamePanel.startGameThread();



    }
}