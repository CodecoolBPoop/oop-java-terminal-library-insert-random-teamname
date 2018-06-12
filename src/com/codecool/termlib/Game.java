package com.codecool.termlib;

import com.codecool.termlib.Terminal;
import java.util.Scanner;
import java.util.Arrays;

public class Game {

    //To call the code open src and run java com.codecool.termlib.Game
    public static void main(String[] args) {
        Terminal game = new Terminal();
        String wordToGuess = game.chooseRandomWord();
        char[] lettersToGuess = wordToGuess.toCharArray();
        char unknown = '_';
        char[] board = new char[lettersToGuess.length];
        Arrays.fill(board, unknown);
        int lives = 5;
        while (lives > 0){
            System.out.println("Lives: " + lives);
            System.out.print(board);
            System.out.println();
            Scanner input = new Scanner (System.in);
            char guess = input.next().charAt(0);
            if (wordToGuess.indexOf(guess) >= 0){
                for (int j =0; j < lettersToGuess.length; j++){
                    if (lettersToGuess[j] == guess){
                        board[j] = guess;
                    }
                }
            }else{
                lives -= 1;
            }
            
        }

    }
}