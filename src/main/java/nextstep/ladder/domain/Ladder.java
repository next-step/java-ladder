package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public static final String LADDER_POLE = "|";
    private static final String LINE_BREAK = "\n";

    private final List<Bridges> ladder;

    public Ladder(List<Bridges> ladder) {
        this.ladder = ladder;
    }

    public int climb(int startPosition) {
        return ladder.stream()
            .reduce(startPosition, (current, bridges) -> bridges.move(current), (a, b) -> b);
    }

    @Override
    public String toString() {
        return ladder.stream()
            .map(this::setUpSide)
            .collect(Collectors.joining(LINE_BREAK));
    }

    private String setUpSide(Bridges bridges) {
        return LADDER_POLE + bridges.toString() + LADDER_POLE;
    }
}
