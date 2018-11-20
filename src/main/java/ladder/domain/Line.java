package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    private List<Point> points;

    private Line(int countOfPerson) {
        points = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(Point.create());
        }
    }

    public static Line create(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public void draw() {
        for (int i = 0; i < MAX_NUMBER_OF_ATTEMPTS; i++) {
            this.draw(RandomUtils.generate(points.size()));
        }
    }

    public void draw(int countOfPerson) {
        if (canDraw(countOfPerson)) {
            this.connect(countOfPerson);
        }
    }

    private void connect(int countOfPerson) {
        Point current = points.get(countOfPerson);
        Point next = points.get(countOfPerson + 1);
        if (current.canConnect() && next.canConnect()) {
            current.connect(Direction.RIGHT);
            next.connect(Direction.LEFT);
        }
    }

    private boolean canDraw(int countOfPerson) {
        return countOfPerson < points.size() - 1;
    }


    public int size() {
        return this.points.size();
    }

    @Override
    public String toString() {
        return String.valueOf(points.stream().map(Point::toString).collect(Collectors.joining("")));
    }
}
