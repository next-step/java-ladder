package ladder.domain;

import ladder.utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int REQUIRED_NUMBER_OF_PEOPLE = 2;
    private static final int MOVING_DISTANCE = 1;

    private final List<Boolean> points;

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        return getLine(countOfPerson);
    }

    private static Line getLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        points.add(RandomBooleanGenerator.execute());

        for (int i = REQUIRED_NUMBER_OF_PEOPLE; i < countOfPerson; i++) {
            Boolean current = RandomBooleanGenerator.execute();
            Boolean beforePoint = points.get(i - 1);
            points.add(compareAdjacentPoint(beforePoint, current));
        }

        return new Line(points);
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    private static Boolean compareAdjacentPoint(Boolean beforePoint, Boolean current) {
        if (beforePoint != current) {
            return current;
        }
        return !current;
    }

    public int getSize() {
        return points.size();
    }


    public boolean havePoints(int i) {
        return points.get(i);
    }

    public int movedPosition(int position) {

        int right = getRight(position);

        if (havePoints(position)) {
            return position - MOVING_DISTANCE;
        }
        if (havePoints(right)) {
            return position + MOVING_DISTANCE;
        }
        return position;
    }

    private int getRight(int position) {
        int right = position + MOVING_DISTANCE;

        if (right >= points.size()) {
            right = position;
        }
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
