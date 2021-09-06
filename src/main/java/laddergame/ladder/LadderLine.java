package laddergame.ladder;

import laddergame.connectable.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderLine {

    private final List<Boolean> points = new ArrayList<>();

    public LadderLine(int countOfPerson, Connection connection) {
        IntStream.range(0, countOfPerson)
                .forEach(i -> connect(connection));
    }

    public LadderLine(int countOfPerson) {
        IntStream.range(0, countOfPerson)
                .forEach(i -> connect(() -> false));
    }

    private void connect(Connection connection) {
        if (points.isEmpty()) {
            points.add(connection.able());
            return;
        }
        if (points.get(points.size() - 1).equals(true)) {
            points.add(false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
