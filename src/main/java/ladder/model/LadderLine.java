package ladder.model;

import ladder.utils.ReferenceValue;
import ladder.utils.StatusGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine lineSet(int countOfPerson) {
        int lastIndex = validMinUserCount(countOfPerson);

        List<Point> points = createBody(lastIndex, createFirst());
        points.add(createLast(points.get(lastIndex - 1)));
        return new LadderLine(points);
    }

    private static Point createFirst() {
        Point point = Point.first(StatusGenerator.get());
        return point;
    }

    private static List <Point> createBody(int lastIndex, Point firstPoint) {
        List<Point> points = new ArrayList <>();
        points.add(firstPoint);

        for (int i = 1; i < lastIndex; i++) {
            firstPoint = firstPoint.next();
            points.add(firstPoint);
        }
        return points;
    }

    private static Point createLast(Point point) {
        return point.last();
    }

    private static int validMinUserCount(int countOfPerson) {
        if (ReferenceValue.LADDER_MINIMUM_USER.isInValidLadderUserCount(countOfPerson)) {
            throw new IllegalStateException("사다리 게임 참여자는 최소 2명 이상이어야 합니다.");
        }
        return countOfPerson - 1;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

}
