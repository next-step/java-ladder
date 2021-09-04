package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ladder.strategy.LineGenerateStrategy;

public class Line {

    private static final boolean DISCONNECT_POINT = false;
    private static final int START_POINT_INDEX = 0;
    private static final int TWO = 2;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generateRandomLine(int userCount, LineGenerateStrategy lineGenerateStrategy) {
        List<Boolean> points = new ArrayList<>();

        points.add(lineGenerateStrategy.generateLine());
        for (int i = START_POINT_INDEX; i < userCount - TWO; i++) {
            points.add(getNext(points.get(i), lineGenerateStrategy));
        }
        points.add(DISCONNECT_POINT);
        return new Line(points);
    }

    private static boolean getNext(boolean before, LineGenerateStrategy lineGenerateStrategy) {
        if (before) {
            return DISCONNECT_POINT;
        }
        return lineGenerateStrategy.generateLine();
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
