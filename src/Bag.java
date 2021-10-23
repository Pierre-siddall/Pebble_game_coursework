import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {

    private String title;
    private ArrayList<Integer> contents= new ArrayList<Integer>();
    private AtomicInteger sizeOfBag = new AtomicInteger(contents.size());
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

    public void readFile(String filename){
        try {
            Scanner reader = new Scanner(new File(filename));
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                //adds to contents
            }
            reader.close();
        }catch (Exception e){
        }
    }

    public enum States{
        FULL,EMPTY
    }

    public Bag(String title) {
        this.title=title;
    }
}
