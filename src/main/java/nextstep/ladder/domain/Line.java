package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {

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
            return moveWithSpoke(from, lastSpoke(), - 1);
        }

        if (from.toInt() == 0) {
            return moveWithSpoke(from, firstSpoke(), + 1);
        }

        Boolean moveLeft = spoke.get(from.toInt() - 1);
        if (moveLeft) {
            return Position.of(from.toInt() - 1);
        }

        Boolean moveRight = spoke.get(from.toInt());
        if (moveRight) {
            return Position.of(from.toInt() + 1);
        }

        return from;
    }

    private Boolean firstSpoke() {
        return spoke.get(0);
    }

    private Position moveWithSpoke(Position from, Boolean spokeExists, int amount) {
        if (spokeExists) {
            return Position.of(from.toInt() + amount);
        }
        return from;
    }

    private boolean lastSpoke() {
        return spoke.get(spoke.size() - 1);
    }
}
