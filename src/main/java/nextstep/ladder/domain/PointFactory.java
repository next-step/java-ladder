package nextstep.ladder.domain;

import nextstep.util.RandomGenerator;

public final class PointFactory {
    private PointFactory() {
    }

    private static boolean isFirst(final int index) {
        return index == 0;
    }

    private static boolean isLast(final int index, final int size) {
        return index == size - 1;
    }

    public static Point create(final Point previousPoint, final int index, final int size) {
        final boolean isConnected = RandomGenerator.generate();

        if (isFirst(index)) {
            return Point.first(size, isConnected);
        }
        if (isLast(index, size)) {
            return previousPoint.last();
        }
        return previousPoint.next(isConnected);
    }
}
