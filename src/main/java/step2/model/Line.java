package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        points = new ArrayList<>();

        for (int i = 0; i < numberOfUser - 1; i++) {
            if (i != 0 && points.get(points.size() - 1)) {
                points.add(false);
                continue;
            }
            boolean drawLine = ladderStrategy.generateLine();
            points.add(drawLine);
        }

    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return points;
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
