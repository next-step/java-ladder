package ladder.domain.player;

import ladder.domain.point.Direction;
import ladder.domain.point.Point;
import ladder.domain.point.Position;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int position) {
        this(Name.valueOf(name), new Position(position));
    }

    public Player(Name name, Position position) {
        validate(name, position);
        this.position = position;
        this.name = name;
    }

    private void validate(Name name, Position position) {
        if (name == null) {
            throw new IllegalArgumentException("name은 null 일 수 없습니다.");
        }

        if (position == null) {
            throw new IllegalArgumentException("position은 null 일 수 없습니다.");
        }
    }

    public Player move(Direction direction) {
        return new Player(
                name,
                position.move(direction)
        );
    }

    public boolean isOnPoint(Point point) {
        return point.isSamePosition(position);
    }

    public boolean isSameName(Name name) {
        return this.name.equals(name);
    }

    public Position position() {
        return position;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
