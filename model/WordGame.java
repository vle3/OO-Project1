package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class WordGame 
{
    // static Scanner input;

    String key;
    private String[] wordPool = { "communication", "science", "programming", "language", "difficulty", "artificial",
            "intelligence", "attempts", "screenshot", "baseball", "windows", "learning", "electronics", "beautiful",
            "internet", "database", "organization", "application", "network", "friendly", "validation", "attempts",
            "statistics", "physics", "chemistry", "engineering", "school", "industry", "revolution", "progress",
            "characters", "heavily", "graphics" };

    public ArrayList<String> wordPool1 = new ArrayList<String>(Arrays.asList(wordPool));

    // public String word1 = (wordPool[Ran_num]);
    public WordGame()
    {
        generateWord();
    }
    
    public WordGame(String key)
    {
        this.key = key;
    }

    public void generateWord()
    {
        Random obj = new Random();
        int Ran_num = obj.nextInt(33);
        key = wordPool1.get(Ran_num);
    }

    public void setGuess(CharSequence guess , String word)
    {
        
    }

    public int getWordLength(String word0)
    {
        return word0.length();
    }

    public String getKey()
    {
        return key;
    }

}
