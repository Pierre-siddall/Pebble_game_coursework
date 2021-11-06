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

    // This is a method lol
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
                temporaryArray.add(new Pebble(Integer.parseInt(reader.next().trim()), getTitle()));
            }
            reader.close();

            System.out.println(playerNo * 11);

            if (temporaryArray.size() > playerNo * 11) {
                System.out.println("I run correctly");
                this.contents = temporaryArray;
                return true;
            }

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
                '}';
    }

    public Bag(String title) {
        this.title = title;
    }
}
