package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.Lines;

import java.util.stream.Collectors;

public class LinesFormatter implements Formatter<Lines> {

    private static final String NEW_LINE = System.lineSeparator();

    private final Formatter<Line> lineFormatter;

    private LinesFormatter(final Formatter<Line> lineFormatter) {
        this.lineFormatter = lineFormatter;
    }

    public static LinesFormatter withLineFormatter(final Formatter<Line> lineFormatter) {
        return new LinesFormatter(lineFormatter);
    }

    @Override
    public String format(final Lines lines) {
        return lines.stream()
                .map(lineFormatter::format)
                .collect(Collectors.joining(NEW_LINE));
    }
}
