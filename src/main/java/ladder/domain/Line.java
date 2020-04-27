package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int INDEX_DIFFERENCE = 1;
    private static final int INDEX_MIN = 0;
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line getNewInstance(Line line) {
        return new Line(line.points);
    }

    public static Line getNewInstance(List<Boolean> points) {
        return new Line(points);
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
        return -1;
    }
}
