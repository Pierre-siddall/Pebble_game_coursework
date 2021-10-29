import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PebbleGame {


    public static void generateBags(Bag[] blackBags) {
        for (int i = 0; i < 3; i++) {
            String fileName = "";
            File f = new File(fileName);
            while (!f.exists()) {
                Scanner fileInput = new Scanner(System.in);
                System.out.println("Please enter the location of Bag number " + i + " to load:");
                fileName = fileInput.nextLine(); //Read in the users input
                if (fileInput.equals('E') || fileInput.equals('e')) {
                    System.exit(0);
                } else {
                    if (blackBags[i].readFile(fileName)) {
                        break;
                    }
                }
            }
        }
    }

    public static void showWelcomeMessage() {
        System.out.println("Welcome to the PebbleGame!!");
        System.out.println("You will be asked to enter the number of players");
        System.out.print("and then for the location of three files in turn containing comma seperated \n integer values for the pebble weights \n");
        System.out.println("The integer values must be strictly positive.");
        System.out.println("The game will then be simulate, and output written to files in this director");
    }

    public static void checkPlayerInput(int playerNo, ArrayList<Player> p) {
        Scanner playerInput = new Scanner(System.in);

        // Check if user has inputted negative numbers
        while (playerNo <= 0) {
            System.out.println("Please enter the number of players ");
            playerNo = playerInput.nextInt();
        }
        for (int i = 0; i < playerNo; i++) {
            Player player = new PebbleGame().new Player("p" + i);
            p.add(player);
        }
    }

    public static void main(String[] args) {
        Bag[] blackBags = {new Bag("BB1"), new Bag("BB2"), new Bag("BB3")};
        Bag[] whiteBags = {new Bag("WB1"), new Bag("WB2"), new Bag("WB3")};
        int playerNo = 0;
        // TODO check if the "black bag contains at least 11 times as many pebbles as players"
        showWelcomeMessage();
        checkPlayerInput(playerNo, p);
        generateBags(blackBags);
    }

    public class Player implements Runnable {
        private final String playerName;

        public Player(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void draw(Bag chosenBag) {
            try {
                return;
            } catch (RuntimeException e) {
            }
        }

        public void deposit() {
            try {
                return;
            } catch (RuntimeException e) {
            }
        }

        @Override
        public void run() {

        }
    }
}
