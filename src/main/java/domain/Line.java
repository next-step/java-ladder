package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int columnCount, ConnectionStrategy strategy) {
        this.points = generateLine(columnCount, strategy);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> generateLine(int columnCount, ConnectionStrategy strategy) {
        List<Boolean> line = new ArrayList<>();

        for (int i = 0; i < columnCount - 1; i++) {
            tryAddConnection(i, line, strategy);
        }

        return line;
    }

    private void tryAddConnection(int i, List<Boolean> line, ConnectionStrategy strategy) {
        if (i > 0 && line.get(i - 1)) {
            line.add(false);
            return;
        }
        line.add(strategy.shouldConnect());
    }
}
