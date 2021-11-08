import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bag {

    private final String title;
    private ArrayList<Pebble> contents = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public int getContentLength() {
        return contents.size();
    }

    public ArrayList<Pebble> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Pebble> contents) {
        this.contents = contents;
    }

    public boolean readFile(String filename, int playerNo) {
        ArrayList<Pebble> temporaryArray = new ArrayList<Pebble>();
        try {
            Scanner reader = new Scanner(new File(filename));
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                int pebble = Integer.parseInt(reader.next().trim());
                if (pebble >= 0) {
                    temporaryArray.add(new Pebble(pebble, getTitle()));
                } else {
                    System.out.println("You tried to read a file containing negative integers");
                    return false;
                }
            }
            reader.close();

            if (temporaryArray.size() > playerNo * 11) {
                this.contents = temporaryArray;
                return true;
            }

        } catch (FileNotFoundException e) {
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
                '}';
    }

    public Bag(String title) {
        this.title = title;
    }
}
