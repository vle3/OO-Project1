package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.WordGame;
import view.WordGamePanel;

public class WordGameKeyListener implements ActionListener 
{
    private WordGamePanel panel;
    private int click;

    public WordGameKeyListener(WordGamePanel panel)
    {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton button = (JButton) e.getSource();
        String tempGuess = "" ;
        int health = 5;
        int wrong = 0;
        //new game button
        if(button == panel.getNewButton())
        {
            var game = new WordGame();
            panel.setWordGame(game);
            String keyString = game.getKey();
            panel.getGameKeyField().setText(keyString);
            String dashString = keyString.replaceAll("[a-z]", " _");
            panel.getGuessField().setText(dashString);

            
            panel.getCanvas().setHealth(health);
            panel.getCanvas().repaint();
            //enable alphabet buttons
            for(var a: panel.getAlphabetButton())
            {
                a.setEnabled(true);
            }
            panel.getCanvas().setHealth(5);
            panel.getCanvas().repaint(); 
            tempGuess = dashString;
        }
        
        // alphabet button after new game pressed
        else 
        {
            button.setEnabled(false); // disable after every press

            WordGame wordGame = panel.getWordGame();
            String gameKey = wordGame.getKey();
            int keyLength = gameKey.length();
            tempGuess = gameKey.replaceAll("[a-z]", " _");
            String bString = button.getText();
            char n = bString.charAt(0);
            char[] charGuessList = new char[] {}; 
            if(gameKey.contains(bString))
            {
                for(int pos = 0 ; pos < gameKey.length();pos++)
                {
                    if(gameKey.charAt(pos) == n && tempGuess.charAt(pos) != n)
                    {
                        tempGuess = tempGuess.replaceAll("_ ", "_");
                        String word2;
                        word2 = tempGuess.substring(0,pos) + n + tempGuess.substring(pos + 1);
                        word2 = word2.replaceAll("_", "_ ");
                        tempGuess = word2;
                        
                    }
                }
                panel.getGuessField().setText(tempGuess);
            }
            
            else 
            {
                for (int i = 0 ; i < 1; i++)
                {
                    health-- ;
                }
                panel.getCanvas().setHealth(health);
                panel.getCanvas().repaint();
            }
        }
    }
}
