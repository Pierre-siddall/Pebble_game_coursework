import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
public class PebbleGameTest {

    @Test
    public void generateBags() {
        Bag[] blackBags = {new Bag("BB1"), new Bag("BB2"), new Bag("BB3")};
        PebbleGame.generateBags(blackBags, 3);
        assertEquals(blackBags[0].getContentLength(), 100);
        assertEquals(blackBags[1].getContentLength(), 100);
        assertEquals(blackBags[2].getContentLength(), 100);
    }

    @Test
    public void checkPlayerInput() {
        ArrayList<Thread> p = new ArrayList<>();

        int playerNo = -1;
        InputStream input = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        // Check if user has inputted negative numbers
        while (playerNo <= 0) {
            System.out.println("Please enter the number of players ");
            playerNo = scanner.nextInt();
        }
        for (int i = 0; i < playerNo; i++) {
            Thread player = new Thread(new PebbleGame().new Player("p" + i));
            p.add(player);
        }

        assertEquals(3, p.size());

    }
}