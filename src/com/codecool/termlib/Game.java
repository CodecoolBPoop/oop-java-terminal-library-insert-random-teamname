package com.codecool.termlib;

import com.codecool.termlib.Terminal;
import java.util.Scanner;
import java.util.Arrays;

public class Game {

    public void game() {
        Terminal game = new Terminal();
        String wordToGuess = game.chooseRandomWord();
        char[] lettersToGuess = wordToGuess.toCharArray();
        char unknown = '_';
        char[] board = new char[lettersToGuess.length];
        Arrays.fill(board, unknown);
        int lives = 5;
        while (lives > 0) {
            System.out.println("Lives: " + lives);
            System.out.print(board);
            System.out.println();
            Scanner input = new Scanner(System.in);
            char guess = input.next().charAt(0);
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
    }


    public void startMenu(){
        Game play = new Game();
        Scanner input = new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        System.out.println("Please select a number");
        System.out.println("1. Start game");
        System.out.println("2. Rulebook");
        char choice = input.next().charAt(0);
        switch(choice){
            case '1': {
                play.game();
                break;
            }
            case '2': {
                play.ruleBook();
                break;
            }
        }
    }

    public void ruleBook(){
        Game play = new Game();
        System.out.println("\033[H\033[2J");
        System.out.println("The Rules:");
        System.out.println("1. You have 5 lives");
        System.out.println("2. Guess a letter and if it's wrong you lose a life");
        System.out.println("3. You can only guess one character at a time");
        System.out.println("4. In order to win fill in the blanks before losing all your lives");
        System.out.println();
        System.out.println("Please select a number");
        System.out.print("1. Start game ");
        System.out.print("  2. Go back");
        System.out.println();
        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0);
        switch(choice){
            case '1': {
                play.game();
                break;
            }
            case '2': {
                play.startMenu();
                break;
            }
        }
    }


    //To call the code open src and run java com.codecool.termlib.Game
    public static void main(String[] args) {
        Game play = new Game();
        play.startMenu();


    }
}