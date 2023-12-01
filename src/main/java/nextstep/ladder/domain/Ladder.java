package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Ladder {

    private static final String LINE_BREAK = "\n";

    private final List<Points> ladder;

    public Ladder(List<Points> ladder) {
        this.ladder = ladder;
    }

    public Map<String, Integer> climb(Players players) {
        return IntStream.range(0, players.numOfPlayers())
            .boxed()
            .collect(toMap(
                players::name,
                this::climbFrom,
                (oldVal, newVal) -> newVal,
                LinkedHashMap::new
            ));
    }

    public int climbFrom(int startPosition) {
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
