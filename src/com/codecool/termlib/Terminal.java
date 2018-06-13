package com.codecool.termlib;
import com.codecool.termlib.Game;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;
import java.util.Arrays;

public class Terminal {
    /**
     * The beginning of control sequences.
     */
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     *
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     *
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

    /**
     * Reset printing rules in effect to terminal defaults.
     *
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */
    public void resetStyle() {
    }

    /**
     * Clear the whole screen.
     *
     * Might reset cursor position.
     */
    public void clearScreen() {
        System.out.print(CONTROL_CODE+MOVE+CONTROL_CODE+CLEAR);
        System.out.flush();
    }

    /**
     * Move cursor to the given position.
     *
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */
    public void moveTo(Integer x, Integer y) {
    }

    /**
     * Set the foreground printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */
    public void setColor(Color color) {
    }

    /**
     * Set the background printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    public void setBgColor(Color color) {
    }

    /**
     * Make printed text underlined.
     *
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public void setUnderline() {
    }

    /**
     * Move the cursor relatively.
     *
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount Step the cursor this many times.
     */
    public void moveCursor(Direction direction, Integer amount) {
    }

    /**
     * Set the character diplayed under the current cursor position.
     *
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     * position.
     */
    public void setChar(char c) {
    }

    /**
     * Helper function for sending commands to the terminal.
     *
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private void command(String commandString) {
    }
    public static final String ANSI_BLACK = "\u001B[30m";
    public String chooseRandomWord() {
        String[] wordPool = {"project", "apple", "commission"};

        int randomNumber = (int) (Math.random() * wordPool.length);
        return wordPool[randomNumber];
    }

    public boolean checkChar(ArrayList usedLetters, char guess) {
        boolean check = usedLetters.contains(guess);
        return check;
    }

    public void startMenu(){
        Terminal player = new Terminal();
        Game play = new Game();
        Scanner input = new Scanner(System.in);
        clearScreen();
        System.out.println(ANSI_BLACK + "HANGMAN GAME");
        System.out.println("");
        System.out.println(player.chooseDraw(5));
        System.out.println("");
        System.out.println("Please select a number");
        System.out.println("1. Player VS Comp");
        System.out.println("2. Player VS Player");
        System.out.println("3. Rulebook");
        System.out.println("0. Quit");
        char choice = input.next().charAt(0);
        switch(choice){
            case '1': {
                String randomWord = player.chooseRandomWord();
                play.game(randomWord);
                break;
            }
            case '2': {
                String randomWord = player.userWord();
                play.game(randomWord);
                break;
            }
            case '3': {
                player.ruleBook();
                break;
            }
            case '0': {
                player.quit();
                break;
            }
        }
    }

    public void ruleBook(){
        Terminal player = new Terminal();
        Game play = new Game();
        System.out.println("\033[H\033[2J");
        System.out.println("The Rules:");
        System.out.println("1. You have 5 lives");
        System.out.println("2. Guess a letter and if it's wrong you lose a life");
        System.out.println("3. You can only guess one character at a time");
        System.out.println("4. In order to win fill in the blanks before losing all your lives");
        System.out.println();
        System.out.println("Please select a number");
        System.out.print("1. Player VS Computer  ");
        System.out.print("  2. Player VS Player  ");
        System.out.print("  3. Go back  ");
        System.out.print("  0. Quit");
        System.out.println();
        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0);
        switch(choice){
            case '1': {
                String randomWord = player.chooseRandomWord();
                play.game(randomWord);
                break;
            }
            case '2': {
                String randomWord = player.userWord();
                play.game(randomWord);
                break;
            }
            case '3': {
                player.startMenu();
                break;
            }
            case '0': {
                player.quit();
                break;
            }
        }
    }

    public void quit(){
        System.out.println("See You Later Aligator!");
        System.exit(0);
    }

    public void win(char [] letterToGuess, char [] board ){
        Terminal win = new Terminal();
        if (Arrays.equals(letterToGuess, board)) {
            System.out.println("You Won");
            win.restart();
        }
    }


    public void youLost(){
        Terminal player = new Terminal();
        clearScreen();
        System.out.println("YOU'VE LOST!");
        System.out.println(player.chooseDraw(0));
        player.restart();
    }


    public void restart() {
        Terminal player = new Terminal();
        System.out.println("Do you want to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner input = new Scanner(System.in);
        char restartChoice = input.next().charAt(0);
        switch(restartChoice){
            case '1': {
                player.startMenu();
                break;
            }
            case '2': {
                player.quit();
                break;
            }
        }
    }

    public String userWord(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a word: ");
        String word = input.nextLine().toLowerCase();
        return word;
    }

    public String chooseDraw(Integer index){
        String[] draws = {
            "-------\n"   
        + " |   |\n"
        + " |   0\n"
        + " | /-+-\\\n"
        + " |   | \n"
        + " |   | \n"
        + " |  | |\n"
        + " |  | |\n"
        + " |    \n"
        + " |    \n"
        + "--------", 
            "-------\n"   
        + " |   |\n"
        + " |   0\n"
        + " | /-+-\\\n"
        + " |   | \n"
        + " |   | \n"
        + " |  |  \n"
        + " |  |  \n"
        + " |    \n"
        + " |    \n"
        + "--------", 
           "-------\n"   
        + " |   |\n"
        + " |   0\n"
        + " | /-+-\\\n"
        + " |   | \n"
        + " |   | \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + "--------", 
           "-------\n"   
        + " |   |\n"
        + " |   0\n"
        + " | /-+-\\\n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + "--------", 
           "-------\n"   
        + " |   |\n"
        + " |   0\n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + "--------", 
           "-------\n"
        + " |   |\n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + " |    \n"
        + "--------\n"};
        return draws[index];
    }
}
