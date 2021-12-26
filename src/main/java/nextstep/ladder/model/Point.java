package nextstep.ladder.model;

import nextstep.ladder.generator.LineGenerator;

import java.util.Objects;

public class Point {

    private static final String MESSAGE_NO_ADJACENT_POINT = "인접한 다리가 있어서는 안됩니다.";

    private Index index;
    private final boolean active;

    public Point(Index index, boolean active) {
        this.index = index;
        this.active = active;
    }

    public Point next(LineGenerator generator) {
        boolean nextActive = validationNextPoint(generator.generate(active));
        return new Point(index.next(), nextActive);
    }

    private boolean validationNextPoint(boolean next) {
        if (this.active && next) {
            throw new IllegalArgumentException(MESSAGE_NO_ADJACENT_POINT);
        }
        return next;
    }

    public Index getIndex() {
        return index;
    }

    public boolean isActive() {
        return active;
    }
}
