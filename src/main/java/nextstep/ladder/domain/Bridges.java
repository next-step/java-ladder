package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Bridges {

    private final List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        if (existStraight(bridges)) {
            throw new IllegalArgumentException(NOT_TRUE_STRAIGHT.message());
        }

        this.bridges = bridges;
    }

    private boolean existStraight(List<Boolean> bridges) {
        return IntStream.range(0, bridges.size() - 1)
            .anyMatch(i -> bridges.get(i) && bridges.get(i + 1));
    }

    public boolean isMovable(int xAxis) {
        validateIndex(xAxis);

        return this.bridges.get(xAxis);
    }

    private void validateIndex(int xAxis) {
        if (xAxis < 0 || xAxis >= bridges.size()) {
            throw new IllegalArgumentException(OUT_OF_INDEX.message());
        }
    }

    public List<Boolean> toBooleans() {
        return this.bridges.stream()
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridges bridges1 = (Bridges) o;
        return Objects.equals(bridges, bridges1.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }
}
