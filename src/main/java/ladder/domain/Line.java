package ladder.domain;

import ladder.strategy.PathStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> paths;

    private Line(long size, PathStrategy pathStrategy) {
        if (size < 2) {
            throw new IllegalArgumentException("최소 너비는 2 이상입니다.");
        }

        this.paths = generatePaths(size);
        pathStrategy.initialize(paths);
    }

    public static Line of(long size, PathStrategy pathStrategy) {
        return new Line(size, pathStrategy);
    }

    private List<Boolean> generatePaths(long size) {
        return Stream.generate(() -> Boolean.FALSE)
                .limit(size)
                .collect(Collectors.toList());
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
