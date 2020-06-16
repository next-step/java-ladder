package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Line {

    private final Positions positions;

    public Line(Positions positions) {
        this.positions = positions;
    }

    public static Line init(int sizeOfPerson) {
        return null;
    }

    public int move(int value) {
        return 0;
    }

    public List<Position> getPositions() {
        return positions.getPositions();
    }

    public static Line newInstance(int maxPosition, DirectionPredicate predicate) {
        return new Line(Positions.newInstance(maxPosition, predicate));
    }

    public int sizeOfPositions(){
        return positions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(positions, line.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
