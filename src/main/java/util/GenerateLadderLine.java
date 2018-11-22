package util;

import domain.Line;
import domain.Point;

public class GenerateLadderLine implements GenerateLine {

    @Override
    public Point fromRandom() {
        return RandomUtil.generate() ? Point.EXIST : Point.NONE;
    }

    @Override
    public Point fromMiddle(final Line line, final int sequence) {

        final boolean existence = line.isExistence(sequence);
        final Point point = existence ? Point.NONE : RandomUtil.generate() ? Point.EXIST : Point.NONE;

        validation(existence, point);

        return point;
    }

    @Override
    public Point fromLast() {
        return Point.NONE;
    }

    private void validation(final boolean existence, final Point point) {
        if (existence && point.isExistence()) {
            throw new IllegalStateException("The ladder is connected continuously. Invalid state.");
        }
    }

}
