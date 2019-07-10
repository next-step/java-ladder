package nextstep.ladder.view.formatter;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.stream.Collectors;

public class LineFormatter implements Formatter<Line> {
    private final Formatter<Point> pointFormatter;

    public LineFormatter(final Formatter<Point> pointFormatter) {
        this.pointFormatter = pointFormatter;
    }

    @Override
    public String format(final Line line) {
        return line.stream()
                .map(pointFormatter::format)
                .collect(Collectors.joining())
                .trim();
    }
}
