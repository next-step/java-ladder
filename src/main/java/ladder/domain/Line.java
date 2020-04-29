package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int INDEX_DIFFERENCE = 1;
    private static final int INDEX_MIN = 0;
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line getNewInstance(Line line) {
        return new Line(new ArrayList<>(line.points));
    }

    public static Line getNewInstance(List<Boolean> points) {
        return new Line(new ArrayList<>(points));
    }

    private int getPointCount(int countOfPerson) {
        return countOfPerson - INDEX_DIFFERENCE;
    }

    public boolean isPointExist(int index) {
        return this.points.get(index);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(this.points);
    }

    public int movePosition(int position) {
        if (checkLeft(position)) {
            return position - INDEX_DIFFERENCE;
        }

        if (checkRight(position)) {
            return position + INDEX_DIFFERENCE;
        }

        return position;
    }

    private boolean checkLeft(int position) {
        if (position <= INDEX_MIN) {
            return false;
        }

        return points.get(leftIndexOfPerson(position));
    }

    private boolean checkRight(int position) {
        if (position >= points.size()) {
            return false;
        }

        return points.get(rightIndexOfPerson(position));
    }

    private int leftIndexOfPerson(int personPosition) {
        return personPosition - INDEX_DIFFERENCE;
    }

    private int rightIndexOfPerson(int personPosition) {
        return personPosition;
    }
}
