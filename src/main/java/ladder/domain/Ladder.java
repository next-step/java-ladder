package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> ladder;
    private final int countOfPerson;
    private final int height;

    public Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
        this.ladder = generateLadder();
    }

    private List<Line> generateLadder() {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(generateLine());
        }
        return lines;
    }

    private Line generateLine() {
        List<Point> points = new ArrayList<>();
        boolean previousPoint = generateRandomBoolean();
        firstPoint(points, previousPoint);
        for(int i = 1; i < countOfPerson - 1; i++) {
            boolean currentPoint = generateRandomBoolean();
            points.add(new Point(previousPoint, currentPoint));
            previousPoint = currentPoint;
        }
        lastPoint(points, previousPoint);

        return new Line(points);
    }

    private void lastPoint(List<Point> points, boolean point) {
        points.add(new Point(point, false));
    }

    private void firstPoint(List<Point> points, boolean point) {
        points.add(new Point(false, point));
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineCount() {
        return ladder.get(0).lineCount();
    }

    public Line getLine(int index) {
        return ladder.get(index);
    }

    private boolean generateRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
