package ladder.domain;

import java.util.List;

public class PathPosition {

    public static final int START_POSITION = 0;
    private final Position playerPosition;
    private final Position leftPath;
    private final Position rightPath;

    private final Line line;

    private PathPosition(Position playerPosition, Line line) {
        this.playerPosition = Position.from(playerPosition.value());
        this.leftPath = playerPosition.left();
        this.rightPath = Position.from(playerPosition.value());
        this.line = line;
    }

    public static PathPosition of(int playerPosition, List<Boolean> line) {
        return new PathPosition(Position.from(playerPosition), Line.of(line.size(), size -> line));
    }

    public static PathPosition of(Position playerPosition, Line line) {
        return new PathPosition(playerPosition, line);
    }

    public Position move() {
        if (movableLeft()) {
            return playerPosition.left();
        }

        if (movableRight()) {
            return playerPosition.right();
        }

        return Position.from(playerPosition.value());
    }

    private boolean movableLeft() {
        if (leftPath.value() < START_POSITION) {
            return false;
        }

        if (!movablePath(leftPath)) {
            return false;
        }

        return true;
    }

    private boolean movableRight() {
        if (rightPath.value() > endPosition()) {
            return false;
        }

        if (!movablePath(rightPath)) {
            return false;
        }

        return true;
    }

    private int endPosition() {
        return line.size() - 1;
    }

    private boolean movablePath(Position position) {
        return line.getByPosition(position);
    }
}
