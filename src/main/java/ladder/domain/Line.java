package ladder.domain;

import java.util.List;

public class Line {
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

    public int nextPosition(int position) {
        boolean existsRightBridge = position < bridges.size() && bridges.get(position);
        if (existsRightBridge) {
            return position + 1;
        }

        boolean existsLeftBridge = position > 0 && bridges.get(position - 1);
        if (existsLeftBridge) {
            return position - 1;
        }

        return position;
    }
}
