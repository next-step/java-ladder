package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Point> pointList = new ArrayList<>();

    private final Random random = new Random();

    public Line(int pointCount) {
        if(pointCount <= 0){
            throw new IllegalArgumentException("0 보다 커야 합니다.");
        }
        createPointList(pointCount);
    }

    private void createPointList(int pointCount) {
        for (int i = 0; i < pointCount; i++) {
            pointList.add(nextPoint());
        }
    }

    private Point nextPoint() {
        if (isFirstPoint()) {
            return Point.emptyPoint();
        }
        Point previousPoint = pointList.get(pointList.size() - 1);
        if (previousPoint.isFilled()) {
            return Point.emptyPoint();
        }
        return new Point(random.nextBoolean());
    }

    private boolean isFirstPoint() {
        return pointList.size() == 0;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public int pointListSize() {
        return pointList.size();
    }

    public boolean isFilledAt(int index) {
        return pointList.get(index).isFilled();
    }
}
