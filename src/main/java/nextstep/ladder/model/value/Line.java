package nextstep.ladder.model.value;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    private static final int START_NUMBER = 0;
    private static final int UNIT = 1;

    private List<Point> points = new ArrayList<>();

    public Line (int countOfPerson, Random random) {

        IntStream.range(START_NUMBER, countOfPerson)
                .forEach(index -> points.add(
                        new Point(isBeforePoint(index) && isConnectionLadder(random))));

    }

    public static Line of (int countOfPerson) {
        return new Line(countOfPerson, new Random());
    }

    public boolean isBeforePoint(int index) {
        if (index - 1 < 0) {
            return true;
        }

        return !points.get(index - 1).isTrue();
    }

    public boolean isConnectionLadder(Random random) {
        return random.nextBoolean();
    }

    public boolean hasLine(int position) {
        return points.get(position).isTrue();
    }

    public Point hasLeftLine(int position) {
        if (position - UNIT < START_NUMBER) {
            return new Point(false);
        }

        if (position > points.size()) {
            return new Point(false);
        }

        return points.get(position - UNIT);
    }

    public Point hasRightLine(int position) {
        if (position < START_NUMBER) {
            return new Point(false);
        }

        if (position > points.size() - UNIT) {
            return new Point(false);
        }

        return points.get(position);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
