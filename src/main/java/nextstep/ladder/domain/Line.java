package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private Random random = new Random();
    private List<Point> points = new ArrayList<>();

    public Line() {
    }

    public Line(int countOfPerson) {
        points = createPoints(countOfPerson);
    }

    public Line(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
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

    private boolean isExistLine(boolean existLine, Point point) {
        if (!existLine) {
            existLine = drawLine(point);
            return existLine;
        }

        existLine = false;
        return existLine;
    }

    private boolean drawLine(Point point) {
        boolean existLine = false;
        boolean randomBoolean = getRandomBoolean();

        if (randomBoolean) {
            existLine = true;
            point.drawLine();
        }
        return existLine;
    }

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public List<Point> getPoints() {
        return points;
    }
}
