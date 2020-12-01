package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {

    public static final int LEFT = -1;
    public static final int RIGHT = +1;
    private final List<Boolean> spoke;

    public Line(List<Boolean> spoke) {
        this.spoke = spoke;
    }

    public boolean hasSpokeRightSide(Position position) {
        return spoke.get(position.toInt());
    }

    public Stream<Boolean> toSpokeStream() {
        return spoke.stream();
    }

    public Position moveOn(Position from) {
        if (spoke.size() < from.toInt()) {
            throw new OutOfLineException();
        }

        if (spoke.size() == from.toInt()) {
            return moveEdgePosition(from, lastSpoke(), LEFT);
        }

        if (from.toInt() == 0) {
            return moveEdgePosition(from, firstSpoke(), RIGHT);
        }

        Boolean moveLeft = spoke.get(from.toInt() - 1);
        if (moveLeft) {
            return Position.of(from.toInt() + LEFT);
        }

        Boolean moveRight = spoke.get(from.toInt());
        if (moveRight) {
            return Position.of(from.toInt() + RIGHT);
        }

        return from;
    }

    private Boolean firstSpoke() {
        return spoke.get(0);
    }

    private Position moveEdgePosition(Position from, Boolean spokeExists, int direction) {
        if (spokeExists) {
            return Position.of(from.toInt() + direction);
        }
        return from;
    }

    private boolean lastSpoke() {
        return spoke.get(spoke.size() - 1);
    }
}
