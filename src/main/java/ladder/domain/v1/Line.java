package ladder.domain.v1;

import ladder.domain.Position;
import ladder.domain.factory.ILine;

import java.util.List;

public class Line implements ILine {
    private final List<Boolean> bridges;

    public Line(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    public List<Boolean> bridges() {
        return bridges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return bridges.equals(line.bridges);
    }

    @Override
    public int hashCode() {
        return bridges.hashCode();
    }

    public Position nextPosition(Position position) {
        if (existsRightBridge(position)) {
            return position.moveRight();
        }

        if (existsLeftBridge(position)) {
            return position.moveLeft();
        }

        return position;
    }

    private boolean existsRightBridge(Position position) {
        return position.isLesserThan(bridges.size()) && bridges.get(position.position());
    }

    private boolean existsLeftBridge(Position position) {
        return position.isGreaterThan(0) && bridges.get(position.position() - 1);
    }
}
