package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private Random random = new Random();
    private List points = new ArrayList<>();

    public Line() {
    }

    public Line(int countOfPerson) {
        points = createPoints(countOfPerson);
    }

    public Line(List points) {
        this.points = points;
    }

    public List<Point> createPoints(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        boolean existLine = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            Point point = new Point();
            existLine = isExistLine(existLine, point);
            points.add(point);
        }

        return Collections.unmodifiableList(points);
    }

    public boolean existBeforeLine(Point point) {
        return point.isNextPoint();
    }

    private boolean isExistLine(boolean existLine, Point point) {
        if (!existLine) {
            existLine = moveNextPoint(point);
            return existLine;
        }

        existLine = false;
        return existLine;
    }

    private boolean moveNextPoint(Point point) {
        boolean existLine = false;
        boolean randomBoolean = getRandomBoolean();

        if (randomBoolean) {
            existLine = true;
            point.moveNextPoint();
        }
        return existLine;
    }

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public List getPoints() {
        return points;
    }
}
