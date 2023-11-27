package ladder.domain;

import ladder.strategy.PathStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    public static final int SIZE_MIN = 2;
    private final List<Boolean> paths;

    private Line(long size, PathStrategy pathStrategy) {
        validateSize(size);
        this.paths = pathStrategy.generate(size);
    }

    private void validateSize(long size) {
        if (size < SIZE_MIN) {
            throw new IllegalArgumentException("최소 너비는 2 이상입니다.");
        }
    }

    public static Line of(long size, PathStrategy pathStrategy) {
        return new Line(size, pathStrategy);
    }

    public List<Boolean> paths() {
        return Collections.unmodifiableList(paths);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(paths, line.paths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paths);
    }

    @Override
    public String toString() {
        return paths.toString();
    }
}
