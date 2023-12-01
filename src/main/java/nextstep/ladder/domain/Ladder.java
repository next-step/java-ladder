package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final String LINE_BREAK = "\n";

    private final List<Points> ladder;

    public Ladder(List<Points> ladder) {
        this.ladder = ladder;
    }

    public int climb(int startPosition) {
        return ladder.stream()
            .reduce(startPosition, (current, points) -> points.move(current), (previous, current) -> current);
    }

    @Override
    public String toString() {
        return ladder.stream()
            .map(Points::toString)
            .collect(Collectors.joining(LINE_BREAK));
    }
}
