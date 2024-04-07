package ladder.domain.ladder;

import ladder.domain.ladder.point.PointAddStrategy;
import ladder.domain.ladder.point.PointEnum;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<PointEnum> points;

    public Line(int countOfPerson, PointEnum point) {
        this.points = new ArrayList<>();
        points.add(point);
        for (int i = 1; i < countOfPerson - 1; i++) {
            pointsAdd(points, i);
        }
    }

    public Line(List<PointEnum> points) {
        this.points = points;
    }

    public static Line createPointLine(Integer countOfPerson, PointAddStrategy pointAddStrategy) {
        return new Line(pointAddStrategy.makePoint(countOfPerson));
    }

    public static Line createMenualPointLine(Integer countOfPerson, List<PointEnum> points) {
        if (points.size() != countOfPerson - 1) {
            throw new IllegalArgumentException("사람 수와 포인트 수가 일치하지 않습니다.");
        }
        return new Line(points);
    }

    private static void pointsAdd(final List<PointEnum> points, final int i) {
        if (PointEnum.isTrue(points.get(i - 1))) {
            points.add(PointEnum.createPoint(false));
            return;
        }
        points.add(PointEnum.createRandomPoint());
    }

    public int size() {
        return points.size();
    }

    public List<PointEnum> getPoints() {
        return points;
    }

    public int move(int index) {
        if (index == 0) {
            return moveFirst();
        }
        if (index == points.size()) {
            return moveLast();
        }
        return moveMiddle(index);
    }

    private int moveMiddle(int index) {
        if (PointEnum.isTrue(points.get(index - 1))) {
            return index + 1;
        }
        if (PointEnum.isTrue(points.get(index))) {
            return index - 1;
        }
        return index;
    }

    private int moveLast() {
        return PointEnum.isTrue(points.get(points.size() - 1)) ? points.size() - 1 : points.size() - 2;
    }

    private int moveFirst() {
        return PointEnum.isTrue(points.get(0)) ? 1 : 0;
    }
}
