package com.codecool.termlib;

import com.codecool.termlib.Terminal;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    //To call the code open src and run 
    public static void main(String[] args) {
        System.out.println("Hohoho");
        Terminal game = new Terminal();
        game.sayHello();
      
        String[] words = {"program", "javac"};
        // kiválaszt egy random szót
        int randomWordNumber = (int) (Math.random() * words.length);
        // létrehozz egy arrayt a már begépelt betüknek
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 4;
        boolean wordIsGuessed = false;
        do {
        // addig iterál amíg enterletter true
        // ha hamis kitalálták a szót
        // vagyis nincs benne csillag
        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                triesCount--;
                System.out.println("you left: " + triesCount + " guess");
                if (triesCount ==0) {
                    System.out.println("Game over");
                    System.exit(0);
                }
                break;
            case 1:
                break;
            case 2:
                break;  
            case 3:
                wordIsGuessed = true;
                break;
        }
        } while (! wordIsGuessed);
        System.out.println("\nThe word is " + words[randomWordNumber] +
        " You won the game" );
    }
    

    /* 
    return 0 ha a betü nincs benne számláló nő egyet ,
    return 1  ha a betü benne van,
    return 2 ha már kitalált betüt újraütötték,
    return 3 ha az összes betü megvan */
    public static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("Enter a letter in word ");
        // if igaz, ha nincs benne csillag, tehát győzelem
        if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(">");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            System.out.println("You found a letter:" + userInput);
            return 1;
        }
        else {
            
            return 0;
            }
    }

    /* kinyomtatja a csillagot az ismeretlen betük helyére */
    public static boolean printWord(String word, char[] enteredLetters) {
        // az összes betün végigiterál 
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // már beütötte-e ezt a betüt
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    /* ellenörzi, hogy a betü benne van az enteredlerrers arrayban */
    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    /* megtalálja az első üres helyet az enteredletters arrayban */
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }
}