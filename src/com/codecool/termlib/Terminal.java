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
    public String chooseRandomWord(int wordGroup) {
        String[][] wordPool = {
                {"Apple", "Apricot", "Avocado", "Banana", "Blackberry", "Blackcurrant", "Blueberry", "Cherry", "Cloudberry", "Coconut",
                        "Cranberry", "Dragonfruit", "Elderberry", "Grape", "Raisin", "Grapefruit", "Guava", "Kiwifruit", "Lemon",
                        "Lime", "Mango", "Melon", "Orange", "Papaya", "Passionfruit", "Peach", "Pear", "Plum", "Pineapple", "Pomelo",
                        "Raspberry", "Tamarind"},
                {"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bulgaria", "Croatia", "Denmark", "Estonia", "Finland", "France",
                        "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg",
                        "Malta", "Moldova", "Monaco", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Russia", "Serbia", "Montenegro",
                        "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Ukraine"},
                {"Tirana", "Yerevan", "Vienna", "Baku", "Minsk", "Brussels", "Sarajevo", "Sofia", "Zagreb", "Nicosia", "Prague", "Copenhagen",
                        "Tallinn", "Helsinki", "Paris", "Tbilisi", "Berlin", "Athens", "Budapest", "Reykjavík", "Dublin", "Rome", "Pristina",
                        "Riga", "Vaduz", "Vilnius", "Luxembourg", "Skopje", "Valletta", "Monaco", "Podgorica", "Amsterdam", "Oslo", "Warsaw",
                        "Lisbon", "Bucharest", "Moscow", "Belgrade", "Bratislava", "Ljubljana", "Madrid", "Stockholm", "Bern", "Ankara", "Kiev",
                        "London"},
                {"Audi", "Bentley", "Benz", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroen", "Corvette", "DAF", "Dacia", "Daewoo",
                        "Daihatsu", "Datsun", "De", "Lorean", "Dino", "Dodge", "Farboud", "Ferrari", "Fiat", "Ford", "Honda", "Hummer", "Hyundai",
                        "Jaguar", "Jeep", "KIA", "Koenigsegg", "Lada", "Lamborghini", "Lancia", "Land", "Rover", "Lexus", "Ligier", "Lincoln", "Lotus",
                        "Martini", "Maserati", "Maybach", "Mazda", "McLaren", "MercedesBenz", "Mini", "Mitsubishi", "Nissan", "Noble", "Opel", "Peugeot",
                        "Pontiac", "Porsche", "Renault", "Rolls", "Royce", "Saab", "Seat", "Skoda", "Smart", "Spyker", "Subaru", "Suzuki", "Toyota", "Vauxhall",
                        "Volkswagen", "Volvo"},
                {"Canidae", "Felidae", "Cat", "Cattle", "Dog", "Donkey", "Goat", "Horse", "Pig", "Rabbit", "Aardvark", "Aardwolf", "Albatross", "Alligator",
                        "Alpaca", "Amphibian", "Anaconda", "Angelfish", "Anglerfish", "Ant", "Anteater", "Antelope", "Antlion", "Ape", "Aphid", "Armadillo",
                        "Asp", "Bandicoot", "Barnacle", "Barracuda", "Basilisk", "Bass", "Bat", "Bear", "Beaver", "Bedbug", "Bee", "Beetle", "Bird", "Bison",
                        "Blackbird", "Boa", "Boar", "Bobcat", "Bobolink", "Bonobo", "Booby", "Bovid", "Bug", "Butterfly", "Buzzard", "Camel", "Canid", "Capybara",
                        "Cardinal", "Caribou", "Carp", "Cat", "Catshark", "Caterpillar", "Catfish", "Cattle", "Centipede", "Cephalopod", "Chameleon", "Cheetah",
                        "Chickadee", "Chicken", "Chimpanzee", "Chinchilla", "Chipmunk", "Clam", "Clownfish", "Cobra", "Cockroach", "Cod", "Condor", "Constrictor",
                        "Coral", "Cougar", "Cow", "Coyote", "Crab", "Crane", "Crawdad", "Crayfish", "Cricket", "Crocodile", "Crow", "Cuckoo", "Cicada", "Damselfly",
                        "Deer", "Dingo", "Dinosaur", "Dog", "Dolphin", "Donkey", "Dormouse", "Dove", "Dragonfly", "Dragon", "Duck", "Eagle", "Earthworm", "Earwig",
                        "Echidna", "Eel", "Egret", "Elephant", "Elk", "Emu", "Ermine", "Falcon", "Ferret", "Finch", "Firefly", "Fish", "Flamingo", "Flea", "Fly",
                        "Flyingfish", "Fowl", "Fox", "Frog", "Gamefowl", "Galliform", "Gazelle", "Gecko", "Gerbil", "Gibbon", "Giraffe", "Goat", "Goldfish", "Goose",
                        "Gopher", "Gorilla", "Grasshopper", "Grouse", "Guan", "Guanaco", "Guineafowl", "Gull", "Guppy", "Haddock", "Halibut", "Hamster", "Hare",
                        "Harrier", "Hawk", "Hedgehog", "Heron", "Herring", "Hippopotamus", "Hookworm", "Hornet", "Horse", "Hoverfly", "Hummingbird", "Hyena", "Iguana",
                        "Impala", "Jackal", "Jaguar", "Jay", "Jellyfish", "Junglefowl", "Kangaroo", "Kingfisher", "Kite", "Kiwi", "Koala", "Koi", "Krill", "Ladybug",
                        "Lamprey", "Lark", "Leech", "Lemming", "Lemur", "Leopard", "Leopon", "Limpet", "Lion", "Lizard", "Llama", "Lobster", "Locust", "Loon", "Louse",
                        "Lungfish", "Lynx", "Macaw", "Mackerel", "Magpie", "Mammal", "Manatee", "Mandrill", "Marlin", "Marmoset", "Marmot", "Marsupial", "Marten",
                        "Mastodon", "Meadowlark", "Meerkat", "Mink", "Minnow", "Mite", "Mockingbird", "Mole", "Mollusk", "Mongoose", "Monkey", "Moose", "Mosquito",
                        "Moth", "Mouse", "Mule", "Muskox", "Narwhal", "Newt", "Opossum", "Orangutan", "Orca", "Ostrich", "Otter", "Owl", "Ox", "Panda", "Panther",
                        "Parakeet", "Parrot", "Parrotfish", "Partridge", "Peacock", "Peafowl", "Pelican", "Penguin", "Pheasant", "Pig", "Pigeon", "Pike", "Pinniped",
                        "Piranha", "Planarian", "Platypus", "Pony", "Porcupine", "Porpoise", "Possum", "Prawn", "Primate", "Ptarmigan", "Puffin", "Puma", "Python",
                        "Quail", "Quelea", "Quokka", "Rabbit", "Raccoon", "Rat", "Rattlesnake", "Raven", "Reindeer", "Reptile", "Rhinoceros", "Roadrunner", "Rodent",
                        "Rook", "Rooster", "Roundworm", "Sailfish", "Salamander", "Salmon", "Sawfish", "Scallop", "Scorpion", "Seahorse", "Shark", "Sheep", "Shrew",
                        "Shrimp", "Silkworm", "Skink", "Skunk", "Sloth", "Slug", "Smelt", "Snail", "Snake", "Snipe", "Sparrow", "Spider", "Spoonbill", "Squid",
                        "Squirrel", "Stingray", "Stoat", "Stork", "Sturgeon", "Swallow", "Swan", "Swift", "Swordfish", "Swordtail", "Tahr", "Takin", "Tapir",
                        "Tarantula", "Tarsier", "Tern", "Thrush", "Tick", "Tiger", "Tiglon", "Toad", "Tortoise", "Toucan", "Tuna", "Turkey", "Turtle", "Tyrannosaurus",
                        "Urial", "Vicuna", "Viper", "Vole", "Vulture", "Wallaby", "Walrus", "Wasp", "Warbler", "Weasel", "Whale", "Whippet", "Whitefish", "Wildcat",
                        "Wildebeest", "Wildfowl", "Wolf", "Wolverine", "Wombat", "Woodpecker", "Worm", "Wren", "Xerinae", "Yak", "Zebra"},

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
        System.out.println("4. Cars");
        System.out.println("5. Animals");
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
            case '4': {
                String randomWord = player.chooseRandomWord(3);
                play.game(randomWord);
                break;
            }
            case '5': {
                String randomWord = player.chooseRandomWord(4);
                play.game(randomWord);
                break;
            }
            default: {
                player.wordCategory();
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
    public static final String WHITE = "\u001B[37m";
}
