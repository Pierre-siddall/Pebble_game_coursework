import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PebbleGame {
    private static final Bag[] whiteBags = {new Bag("X"), new Bag("Y"), new Bag("Z")};
    private static final Bag[] blackBags = {new Bag("A"), new Bag("B"), new Bag("C")};
    private static boolean won;

    public static void generateBags(Bag[] blackBags, int playerNo) {

        for (int i = 0; i < 3; i++) {
            String fileName = "";
            File f = new File(fileName);
            while (!f.exists()) {
                Scanner fileInput = new Scanner(System.in);
                System.out.println("Please enter the location of Bag number " + i + " to load:");
                fileName = fileInput.nextLine(); //Read in the users input
                if (fileName.equals("E") || fileName.equals("e")) {
                    System.exit(0);
                } else {
                    if (!blackBags[i].readFile(fileName, playerNo)) {
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void checkPlayerInput(ArrayList<Thread> p) {
        int playerNo = -1;
        Scanner playerInput = new Scanner(System.in);
        // Check if user has inputted negative numbers
        while (playerNo <= 0) {
            System.out.println("Please enter the number of players ");
            String playerString = playerInput.nextLine();
            if (playerString.equals("E") || playerString.equals("e")) {
                System.exit(0);
            }
            playerNo = Integer.parseInt(playerString);

        }
        for (int i = 0; i < playerNo; i++) {
            Thread player = new Thread(new PebbleGame().new Player("p" + i));
            p.add(player);
        }
    }

    public static void showWelcomeMessage() {
        System.out.println("Welcome to the PebbleGame!!");
        System.out.println("You will be asked to enter the number of players");
        System.out.print("and then for the location of three files in turn containing comma seperated \n integer values for the Pebble weights \n");
        System.out.println("The integer values must be strictly positive.");
        System.out.println("The game will then be simulate, and output written to files in this director");
    }

    public static void main(String[] args) {
        PebbleGame pg = new PebbleGame();
        pg.playGame();
    }

    public void playGame() {
        ArrayList<Thread> p = new ArrayList<>();

        showWelcomeMessage();
        checkPlayerInput(p);
        generateBags(blackBags, p.size());

        for (int i = 0; i < p.size(); i++) {
            p.get(i).start();
        }
    }


    public class Player implements Runnable {

        private final String logName;
        private final String playerName;
        private final ArrayList<Pebble> hand = new ArrayList<Pebble>();
        public boolean won = false;

        public Player(String playerName) {
            this.playerName = playerName;
            this.logName = playerName + "_output.txt";


        }

        public void writeToFile(String fileName, String lineToWrite) {
            try {
                File file = new File(this.logName);
                FileWriter writer = new FileWriter(file, true);
                writer.write(lineToWrite);
                writer.close();
            } catch (IOException e) {
                System.out.println("A file IO error occurred");
            }
        }

        public String handString() {
            String hand = "";
            for (Pebble p : this.hand) {
                hand += p.getValue() + ",";
            }
            return hand;
        }

        public synchronized void initialHand(Bag[] bagArray) {
            for (int i = 0; i < 10; i++) {
                draw(bagArray);
            }
        }

        public synchronized void draw(Bag[] bagArray) throws RuntimeException {
            //Chooses a random black bag
            Random aRand = new Random();
            int index = aRand.nextInt(3); // 0 1 2
            Bag b = bagArray[index]; // black bags
            //Chooses a random Pebble from selected bag
            Random bRand = new Random();
            int pebbleIndex = bRand.nextInt(b.getContentLength());
            checkEmptyBag(b, whiteBags);
            hand.add(b.getContents().get(pebbleIndex));
            checkHand();

            writeToFile(this.logName, this.playerName + " has drawn a " + b.getContents().get(pebbleIndex).getValue() + " from bag " + b.getTitle() + "\n");
            writeToFile(this.logName, this.playerName + " current hand is " + handString() + "\n");
        }

        public synchronized void deposit(Bag[] bagArray) throws RuntimeException {
            if (hand.size() <= 0) {

            } else {
                Random hRand = new Random();
                int hIndex = hRand.nextInt(hand.size());
                writeToFile(this.logName, this.playerName + " has discarded " + hand.get(hIndex).getValue() + "\n");

                if (hand.get(hIndex).getDrawBag().equals("A")) {
                    bagArray[0].getContents().add(hand.remove(hIndex));


                } else if (hand.get(hIndex).getDrawBag().equals("B")) {
                    bagArray[1].getContents().add(hand.remove(hIndex));

                } else if (hand.get(hIndex).getDrawBag().equals("C")) {
                    bagArray[2].getContents().add(hand.remove(hIndex));
                }
            }

            writeToFile(this.logName, this.playerName + " current hand is " + handString() + "\n");

        }

        public synchronized void checkHand() {
            int sum = 0;
            for (int i = 0; i < hand.size(); i++) {
                sum += hand.get(i).getValue();

            }
            if (sum == 100) {
                PebbleGame.won = true;
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
            }
        }


        @Override
        public void run() {
            initialHand(blackBags);
            while (!PebbleGame.won) {
                deposit(whiteBags);
                draw(blackBags);
            }
        }
    }

}

