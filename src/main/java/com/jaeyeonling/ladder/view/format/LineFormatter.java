package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Line;

public class LineFormatter implements Formatter<Line> {

    private final Formatter<Boolean> pointFormatter;

    private LineFormatter(final Formatter<Boolean> pointFormatter) {
        this.pointFormatter = pointFormatter;
    }

    public static LineFormatter of(final Formatter<Boolean> pointFormatter) {
        return new LineFormatter(pointFormatter);
    }

    @Override
    public String format(final Line line) {
        return null;
    }
}
