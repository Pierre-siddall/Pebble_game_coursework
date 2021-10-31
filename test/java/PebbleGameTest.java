import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PebbleGameTest {

    @Test
    public void generateBags() {
        Bag[] blackBags = {new Bag("BB1"), new Bag("BB2"), new Bag("BB3")};
        PebbleGame.generateBags(blackBags, 3);
        assertEquals(blackBags[0].getContentLength(), 100);
        assertEquals(blackBags[1], 100);
        assertEquals(blackBags[2], 100);
    }

    @Test
    public void checkPlayerInput() {
    }

    @Test
    public void checkBagSize() {
    }
}