package laddergame.domain;

import laddergame.service.LadderValueGenerator;
import laddergame.service.LadderRandomValueGenerator;
import laddergame.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static LadderLine init(int sizeOfPerson) {
        return init(sizeOfPerson, LadderRandomValueGenerator.getInstance());
    }

    static LadderLine init(int sizeOfPerson, LadderValueGenerator ladderPointGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, ladderPointGenerator);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    static Point initFirst(List<Point> points, LadderValueGenerator ladderPointGenerator) {
        Point point = Point.first(ladderPointGenerator.generate());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for( int i = 1; i < sizeOfPerson-1; ++i ) {
            point = point.next();
            points.add(point);
        }

        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.repeat(" ", PARTICIPANT_MAXIMUM_NAME_LENGTH));
        points.forEach(sb::append);

        return sb.toString();
    }
}