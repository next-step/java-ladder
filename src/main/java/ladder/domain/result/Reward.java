package ladder.domain.result;

import ladder.domain.participants.Position;

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
}
