package com.codecool.termlib;
import com.codecool.termlib.Game;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;
import java.util.Arrays;
import java.awt.event.*;

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
    public String chooseRandomWord(int wordGroup) {
        String[][] wordPool = {
                {"Apple", "Apricot", "Avocado", "Banana", "Blackberry", "Blackcurrant", "Blueberry", "Cherry", "Cloudberry", "Coconut",
                        "Cranberry", "Dragonfruit", "Elderberry", "Goji berry", "Grape", "Raisin", "Grapefruit", "Guava", "Kiwifruit",
                        "Lemon", "Lime", "Mango", "Melon", "Orange", "Papaya", "Passionfruit", "Peach,Pear", "Plum", "Pineapple", "Pomelo",
                        "Raspberry", "Tamarind"},
                {"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Croatia", "Czech Republic",
                        "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Latvia",
                        "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Netherlands", "Norway", "Poland",
                        "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden",
                        "Switzerland", "Ukraine", "United Kingdom"},
                {"Tirana", "Andorra la Vella", "Yerevan", "Vienna", "Baku", "Minsk", "Brussels", "Sarajevo", "Sofia", "Zagreb", "Nicosia",
                        "Prague", "Copenhagen", "Tallinn", "Helsinki", "Paris", "Tbilisi", "Berlin", "Athens", "Budapest", "Reykjavík", "Dublin",
                        "Rome", "Pristina", "Riga", "Vaduz", "Vilnius", "Luxembourg", "Skopje", "Valletta", "Chişinău", "Monaco", "Podgorica",
                        "Amsterdam", "Oslo", "Warsaw", "Lisbon", "Bucharest", "Moscow", "San Marino", "Belgrade", "Bratislava", "Ljubljana",
                        "Madrid", "Stockholm", "Bern", "Ankara", "Kiev", "London", "Vatican City"},
        };

        int randomNumber = (int) (Math.random() * wordPool[wordGroup].length);
        return wordPool[wordGroup][randomNumber].toLowerCase();
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
                System.out.println();
                player.wordCategory();
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


    public void wordCategory() {
        clearScreen();
        Terminal player = new Terminal();
        Game play = new Game();
        Scanner input = new Scanner(System.in);
        System.out.println("Please select a number from the given options");
        System.out.println("1. Fruits");
        System.out.println("2. Countries in Europe");
        System.out.println("3. Capital in Europe");
        char wordGroup = input.next().charAt(0);

        switch(wordGroup){
            case '1': {
                String randomWord = player.chooseRandomWord(0);
                play.game(randomWord);
                break;
            }
            case '2': {
                String randomWord = player.chooseRandomWord(1);
                play.game(randomWord);
                break;
            }
            case '3': {
                String randomWord = player.chooseRandomWord(2);
                play.game(randomWord);
                break;
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
                System.out.println();
                player.wordCategory();
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
        System.out.println(BLACK_BOLD + BACKGROUND_WHITE + "See You Later Alligator!");
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
        String format = "%1$-40s %2$-10s\n";
        System.out.println(BACKGROUND_WHITE + ANSI_BLACK);
        System.out.format(format, " ", "██╗  ██╗ █████╗ ███╗   ██╗ ██████╗ ███╗   ███╗ █████╗ ███╗   ██╗");
        System.out.format(format, " ", "██║  ██║██╔══██╗████╗  ██║██╔════╝ ████╗ ████║██╔══██╗████╗  ██║");
        System.out.format(format, " ", "███████║███████║██╔██╗ ██║██║  ███╗██╔████╔██║███████║██╔██╗ ██║");
        System.out.format(format, " ", "██╔══██║██╔══██║██║╚██╗██║██║   ██║██║╚██╔╝██║██╔══██║██║╚██╗██║");
        System.out.format(format, " ", "██║  ██║██║  ██║██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚████║");
        System.out.format(format, " ", "╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝");

    }


    public void printAligator(){
        String format = "%1$-50s %2$-10s\n";
        System.out.println(BACKGROUND_WHITE + ANSI_GREEN);
        System.out.format(format, " ", "            .-._   _ _ _ _ _ _ _ _       ");
        System.out.format(format, " ", " .-''-.__.-'00  '-' ' ' ' ' ' ' ' '-.    ");
        System.out.format(format, " ", "'.___ '    .   .--_'-' '-' '-' _'-' '._  ");
        System.out.format(format, " ", " V: V 'vv-'   '_   '.       .'  _..' '.'.");
        System.out.format(format, " ", "   '=.____.=_.--'   :_.__.__:_   '.   : :");
        System.out.format(format, " ", "           (((____.-'        '-.  /   : :");
        System.out.format(format, " ", "                             (((-'\\ .' /");
        System.out.format(format, " ", "                           _____..'  .'  ");
        System.out.format(format, " ", "                          '-._____.-'    ");
    }

    public void printCelebrate(){
        String format = "%1$-40s %2$-10s\n";
        System.out.println(BACKGROUND_WHITE + ANSI_RED);
        System.out.format(format, " ", "                                 .''.");
        System.out.format(format, " ", "       .''.             *''*    :_\\/_:     . ");
        System.out.format(format, " ", "      :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.");
        System.out.format(format, " ", "  .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-");
        System.out.format(format, " ", " :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'");
        System.out.format(format, " ", " : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *");
        System.out.format(format, " ", "  '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____");
        System.out.format(format, " ", "      *        __*..* |  |     :      |.   |' .---''|");
        System.out.format(format, " ", "       _*   .-'   '-. |  |     .--'|  ||   | _|    |");
        System.out.format(format, " ", "    .-'|  _.|  |    ||   '-__  |   |  |    ||      |");
        System.out.format(format, " ", "    |' | |.    |    ||       | |   |  |    ||      |");
        System.out.format(format, " ", " ___|  '-'     '    ''       '-'   '-.'    '`      |____");
        System.out.format(format, " ", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void printGhost(){
        String format = "%1$-60s %2$-10s\n";
        System.out.println(BACKGROUND_WHITE + ANSI_BLUE);
        System.out.format(format, " ", "    .-----.");
        System.out.format(format, " ", "   .' -   - '.");
        System.out.format(format, " ", "  /  .-. .-.  \\");
        System.out.format(format, " ", "  |  | | | |  |");
        System.out.format(format, " ", "   \\ \\o/ \\o/ /");
        System.out.format(format, " ", "  _/    ^    \\_");
        System.out.format(format, " ", " | \\  '---'  / |");
        System.out.format(format, " ", " / /`--. .--`\\ \\");
        System.out.format(format, " ", "/ /'---` `---'\\ \\");
        System.out.format(format, " ", "'.__.       .__.'");
        System.out.format(format, " ", "    `|     |`");
        System.out.format(format, " ", "     |     \\");
        System.out.format(format, " ", "     \\      '--.");
        System.out.format(format, " ", "      '.        `\\");
        System.out.format(format, " ", "        `'---.   |");
        System.out.format(format, " ", "           ,__) /");
        System.out.format(format, " ", "            `..'");
    }

    public void drawHangman(){
        String format = "%1$-60s %2$-10s\n";
        System.out.println(BACKGROUND_WHITE + BLINK + ANSI_BLACK);
        System.out.format(format, " ", " ___________.._______");
        System.out.format(format, " ", "| .__________))______|");
        System.out.format(format, " ", "| | / /      ||");
        System.out.format(format, " ", "| |/ /       ||");
        System.out.format(format, " ", "| | /        ||.-''.");
        System.out.format(format, " ", "| |          ||  `/,|");
        System.out.format(format, " ", "| |          (\\\\`_.'");
        System.out.format(format, " ", "| |         .-`--'.");
        System.out.format(format, " ", "| |        /Y . . Y\\");
        System.out.format(format, " ", "| |       // |   | \\\\");
        System.out.format(format, " ", "| |      //  | . |  \\\\");
        System.out.format(format, " ", "| |     ')   |   |   (`");
        System.out.format(format, " ", "| |          ||'||");
        System.out.format(format, " ", "| |          || ||");
        System.out.format(format, " ", "| |          || ||");
        System.out.format(format, " ", "| |          || ||");
        System.out.format(format, " ", "| |         / | | \\");
        System.out.format(format, " ", "----------|_`-' `-' |---|");
        System.out.format(format, " ", "|-|-------\\ \\       '-|-|");
        System.out.format(format, " ", "| |        \\ \\        | |");
        System.out.format(format, " ", ": :         \\ \\       : :");
        System.out.format(format, " ", ". .          `'       . .");
    }

    public void drawKeyboard(){
        char[][] keys = new char[][]{
            {'Q', 'W', 'E', 'R', 'T', 'Z', 'U'}, {'I', 'O', 'P', 'A', 'S', 'D'},
                {'F', 'G', 'H', 'J', 'K', 'L', 'Y'}, {'X', 'C', 'V', 'B', 'N', 'M'}
        };
        for (int i = 0; i < keys.length; i++){
            System.out.println();
            System.out.print("  ");
            for (int j = 0; j < keys[i].length; j++){
                if (i == 0 && j == 0){
                System.out.print(BACKGROUND_YELLOW + keys[i][j] + BACKGROUND_WHITE + "  ");
            }else{
                System.out.print(keys[i][j] + "  ");
                }
            }
        }
        System.out.println();
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
    public static final String BACKGROUND_YELLOW = "\u001b[43;1m";
    public static final String INVISIBLE_TEXT = "\u001B[8m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
}
