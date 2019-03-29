package laddergame.domain;

import laddergame.service.LadderValueGenerator;
import laddergame.service.LadderRandomValueGenerator;
import laddergame.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static laddergame.domain.EndPoint.PARTICIPANT_MAXIMUM_NAME_LENGTH;

public class LadderLine {

    public static final String LADDER_LINE_STRING = "-";

    private final List<Point> points;

    LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    public static LadderLine init(int sizeOfPerson) {
        return init(sizeOfPerson, LadderRandomValueGenerator.getInstance());
    }

    static LadderLine init(int sizeOfPerson, LadderValueGenerator ladderValueGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, ladderValueGenerator);
        point = initBody(sizeOfPerson, points, point, ladderValueGenerator);
        initLast(points, point);
        return new LadderLine(points);
    }

    static Point initFirst(List<Point> points, LadderValueGenerator ladderValueGenerator) {
        Point point = Point.first(ladderValueGenerator.generate());
        points.add(point);
        return point;
    }

    static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderValueGenerator ladderValueGenerator) {
        for( int i = 1; i < sizeOfPerson-1; ++i ) {
            point = point.next(ladderValueGenerator);
            points.add(point);
        }

        return point;
    }

    static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.repeat(" ", PARTICIPANT_MAXIMUM_NAME_LENGTH));
        points.forEach(sb::append);

        return sb.toString();
    }
}