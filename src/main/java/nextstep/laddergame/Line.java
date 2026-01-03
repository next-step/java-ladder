package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(lineGenerate(countOfPerson));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    private static List<Boolean> lineGenerate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < countOfPerson; i++) {
            boolean current = isLineTrue(previous);
            points.add(current);
            previous = current;
        }
        return points;
    }

    private static boolean isLineTrue(boolean previous) {
        if (previous) {
            return false;
        }
        return new Random().nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
