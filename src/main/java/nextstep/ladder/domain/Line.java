package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(final List<Boolean> points) {
        if (hasConsecutiveTrues(points)) {
            throw new IllegalArgumentException("Consecutive true points are not allowed");
        }
        this.points.addAll(points);
    }

    private boolean hasConsecutiveTrues(final List<Boolean> points) {
        return IntStream.range(1, points.size())
                .anyMatch(index -> points.get(index) && points.get(index - 1));
    }

    public int size() {
        return points.size();
    }

    public boolean isPointTrue(int index) {
        return points.get(index);
    }

    public List<Person> movePersons(final List<Person> persons) {
        int personsSize = persons.size();
        List<Person> result = new ArrayList<>(persons);
        for (int i = 0; i < personsSize; i++) {
            int index = moveIndex(personsSize, i);
            result.set(index, persons.get(i));
        }
        return result;
    }

    private int moveIndex(int personsSize, int before) {
        int after = before;
        if (before < personsSize - 1 && points.get(before)) {
            after++;
        }
        if (before > 0 && points.get(before - 1)) {
            after--;
        }
        return after;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }
}
