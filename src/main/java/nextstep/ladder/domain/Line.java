package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, Strategy paintStrategy) {
        List<Boolean> points = new ArrayList<>();

        boolean prevPaint = false;

        for (int i = 0; i < countOfPerson; i++) {
            boolean currPaint = paintStrategy.paint();
            boolean isPaint = isPaintLine(prevPaint, currPaint);
            points.add(isPaint);
            prevPaint = isPaint;
        }

        return new Line(points);
    }

    private static boolean isPaintLine(boolean prevPaint, boolean currPaint) {
        return !prevPaint && currPaint;
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
