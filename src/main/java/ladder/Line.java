package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPerson, HorizontalLineStrategy horizontalLineStrategy) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("사람수는 최소 2명이어야 합니다.");
        }
        points = drawLine(countOfPerson, horizontalLineStrategy);
    }

    private List<Point> drawLine(int countOfPerson, HorizontalLineStrategy horizontalLineStrategy) {
        List<Point> points = initializePoints(countOfPerson);

        for (int right = 1; right < countOfPerson; right++) {
            int left = right - 1;
            boolean connect = horizontalLineStrategy.drawLine() && areLinesNotOverlapped(left, right, points);

            Point prevLeftPoint = points.get(left);
            Point prevRightPoint = points.get(right);

            Point currentLeftPoint = new Point(prevLeftPoint.hasLeftLine(), connect);
            Point currentRightPoint = new Point(connect, prevRightPoint.hasRightLine());
            points.set(left, currentLeftPoint);
            points.set(right, currentRightPoint);
        }
        return points;
    }

    private List<Point> initializePoints(final int countOfPerson) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(new Point(null, null));
        }
        points.set(0, new Point(false, null));
        points.set(countOfPerson - 1, new Point(null, false));
        return points;
    }

    private boolean areLinesNotOverlapped(final int left, final int right, List<Point> points) {
        return !points.get(left).hasLeftLine()
                && !points.get(right).hasRightLine();
    }

    public boolean isConnected(int left, int right) {
        return points.get(left).hasRightLine() && points.get(right).hasLeftLine();
    }

    public int nextVerticalIndex(int currentIndex) {
        if (points.get(currentIndex).hasLeftLine()) {
            return currentIndex - 1;
        }
        if (points.get(currentIndex).hasRightLine()) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

}
