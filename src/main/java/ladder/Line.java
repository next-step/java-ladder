package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    public static final int GO_NEXT = 1;
    public static final int GO_PREV = 0;
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
            return goNextOrPrev(0);
        }
        if (isLast(startPoint)) {
            return -goNextOrPrev(startPoint - 1);
        }
        if (hasHorizon(startPoint - 1)) {
            return -goNextOrPrev(startPoint - 1);
        }
        if (hasHorizon(startPoint)) {
            return goNextOrPrev(startPoint);
        }

        return 0;
    }

    private boolean hasHorizon(int point) {
        return points.get(point);
    }

    private int goNextOrPrev(int prevPoint) {
        if (points.get(prevPoint)) {
            return GO_NEXT;
        }
        return GO_PREV;
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
