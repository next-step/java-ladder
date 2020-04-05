package ladder;

import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    private List<Point> points;

    public VerticalLine(int height) {
        this.points = drawPoints(height);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    private List<Point> drawPoints(int height) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(new Point(i));
        }
        return points;
    }
}
