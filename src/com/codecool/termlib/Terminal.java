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
        player.printHangman();
        player.drawHangman();
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "Please select a number from the given options");
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
            default: {
                player.startMenu();
            }
        }
    }

    public void ruleBook(){
        Terminal player = new Terminal();
        Game play = new Game();
        player.clearScreen();
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "The Rules:");
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
            default: {
                player.ruleBook();
            }
        }
    }

    public void quit(){
        clearScreen();
        Terminal player = new Terminal();
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "See You Later Aligator!");
        player.printAligator();
        System.out.println(ANSI_RESET);
        System.exit(0);
    }

    public void win(char [] letterToGuess, char [] board ){
        Terminal win = new Terminal();
        if (Arrays.equals(letterToGuess, board)) {
            System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "CONGRATULATIONS!!!");
            win.printCelebrate();
            win.restart();
        }
    }


    public void youLost(){
        Terminal player = new Terminal();
        clearScreen();
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "May be next time...");
        System.out.println(ANSI_RED + player.losingLivesHangman(0) + ANSI_RESET);
        player.printGhost();
        player.restart();
    }


    public void restart() {
        Terminal player = new Terminal();
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "Do you want to play again?");
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
            default: {
                clearScreen();
                player.restart();
            }
        }
    }

    public String userWord(){
        Terminal player = new Terminal();
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a word: ");
        String word = input.nextLine().toLowerCase();
        if (!word.matches("[a-zA-Z]+")){
            System.out.println("Letters only!");
            return player.userWord();
            }
        return word;
    }

    public String losingLivesHangman(Integer index){
        String[] draws = {
            "-------\n"
        + " |   |\n"
        + " | (O.o)\n"
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
        + " | (O.o)\n"
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
        + " | (O.o)\n"
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
        + " | (O.o)\n"
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
        + " | (O.o)\n"
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
    public void printHangman(){
        System.out.println(BACKGROUND_WHITE + ANSI_BLACK + "██╗  ██╗ █████╗ ███╗   ██╗ ██████╗ ███╗   ███╗ █████╗ ███╗   ██╗");
        System.out.println("██║  ██║██╔══██╗████╗  ██║██╔════╝ ████╗ ████║██╔══██╗████╗  ██║");
        System.out.println("███████║███████║██╔██╗ ██║██║  ███╗██╔████╔██║███████║██╔██╗ ██║");
        System.out.println("██╔══██║██╔══██║██║╚██╗██║██║   ██║██║╚██╔╝██║██╔══██║██║╚██╗██║");
        System.out.println("██║  ██║██║  ██║██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚████║");
        System.out.println("╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝" + ANSI_RESET);

    }


    public void printAligator(){
        System.out.println(BACKGROUND_WHITE + ANSI_GREEN + "            .-._   _ _ _ _ _ _ _ _       ");
        System.out.println(" .-''-.__.-'00  '-' ' ' ' ' ' ' ' '-.    ");
        System.out.println("'.___ '    .   .--_'-' '-' '-' _'-' '._  ");
        System.out.println(" V: V 'vv-'   '_   '.       .'  _..' '.'.");
        System.out.println("   '=.____.=_.--'   :_.__.__:_   '.   : :");
        System.out.println("           (((____.-'        '-.  /   : :");
        System.out.println("                             (((-'\\ .' /");
        System.out.println("                           _____..'  .'  ");
        System.out.println("                          '-._____.-'    " + ANSI_RESET);
    }

    public void printCelebrate(){
        System.out.println(BACKGROUND_WHITE + ANSI_RED + "                                 .''.");
        System.out.println("       .''.             *''*    :_\\/_:     . ");
        System.out.println("      :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.");
        System.out.println("  .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-");
        System.out.println(" :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'");
        System.out.println(" : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *");
        System.out.println("  '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____");
        System.out.println("      *        __*..* |  |     :      |.   |' .---''|");
        System.out.println("       _*   .-'   '-. |  |     .--'|  ||   | _|    |");
        System.out.println("    .-'|  _.|  |    ||   '-__  |   |  |    ||      |");
        System.out.println("    |' | |.    |    ||       | |   |  |    ||      |");
        System.out.println(" ___|  '-'     '    ''       '-'   '-.'    '`      |____");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void printGhost(){
        System.out.println(BACKGROUND_WHITE + ANSI_BLUE + "     .-----.");
        System.out.println("   .' -   - '.");
        System.out.println("  /  .-. .-.  \\");
        System.out.println("  |  | | | |  |");
        System.out.println("   \\ \\o/ \\o/ /");
        System.out.println("  _/    ^    \\_");
        System.out.println(" | \\  '---'  / |");
        System.out.println(" / /`--. .--`\\ \\");
        System.out.println("/ /'---` `---'\\ \\");
        System.out.println("'.__.       .__.'");
        System.out.println("    `|     |`");
        System.out.println("     |     \\");
        System.out.println("     \\      '--.");
        System.out.println("      '.        `\\");
        System.out.println("        `'---.   |");
        System.out.println("           ,__) /");
        System.out.println("            `..'" + ANSI_RESET);
    }

    public void drawHangman(){
        System.out.println(BACKGROUND_WHITE + BLINK + ANSI_BLACK + " ___________.._______");
        System.out.println("| .__________))______|");
        System.out.println("| | / /      ||");
        System.out.println("| |/ /       ||");
        System.out.println("| | /        ||.-''.");
        System.out.println("| |          ||  `/,|");
        System.out.println("| |          (\\\\`_.'");
        System.out.println("| |         .-`--'.");
        System.out.println("| |        /Y . . Y\\");
        System.out.println("| |       // |   | \\\\");
        System.out.println("| |      //  | . |  \\\\");
        System.out.println("| |     ')   |   |   (`");
        System.out.println("| |          ||'||");
        System.out.println("| |          || ||");
        System.out.println("| |          || ||");
        System.out.println("| |          || ||");
        System.out.println("| |         / | | \\");
        System.out.println("----------|_`-' `-' |---|");
        System.out.println("|-|-------\\ \\       '-|-|");
        System.out.println("| |        \\ \\        | |");
        System.out.println(": :         \\ \\       : :");
        System.out.println(". .          `'       . ." + ANSI_RESET);
    }

    public static final String ANSI_GREEN = "\033[1;32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\033[1;90m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String ANSI_BLUE = "\033[1;94m";
    public static final String ANSI_RED = "\033[1;91m";
    public static final String BLINK = "\u001B[5m";
    public static final String HIGH_INTENSITY = "\u001B[1m";
    public static final String BACKGROUND_WHITE = "\033[107m";
    public static final String INVISIBLE_TEXT = "\u001B[8m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
}
