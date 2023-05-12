package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPeople, LineStrategy lineStrategy) {
        validate(countOfPeople);
        int initialCapacity = countOfPeople - 1;
        this.points = new ArrayList<>(initialCapacity);

        init(lineStrategy, initialCapacity);
    }

    private void init(final LineStrategy lineStrategy, final int initialCapacity) {
        for (int i = 0; i < initialCapacity; i++) {
            isDraw(lineStrategy);
        }
    }

    private void isDraw(final LineStrategy lineStrategy) {
        if (lineStrategy.isMovable()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private void validate(final int countOfPeople) {
        if (countOfPeople <= 1) {
            throw new IllegalArgumentException("참여 인원은 두 명 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
