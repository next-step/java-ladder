package nextstep.ladder.domain.lines.point.impl;

import nextstep.ladder.domain.lines.point.Point;

public class PointImpl implements Point {

    private final boolean value;

    public PointImpl(boolean value) {
        this.value = value;
    }

    @Override
    public Point decideNextPoint(Boolean randomBoolean) {
        if (!value) {
            return new PointImpl(randomBoolean);
        }
        return new PointImpl(false);
    }

    @Override
    public boolean isPointFalse() {
        return !value;
    }

    @Override
    public boolean isPointTrue() {
        return value;
    }
}
