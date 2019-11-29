package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.util.RandomGenerator.generateBoolean;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points);
        point = initBody(countOfPerson, points, point);
        initLastPoint(points, point);
        return new LadderLine(points);
    }

    private static Point initFirstPoint(List<Point> points) {
        Point point = Point.first(generateBoolean());
        points.add(point);
        return point;
    }

    private static Point initBody(int countOfPerson, List<Point> points, Point point) {
        int maxBodyLength = countOfPerson - 1;
        for (int person = 1; person < maxBodyLength; person++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Boolean> getPointOfLine() {
        return points.stream()
                .map(Point::isPoint)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}