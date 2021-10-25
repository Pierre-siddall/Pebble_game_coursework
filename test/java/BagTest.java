import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Test
    public void getContents() {
        Bag b = new Bag("T1");
    }

    @Test
    public void setContents() {
        Bag b = new Bag("T2");

    }

    @Test
    public void getBagState() {
        Bag b = new Bag("T3");
        Bag b2 = new Bag("T4");
        b.setBagState(Bag.States.EMPTY);
        b2.setBagState(Bag.States.FULL);
        assertEquals(Bag.States.EMPTY, b.getBagState());
        assertEquals(Bag.States.FULL, b2.getBagState());
    }

    @Test
    public void setBagState() {
        Bag b = new Bag("T4");

    }

    @Test
    public void readFile() {
        Bag b = new Bag("T5");
    }
}