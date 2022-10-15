package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, HorizontalLineStrategy horizontalLineStrategy) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("사람수는 최소 2명이어야 합니다.");
        }
        Boolean[][] points = drawLine(countOfPerson, horizontalLineStrategy);
        for (int i = 0; i < countOfPerson; i++) {
            this.points.add(new Point(i, points[i][0], points[i][1]));
        }
    }

    private Boolean[][] drawLine(int countOfPerson, HorizontalLineStrategy horizontalLineStrategy) {
        Boolean[][] points = new Boolean[countOfPerson][2];
        points[0][0] = false;
        points[countOfPerson - 1][1] = false;
        for (int right = 1; right < countOfPerson; right++) {
            int left = right - 1;
            boolean connect = horizontalLineStrategy.drawLine(left, right, points);
            points[left][1] = connect;
            points[right][0] = connect;
        }
        return points;
    }

    public boolean isConnected(int left, int right) {
        return points.get(left).hasRightLine() && points.get(right).hasLeftLine();
    }

}
