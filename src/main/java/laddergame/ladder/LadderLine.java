package laddergame.ladder;

import laddergame.connectable.Connectable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderLine {

    // TODO : 리네임, 일급 객체로 감싸기
    private final List<Boolean> points = new ArrayList<>();

    public LadderLine(int countOfPerson, Connectable connectable) {
        IntStream.range(1, countOfPerson)
                .forEach(i -> connect(connectable));
    }

    // TODO: points로 로직 위임
    private void connect(Connectable connectable) {
        if (points.isEmpty()) {
            points.add(connectable.able());
            return;
        }

        if (points.get(points.size() - 1).equals(true)) {
            points.add(false); // 마지막 값이 true였을 경우 false로 넣는다.
            return;
        }

        points.add(connectable.able()); // default
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

    public List<Boolean> points() {
        return this.points;
    }
}
