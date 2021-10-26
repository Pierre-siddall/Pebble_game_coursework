import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {

    private final String title;
    private ArrayList<Integer> contents = new ArrayList<Integer>();
    private final AtomicInteger sizeOfBag = new AtomicInteger(contents.size());
    private States bagState;

    public int getContentLength() {
        return getContents().size();
    }

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

    public Boolean readFile(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                //System.out.println(reader.next());
                contents.add(Integer.parseInt(reader.next().trim()));
            }
            reader.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

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
