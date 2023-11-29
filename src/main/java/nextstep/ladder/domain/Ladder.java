package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public static final String LADDER_POLE = "|";
    private static final String LINE_BREAK = "\n";

    private final List<Points> ladder;

    public Ladder(List<Points> ladder) {
        this.ladder = ladder;
    }

    public int climb(int startPosition) {
        return ladder.stream()
            .reduce(startPosition, (current, points) -> points.move(current), (a, b) -> b);
    }

    @Override
    public String toString() {
        return ladder.stream()
            .map(this::setUpSide)
            .collect(Collectors.joining(LINE_BREAK));
    }

    private String setUpSide(Points points) {
        return LADDER_POLE + points.toString() + LADDER_POLE;
    }
}
