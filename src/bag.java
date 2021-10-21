import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class bag {
    private ArrayList<Integer> contents= new ArrayList<Integer>();
    private AtomicInteger sizeOfBag = new AtomicInteger(contents.size());
    private Boolean full;
    private Boolean empty;

    public ArrayList<Integer> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Integer> contents) {
        this.contents = contents;
    }

    public Boolean getFull() {
        return full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public bag(Boolean full, Boolean empty) {
        this.full = full;
        this.empty = empty;
    }
}
