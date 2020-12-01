package nextstep.ladder.domain;

import java.util.stream.Stream;

public class Line implements Moveable {

    public static final int LEFT = -1;
    public static final int RIGHT = +1;
    private final Spoke spoke;

    public Line(Spoke spoke) {
        this.spoke = spoke;
    }

    public Stream<Boolean> toSpokeStream() {
        return spoke.stream();
    }

    @Override
    public Position moveOn(Position position) {
        ensureLineBoundaryIn(position);

        if (isRightEdge(position)) {
            return movePosition(position, spoke.last(), LEFT);
        }

        if (isLeftEdge(position)) {
            return movePosition(position, spoke.first(), RIGHT);
        }

        if (spoke.isLeftMovable(position)) {
            return position.move(LEFT);
        }

        if (spoke.isRightMovable(position)) {
            return position.move(RIGHT);
        }

        return position;
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

    private Position movePosition(Position position, Boolean spokeExists, int direction) {
        if (spokeExists) {
            return position.move(direction);
        }
        return position;
    }

}
