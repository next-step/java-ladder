package com.jaeyeonling.ladder.domain.line;

import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }
}
