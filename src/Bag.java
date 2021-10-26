import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;

public class Bag {

    private final String title;
    private ArrayList<Integer> contents = new ArrayList<Integer>();
    private final AtomicInteger sizeOfBag = new AtomicInteger(contents.size());
    private States bagState;

    // This is a method lol
    public ArrayList<Integer> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Integer> contents) {
        this.contents = contents;
    }

    public States getBagState() {
        return bagState;
    }

    public void setBagState(States bagState) {
        this.bagState = bagState;
    }

    public boolean readFile(String filename){
        try {
            Scanner reader = new Scanner(new File(filename));
            System.out.print("I have read the file\n");
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                System.out.println(reader.next());
                contents.add(Integer.parseInt(reader.next()));
            }
            reader.close();
            return true;
        }catch (Exception e){
            System.out.println("File not found");
        }
        return false;
    }

    public enum States{
        FULL,EMPTY
    }

    public Bag(String title) {
        this.title=title;
    }
}
