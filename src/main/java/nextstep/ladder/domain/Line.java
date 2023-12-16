package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final ArrayList<Point> points;

    public Line(int countOfParticipant) {
        this(generateRandomLine(countOfParticipant));
    }

    private static ArrayList<Point> generateRandomLine(int countOfParticipant) {
        ArrayList<Point> line = new ArrayList<>();
        Point firstPoint = new Point(false, false); // 사다리 라인의 맨 왼쪽은 생성될 수 없다.
        line.add(firstPoint);
        for (int i = 1; i < countOfParticipant; i++) {
            Point point = Point.previousOf(line.get(i-1).getCurrent());
            line.add(point);
        }
        return line;
    }

    public Line(ArrayList<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
