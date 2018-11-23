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

    public Connection draw(int countOfPerson) {
        if (canDraw(countOfPerson)) {
            return this.connect(countOfPerson);
        }
        return Connection.EMPTY;
    }

    private Connection connect(int countOfPerson) {
        Point start = points.get(countOfPerson);
        Point end = points.get(countOfPerson + 1);

        Connection connection = Connection.create(start, end);
        return connection.connect();
    }

    private boolean canDraw(int countOfPerson) {
        return countOfPerson + 1 < points.size();
    }

    public int position(int index) {
        return points.get(index).position();
    }

    public int size() {
        return this.points.size();
    }

    @Override
    public String toString() {
        return String.valueOf(points.stream().map(Point::toString).collect(Collectors.joining("")));
    }
}
