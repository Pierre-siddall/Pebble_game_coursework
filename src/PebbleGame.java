import java.io.File;
import java.util.Scanner;
public class PebbleGame {

    private Bag[] blackBags= {new Bag("BB1"),new Bag("BB2"),new Bag("BB3")};
    private Bag[] whiteBags={new Bag("WB1"),new Bag("WB2"),new Bag("WB3")};

    public class Player {
        public void draw(Bag chosenBag){
            try{
                return;
            }catch (RuntimeException e){
            }
        }

        public void deposit(){
            try{
                return;
            }catch (RuntimeException e){
            }
        }
    }

    public Bag[] getBlackBags() {
        return blackBags;
    }

    public Bag[] getWhiteBags() {
        return whiteBags;
    }

    public static void main(String[] args){

        Bag[] blackBags= {new Bag("BB1"),new Bag("BB2"),new Bag("BB3")};
        Bag[] whiteBags={new Bag("WB1"),new Bag("WB2"),new Bag("WB3")};
        int playerNo = 0;

        System.out.println("Welcome to the PebbleGame!!");
        System.out.println("You will be asked to enter the number of players");
        System.out.print("and then for the location of three files in turn containing comma seperated \n integer values for the pebble weights \n");
        System.out.println("THe integer values must be strictly positive.");
        System.out.println("The game will then be simulate, and output written to files in this director");
        Scanner playerInput = new Scanner(System.in);

        // Check if user has inputted negative numbers
        while (playerNo <= 0){
            System.out.println("Please enter the number of players ");
            playerNo = playerInput.nextInt();
        }
        // Create new players

        for (int i = 0; i < 3; i++){
            String fileName="";
            File f= new File(fileName);
            while(!f.exists()){
                Scanner fileInput = new Scanner(System.in);
                System.out.println("Please enter the location of Bag number " + i + " to load:");
                fileName = fileInput.nextLine(); //Read in the users input
                if(fileInput.equals('E')|| fileInput.equals('e')){
                    System.exit(0);
                }else{
                    if(blackBags[i].readFile(fileName)){
                        break;
                    }
                }
            }
        }
    }
}
