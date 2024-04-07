package ladder.domain.result;

import ladder.domain.participants.Position;

import java.util.Objects;

public class Reward {

    private final Prize prize;
    private final Position position;

    public Reward(String item, int index) {
        this(new Prize(item), new Position(index));
    }

    public Reward(Prize prize, Position position) {
        this.prize = prize;
        this.position = position;
    }

    public Prize getItem() {
        return prize;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        Reward reward = (Reward) o;
        return Objects.equals(prize, reward.prize) && Objects.equals(position, reward.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, position);
    }
}
