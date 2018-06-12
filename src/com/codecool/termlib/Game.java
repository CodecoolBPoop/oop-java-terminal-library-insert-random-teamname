package com.codecool.termlib;

import com.codecool.termlib.Terminal;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Character;

public class Game {

    public void game(String secretWord) {
        Terminal game = new Terminal();
        game.clearScreen();
        char[] lettersToGuess = secretWord.toCharArray();
        char unknown = '*';
        char[] board = new char[lettersToGuess.length];
        Arrays.fill(board, unknown);
        ArrayList usedLetters = new ArrayList();
        int lives = 5;
        while (lives > 0) {
            System.out.print("Lives: " + lives);
            System.out.println("\t To exit type: 0");
            System.out.println("");
            System.out.println("");
            System.out.println(board);
            System.out.println("");
            System.out.println("");
            System.out.println(game.chooseDraw(lives));
            System.out.println("Used letters:" + usedLetters);
            game.win(lettersToGuess, board);
            Scanner input = new Scanner(System.in);
            char guess = Character.toLowerCase(input.next().charAt(0));
            game.clearScreen();
            if (guess == '0') {
                game.quit();
            }
            if (game.checkChar(usedLetters, guess)){
                System.out.println("You've already guessed this letter!");
                continue;
            }
            usedLetters.add(guess);
            if (secretWord.indexOf(guess) >= 0) {
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