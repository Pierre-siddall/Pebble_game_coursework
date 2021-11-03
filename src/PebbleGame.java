import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PebbleGame {
    Bag[] blackBags = {new Bag("A"), new Bag("B"), new Bag("C")};
    Bag[] whiteBags = {new Bag("X"), new Bag("Y"), new Bag("Z")};


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
        System.out.print("and then for the location of three files in turn containing comma seperated \n integer values for the Pebble weights \n");
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

        showWelcomeMessage();
        checkPlayerInput(playerNo, p);
        generateBags(blackBags);
    }

    public class Player implements Runnable {
        private final String playerName;
        private final int handSize = 0;
        private final ArrayList<Integer> hand = new ArrayList<Integer>();

        public Player(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerName() {
            return playerName;
        }

        public synchronized void initialHand(Bag[] bagArray) {
            for (int i = 0; i < 10; i++) {
                draw(bagArray);
            }
        }

        public synchronized void draw(Bag[] bagArray) {
            try {
                //Chooses a random black bag
                Random aRand = new Random();
                int index = aRand.nextInt(3);
                Bag b = bagArray[index];
                //Chooses a random Pebble from selected bag
                Random bRand = new Random();
                int pebbleIndex = bRand.nextInt(b.getContentLength());
                //TODO- Get the whiteBags array and pass it to the function
                checkEmptyBag(b);
                hand.add(b.getContents().get(pebbleIndex));
                checkHand();
            } catch (RuntimeException e) {
            }
        }

        public synchronized void deposit(Bag[] bagArray) {
            try {
                if (hand.size() <= 0) {
                } else {
                    Random hRand = new Random();
                    int hIndex = hRand.nextInt();

                    if (hand.get(hIndex).getDrawBag().equals("A")) {
                        bagArray[0].getContents().add(hand.remove(hIndex));

                    } else if (hand.get(hIndex).getDrawBag().equals("B")) {
                        bagArray[1].getContents().add(hand.remove(hIndex));

                    } else if (hand.get(hIndex).getDrawBag().equals("C")) {
                        bagArray[3].getContents().add(hand.remove(hIndex));
                    }
                }
            } catch (RuntimeException e) {
            }
        }

        public void checkHand() {
            int sum = 0;
            for (int i = 0; i < getHandSize(); i++) {
                sum += hand.get(i).getValue();
                if (sum == 100) {
                    //All other players are flagged that a player has won
                    // any other game ending features are run after the players are notified
                }
            }
        }

        public void checkEmptyBag(Bag bag, Bag[] bagArray) {
            try {
                if (bag.getContents().size() == 0 && bag.getTitle().equals("A")) {
                    bag.setContents(bagArray[0].getContents());
                } else if (bag.getContents().size() == 0 && bag.getTitle().equals("B")) {
                    bag.setContents(bagArray[1].getContents());
                } else if (bag.getContents().size() == 0 && bag.getTitle().equals("C")) {
                    bag.setContents(bagArray[2].getContents());
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        public int getHandSize() {
            return handSize;
        }

        @Override
        public void run() {
            while (true) {
                draw(blackBags);
                deposit(whiteBags);
            }
        }
    }
}
