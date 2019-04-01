package domain.ladder;

import domain.player.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Point {

    private static final String BOUNDARY = "|";

    private static final String NOT_CONNECTED = " ";

    private static final String CONNECTED = "-";

    private final int position;

    private final Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int move() {
        return direction.move(this.position);
    }

    public String beautify() {
        int length = Player.MAX_NAME_LENGTH + 1;
        if (position == 0) {
            length--;
        }

        return StringUtils.leftPad(BOUNDARY, length, direction == Direction.LEFT ? CONNECTED : NOT_CONNECTED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
