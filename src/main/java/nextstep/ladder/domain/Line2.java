package nextstep.ladder.domain;

import nextstep.ladder.RandomBooleanProvider;

import java.util.ArrayList;
import java.util.List;

public class Line2 {
    public static final int MIN_PARTICIPANT_COUNT = 2;
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";

    private final List<Point2> points;

    public Line2(List<Point2> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static Line2 init(int sizeOfPerson) {
        assertParticipantCount(sizeOfPerson);

        List<Point2> points = new ArrayList<>();
        Point2 point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new Line2(points);
    }

    private static Point2 initBody(int sizeOfPerson, List<Point2> points, Point2 point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point2> points, Point2 point) {
        point = point.last();
        points.add(point);
    }

    private static Point2 initFirst(List<Point2> points) {
        Point2 point = Point2.first(RandomBooleanProvider.getRandomBoolean());
        points.add(point);
        return point;
    }

    private static void assertParticipantCount(int sizeOfPerson) {
        if(sizeOfPerson < MIN_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException(POINT_COUNT_ERROR);
        }
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

    public List<Point2> getValue() {
        return points;
    }
}
