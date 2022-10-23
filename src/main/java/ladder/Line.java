package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

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
            boolean connect = isConnect(horizontalLineStrategy, left, right);

            Point prevLeftPoint = points.get(left);
            Point prevRightPoint = points.get(right);

            Point currentLeftPoint = new Point(left, prevLeftPoint.hasLeftLine(), connect);
            Point currentRightPoint = new Point(right, connect, prevRightPoint.hasRightLine());
            points.set(left, currentLeftPoint);
            points.set(right, currentRightPoint);
        }
        return points;
    }

    private List<Point> initializePoints(final int countOfPerson) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(new Point(i, null, null));
        }
        points.set(0, new Point(0, false, null));
        points.set(countOfPerson - 1, new Point(countOfPerson - 1, null, false));
        return points;
    }

    private boolean isConnect(HorizontalLineStrategy horizontalLineStrategy, final int left, final int right) {
        return horizontalLineStrategy.drawLine() && areLinesNotOverlapped(left, right);
    }

    private boolean areLinesNotOverlapped(final int left, final int right) {
        return !points.get(left).hasLeftLine()
                && !points.get(right).hasRightLine();
    }

    public boolean isConnected(int left, int right) {
        return points.get(left).hasRightLine() && points.get(right).hasLeftLine();
    }

}
