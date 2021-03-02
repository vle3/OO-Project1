package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordGameCanvas extends JPanel
{
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int health = 0; 

    private WordGamePanel panel ;

    public WordGameCanvas(WordGamePanel panel)
    {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        g2.setFont(new Font("New Courier", Font.BOLD, 45));
        g2.drawString("Health Level" , 20 ,40);

        //draw healthbar
        for(int i = 0 ; i < health; i++)
        {
            g2.fillRect(i * 50 + 20, 60 , 40, 60);
        }
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
}
