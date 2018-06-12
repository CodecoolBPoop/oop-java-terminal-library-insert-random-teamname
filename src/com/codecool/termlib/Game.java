package com.codecool.termlib;

import com.codecool.termlib.Terminal;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Character;

public class Game {

    public void game() {
        Terminal game = new Terminal();
        String wordToGuess = game.chooseRandomWord();
        char[] lettersToGuess = wordToGuess.toCharArray();
        char unknown = '_';
        char[] board = new char[lettersToGuess.length];
        Arrays.fill(board, unknown);
        ArrayList usedLetters = new ArrayList();
        int lives = 5;
        while (lives > 0) {

            System.out.print("Lives: " + lives);
            System.out.println("\t To exit type 0");
            System.out.println(board);
            System.out.println();
            System.out.println("Used letters:" + usedLetters);
            Scanner input = new Scanner(System.in);
            char guess = Character.toLowerCase(input.next().charAt(0));
            game.clearScreen();
            if (guess == '0') {
                game.quit();
            }
            game.win(lettersToGuess, board);
            char guess = input.next().charAt(0);
            if (game.checkChar(usedLetters, guess)){
                System.out.println("You've already guessed this letter!");
                continue;
            }
            usedLetters.add(guess);
            if (wordToGuess.indexOf(guess) >= 0) {
                for (int j = 0; j < lettersToGuess.length; j++) {
                    if (lettersToGuess[j] == guess) {
                        board[j] = guess;
                    }
                }
            } else {
                lives -= 1;
            }
        }
        game.youLost();
    }


    //To call the code open src and run java com.codecool.termlib.Game
    public static void main(String[] args) {
        Terminal player = new Terminal();
        player.startMenu();


    }
}