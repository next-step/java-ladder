package ladder.domain.result;

public class Item {

    private final String prize;

    public Item(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return prize;
    }
}
