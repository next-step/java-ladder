package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        boolean prevPaint = false;

        for (int i = 0; i < countOfPerson; i++) {
            Boolean isPaint = validation(prevPaint);
            points.add(isPaint);
            prevPaint = isPaint;
        }

        return new Line(points);
    }

    private static Boolean validation(boolean prevPaint) {
        boolean isPaint = Math.random() < 0.5;
        return isPaint && !prevPaint;
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
