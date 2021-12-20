package nextstep.ladder.model;

import nextstep.ladder.generator.LineGenerator;

public class Point extends Index {

    private static final String MESSAGE_NO_ADJACENT_POINT = "인접한 다리가 있어서는 안됩니다.";

    private final boolean active;

    public Point(int index, boolean active) {
        super(index);
        this.active = active;
    }

    public Point next(LineGenerator generator) {
        boolean nextActive = validationNextPoint(generator.generate(active));
        return new Point(super.index + 1, nextActive);
    }

    private boolean validationNextPoint(boolean next) {
        if (this.active && next) {
            throw new IllegalArgumentException(MESSAGE_NO_ADJACENT_POINT);
        }
        return next;
    }

    public boolean isActive() {
        return active;
    }
}
