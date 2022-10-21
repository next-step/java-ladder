package ladder;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HorizontalLineRandomStrategy implements HorizontalLineStrategy {
    private static final int RANDOM_THRESHOLD = 4;
    private static final int RANDOM_MAX = 10;

    @Override
    public boolean drawLine(final int left, final int right, final List<Point> points) {
        return ThreadLocalRandom.current().nextInt(RANDOM_MAX) > RANDOM_THRESHOLD
                && areLinesNotOverlapped(left, right, points);
    }

    private boolean areLinesNotOverlapped(final int left, final int right, final List<Point> points) {
        return !points.get(left).hasLeftLine()
                && !points.get(right).hasRightLine();
    }

}
