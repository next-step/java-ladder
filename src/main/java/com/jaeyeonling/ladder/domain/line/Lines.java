package com.jaeyeonling.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
