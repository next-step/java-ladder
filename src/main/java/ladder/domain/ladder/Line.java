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

    public int giveDirection(Position position) {
        return pointDirectionLeftOrRight(position);
    }

    private int pointDirectionLeftOrRight(Position position) {
       if(position.getRow() == 0 || position.getRow() == points.size()){
           return pointFirstOrLastElementDirection(position);
       }
       return points.get(position.getRow()) == true ? pointRightDirection(position) : pointLeftDirection(position);
    }

    private int pointLeftDirection(Position position) {
        if(points.get(position.getRow() + LEFT) == true) {
            return LEFT;
        }
        return 0;
    }

    private int pointRightDirection(Position position) {
        if(points.get(position.getRow()) == true) {
            return RIGHT;
        }
        return 0;
    }

    private int pointFirstOrLastElementDirection(Position position) {
        return position.getRow() == 0 ? pointRightDirection(position) : pointLeftDirection(position);
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
