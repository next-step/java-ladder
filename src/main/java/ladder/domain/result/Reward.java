package ladder.domain.result;

import ladder.domain.participants.Position;

import java.util.Objects;

public class Reward {

    private final Item item;
    private final Position position;

    public Reward(String item, int index) {
        this(new Item(item), new Position(index));
    }

    public Reward(Item item, Position position) {
        this.item = item;
        this.position = position;
    }

    public Item getItem() {
        return item;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        Reward reward = (Reward) o;
        return Objects.equals(item, reward.item) && Objects.equals(position, reward.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, position);
    }
}
