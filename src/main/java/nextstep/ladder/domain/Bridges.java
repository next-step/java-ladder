package nextstep.ladder.domain;

import nextstep.ladder.exception.ExceptionMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Bridges {

    private List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        if (isTrueStraight(bridges)) {
            throw new IllegalArgumentException(BRIDGE_CAN_NOT_TRUE_STRAIGHT.message());
        }

        this.bridges = bridges;
    }

    private boolean isTrueStraight(List<Boolean> bridges) {
        return IntStream.range(0, bridges.size() - 1)
            .anyMatch(i -> bridges.get(i) && bridges.get(i + 1));
    }

    public boolean isMovable(int position) {
        return this.bridges.get(position);
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
