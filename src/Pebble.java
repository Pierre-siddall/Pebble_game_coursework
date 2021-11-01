public class Pebble {
    private final Integer value;
    private final String drawBag;

    public Pebble(int value, String drawBag) {
        this.value = value;
        this.drawBag = drawBag;
    }

    public Integer getValue() {
        return value;
    }

    public String getDrawBag() {
        return drawBag;
    }
}
