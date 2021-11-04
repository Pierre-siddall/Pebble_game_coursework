import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bag {

    private final String title;
    private ArrayList<Pebble> contents = new ArrayList<Pebble>();
    private States bagState;

    public String getTitle() {
        return title;
    }

    public int getContentLength() {
        return contents.size();
    }

    // This is a method lol
    public ArrayList<Pebble> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Pebble> contents) {
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
                contents.add(new Pebble(Integer.parseInt(reader.next().trim()), getTitle()));
            }
            reader.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return false;
    }

    public enum States {
        FULL, EMPTY
    }

    @Override
    public String toString() {
        return "Bag{" +
                "title='" + title + '\'' +
                ", contents=" + contents +
                ", bagState=" + bagState +
                '}';
    }

    public Bag(String title) {
        this.title = title;
    }
}
