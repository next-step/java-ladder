package nextstep.ladder.model;

import nextstep.ladder.generator.LineGenerator;

public class Point {

    private final Index index;
    private final boolean active;

    public Point(Index index, boolean active) {
        this.index = index;
        this.active = active;
    }

    public Point next(LineGenerator generator) {
        return new Point(index.next(), generator.generate(active));
    }

    public boolean isActive() {
        return active;
    }
}
