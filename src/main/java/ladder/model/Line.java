package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final double STANDARD_OF_RANDOM_VALUE = 0.5;
    private final List<Boolean> points = new ArrayList <>();
    private boolean beforeLine = false;

    public Line(int countOfPerson) {
        for (int i = 1; i < countOfPerson; i++) {
            this.points.add(createLine());
        }
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    private boolean createLine() {
        boolean line = beforeLine ? false : randomLine();
        beforeLine = line;
        return line;
    }

    private boolean randomLine() {
        return Math.random() > STANDARD_OF_RANDOM_VALUE;
    }

}
