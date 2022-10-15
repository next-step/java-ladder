package ladder;

import java.util.Random;

public class HorizontalLineRandomStrategy implements HorizontalLineStrategy {
    private static int RANDOM_THRESHOLD = 4;
    private static int RANDOM_MAX = 10;

    @Override
    public boolean drawLine(final int left, final int right, final Boolean[][] points) {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX) > RANDOM_THRESHOLD && areLinesNotOverlapped(left, right, points);
    }

    private boolean areLinesNotOverlapped(final int left, final int right, final Boolean[][] points) {
        return (points[left][0] == null || !points[left][0])
                && (points[right][1] == null || !points[right][1]);
    }

}
