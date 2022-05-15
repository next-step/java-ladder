package ladder.domain.reward;

import ladder.domain.player.Name;
import ladder.domain.point.Position;

public class Reward {
    private final Name name;
    private final Position position;

    public Reward(String name, int position) {
        this(Name.valueOf(name), new Position(position));
    }

    public Reward(Name name, Position position) {
        validate(name, position);
        this.name = name;
        this.position = position;
    }

    private void validate(Name name, Position position) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }

        if (position == null) {
            throw new IllegalArgumentException("position은 null 일 수 없습니다.");
        }
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
