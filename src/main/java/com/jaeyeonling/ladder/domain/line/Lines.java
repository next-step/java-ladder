package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Index;
import com.jaeyeonling.ladder.view.StringVisualizable;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class Lines implements StringVisualizable {

    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }

    public Index ride(Index index) {
        for (final Line line : lines) {
            index = line.move(index);
        }

        return index;
    }

    @Override
    public String visualize() {
        return lines.stream()
                .map(Line::visualize)
                .collect(joining(lineSeparator()));
    }
}
