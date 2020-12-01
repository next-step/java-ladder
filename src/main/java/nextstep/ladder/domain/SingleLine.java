package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class SingleLine implements Line {

    public static final int LEFT = -1;
    public static final int RIGHT = +1;
    private final List<Boolean> spoke;

    public SingleLine(List<Boolean> spoke) {
        this.spoke = spoke;
    }

    public Stream<Boolean> toSpokeStream() {
        return spoke.stream();
    }

    @Override
    public Position moveOn(Position from) {
        ensureLineBoundaryIn(from);

        if (isRightEdge(from)) {
            return movePosition(from, getLastSpoke(), LEFT);
        }

        if (isLeftEdge(from)) {
            return movePosition(from, getFirstSpoke(), RIGHT);
        }

        if (isMoveLeft(from)) {
            return from.move(LEFT);
        }

        if (isMoveRight(from)) {
            return from.move(RIGHT);
        }

        return from;
    }

    private boolean isLeftEdge(Position position) {
        return position.isEqualsValue(0);
    }

    private boolean isRightEdge(Position position) {
        return position.isEqualsValue(spoke.size());
    }

    private void ensureLineBoundaryIn(Position from) {
        if (spoke.size() < from.toInt()) {
            throw new OutOfLineException();
        }
    }

    private Boolean isMoveRight(Position from) {
        return spoke.get(from.toInt());
    }

    private Boolean isMoveLeft(Position from) {
        return spoke.get(from.toInt() - 1);
    }

    private Boolean getFirstSpoke() {
        return spoke.get(0);
    }

    private Position movePosition(Position position, Boolean spokeExists, int direction) {
        if (spokeExists) {
            return position.move(direction);
        }
        return position;
    }

    private boolean getLastSpoke() {
        return spoke.get(spoke.size() - 1);
    }
}
