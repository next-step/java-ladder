package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Ladder.*;
import static nextstep.ladder.exception.ExceptionMessage.*;

public class Bridges {

    public static final String TRUE_BRIDGE = "-----";
    public static final String FALSE_BRIDGE = "     ";

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

    @Override
    public String toString() {
        return bridges.stream()
            .map(bridge -> bridge ? TRUE_BRIDGE : FALSE_BRIDGE)
            .collect(Collectors.joining(LADDER_POLE));
    }
}
