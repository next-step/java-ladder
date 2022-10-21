package ladder;

import java.util.List;

@FunctionalInterface
public interface HorizontalLineStrategy {
    boolean drawLine(final int left, final int right, final List<Point> points);
}
