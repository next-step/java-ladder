package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int ONE = 1;
    private final static int INITIAL = 0;

    private final List<Boolean> points;

    private Line(LineStrategy lineStrategy, int countOfPerson) {
        points = lineStrategy.create(countOfPerson);
    }

    public Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line of(LineStrategy lineStrategy, int countOfPerson) {
        return new Line(lineStrategy, countOfPerson);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int move(int index) {
        if (index != INITIAL && points.get(index - 1)) {
            return index - ONE;
        }
        if (points.get(index)) {
            return index + ONE;
        }
        return index;
    }
}
