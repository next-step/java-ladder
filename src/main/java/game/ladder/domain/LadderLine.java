package game.ladder.domain;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    public static final int MIN_PERSON_SIZE = 0;
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        Preconditions.checkArgument(!points.isEmpty(), "point는 하나 이상이어야 합니다.");
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson) {
        Preconditions.checkArgument(sizeOfPerson > MIN_PERSON_SIZE, "참여자는 한 명 이상이어야 합니다.");
        List<Point> points = new ArrayList<>(sizeOfPerson);
        Point firstPoint = initFirst(points);
        Point point = initBody(sizeOfPerson, points, firstPoint);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(LadderPointGenerator.generatePoint());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point firstPoint) {
        Point point = firstPoint;
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int pointSize() {
        return this.points.size();
    }

    public String getStringLadderLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointSize(); i++) {
            final String stringPoint = points.get(i).getStringPoint(isLastPoint(i));
            sb.append(stringPoint);
        }
        return sb.toString();
    }

    private boolean isLastPoint(int index) {
        return index == (pointSize() - 1);
    }
}
