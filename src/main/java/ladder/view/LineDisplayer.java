package ladder.view;

import static ladder.domain.Point.*;

import java.util.List;
import java.util.function.Consumer;

import ladder.domain.Line;
import ladder.domain.Point;

public class LineDisplayer implements Displayer {
    private final List<Line> lines;
    private final int displaySize;

    public LineDisplayer(final List<Line> lines, final int displaySize) {
        this.lines = lines;
        this.displaySize = displaySize;
    }

    @Override
    public void show(final Consumer<String> display) {
        for (Line line : lines) {
            display.accept(makeSingleLine(line.getPoints()));
        }
    }
    
    String makeSingleLine(final List<Point> points) {
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
