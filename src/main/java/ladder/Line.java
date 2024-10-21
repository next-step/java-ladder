package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> points;

    public Line(Boolean... points) {
        this(Arrays.stream(points).collect(Collectors.toList()));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int ladderSize, LineGenerator lineGenerator) {
        this.points = lineGenerator.run(ladderSize);
    }

    public int findNextPoint(int startPoint) {
        if (isFirst(startPoint)) {
            return checkHorizon(0);
        }
        if (isLast(startPoint)) {
            return -checkHorizon(startPoint - 1);
        }
        if (findHorizon(startPoint - 1)) {
            return -checkHorizon(startPoint - 1);
        }
        if (findHorizon(startPoint)) {
            return checkHorizon(startPoint);
        }

        return startPoint;
    }

    private boolean findHorizon(int point) {
        return points.get(point);
    }

    private int checkHorizon(int prevPoint) {
        if (points.get(prevPoint)) {
            return 1;
        }
        return 0;
    }

    private boolean isFirst(int startPoint) {
        return startPoint == 0;
    }

    private boolean isLast(int startPoint) {
        return startPoint == points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Line))
            return false;
        Line line = (Line)o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
