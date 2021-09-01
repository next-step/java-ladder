package ladder.domain;

import java.util.*;

public class LadderLine {

    private final Width width;

    private final List<Boolean> points;

    private LadderLine(Width width, List<Boolean> points) {
        this.width = width;
        this.points = points;
    }

    private LadderLine(Width width) {
        this(width, new ArrayList<>());
    }

    public static LadderLine create(List<Boolean> points) {
        return new LadderLine(Width.create(points.size()), points);
    }

    public static LadderLine create(Boolean... points) {
        return new LadderLine(Width.create(points.length), Arrays.asList(points));
    }

    public static LadderLine createWithWidth(Width width) {
        return new LadderLine(width);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public boolean isConnected(int index) {
        if (outOfRange(index)) {
            throw new IndexOutOfBoundsException("사다리의 너비의 범위를 벗어났습니다.");
        }
        return points.get(index);
    }

    public boolean outOfRange(int index) {
        return width.outOfRange(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine ladderLine = (LadderLine) o;
        return Objects.equals(width, ladderLine.width) && Objects.equals(points, ladderLine.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, points);
    }

}
