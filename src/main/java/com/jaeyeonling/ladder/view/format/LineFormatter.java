package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.line.Line;

import java.util.stream.Collectors;

public class LineFormatter implements Formatter<Line> {

    private final Formatter<Boolean> pointFormatter;

    private LineFormatter(final Formatter<Boolean> pointFormatter) {
        this.pointFormatter = pointFormatter;
    }

    public static LineFormatter withPointFormatter(final Formatter<Boolean> pointFormatter) {
        return new LineFormatter(pointFormatter);
    }

    @Override
    public String format(final Line line) {
        return line.getPoints()
                .stream()
                .map(pointFormatter::format)
                .collect(Collectors.joining());
    }
}
