package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.point.Direction;

import java.util.stream.Collectors;

public class LineFormatter implements Formatter<Line> {

    private final Formatter<Direction> directionFormatter;

    private LineFormatter(final Formatter<Direction> directionFormatter) {
        this.directionFormatter = directionFormatter;
    }

    public static LineFormatter withDirectionFormatter(final Formatter<Direction> directionFormatter) {
        return new LineFormatter(directionFormatter);
    }

    @Override
    public String format(final Line line) {
        return line.getDirections()
                .stream()
                .map(directionFormatter::format)
                .collect(Collectors.joining());
    }
}
