package ladder.domain.ladder;

import ladder.domain.participant.Position;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int giveDirection(int rowPoint) {
        return pointDirectionLeftOrRight(rowPoint);
    }

    private int pointDirectionLeftOrRight(int rowPoint) {
        if(rowPoint == 0 || rowPoint == points.size()){
            return pointFirstOrLastElementDirection(rowPoint);
        }
        return points.get(rowPoint) == true ? pointRightDirection(rowPoint) : pointLeftDirection(rowPoint);
    }

    private int pointLeftDirection(int rowPoint) {
        if(points.get(rowPoint + LEFT) == true) {
            return LEFT;
        }
        return 0;
    }

    private int pointRightDirection(int rowPoint) {
        if(points.get(rowPoint) == true) {
            return RIGHT;
        }
        return 0;
    }

    private int pointFirstOrLastElementDirection(int rowPoint) {
        return rowPoint == 0 ? pointRightDirection(rowPoint) : pointLeftDirection(rowPoint);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int sizeWidth() {
        return points.size();
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
