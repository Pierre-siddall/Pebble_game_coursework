import java.util.Scanner;
public class pebbleGame {
    public class player{
        public void draw(){
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
    public static void main(String[] args){
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


    }
}
