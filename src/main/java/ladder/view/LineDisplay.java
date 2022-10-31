package ladder.view;

import static ladder.domain.Point.*;

import java.util.List;

import ladder.domain.Point;

public class LineDisplay {
    private final int displaySize;

    public LineDisplay(final int displaySize) {
        this.displaySize = displaySize;
    }

    public String show(final List<Point> points) {
        StringBuilder line = new StringBuilder();
        for (Point point : points) {
            line.append(symbol(point));
        }
        return line.toString();
    }

    private String symbol(final Point point) {
        if (VERTICAL_LINE == point) {
            return "|";
        }
        if (HORIZON == point) {
            return repeat("-");
        }
        return repeat(" ");
    }

    private String repeat(final String symbol) {
        StringBuilder display = new StringBuilder();
        display.append(symbol.repeat(Math.max(0, displaySize)));
        return display.toString();
    }
}
