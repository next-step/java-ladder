package ladder.domain.result;

import java.util.Objects;

public class Item {

    private final String prize;

    public Item(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(prize, item.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
