package laddergame.domain;

import laddergame.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static laddergame.domain.Participant.PARTICIPANT_MAXIMUM_NAME_LENGTH;
import static laddergame.service.LadderPointGenerator.generateNextToRight;

public class LadderLine {

    public static final String LADDER_LINE_STRING = "-";

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generateNextToRight());
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

    public String toResultString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.repeat(" ", PARTICIPANT_MAXIMUM_NAME_LENGTH));
        points.stream().forEach(sb::append);

        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LadderLine{");
        sb.append("points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}