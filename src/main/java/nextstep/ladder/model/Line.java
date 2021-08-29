package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }
    }

    public Point getPoint(int index) {
        if (index >= points.size() || index < 0) {
            throw new IllegalArgumentException("잘못된 인덱스를 입력하였습니다. index : " + index);
        }

        return points.get(index);
    }

    public boolean isUsedPoint(int index) {
        return points.get(index).isUsed();
    }

    public void usePointDestination(int destination, int height) {
        Point point = points.get(height);
        point.use(destination);
    }

    public int getHeight() {
        return points.size();
    }
}
