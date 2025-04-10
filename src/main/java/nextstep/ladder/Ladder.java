package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Players players;
    private final List<Line> lines;

    public Ladder(List<String> players, int height) {
        this.players = new Players(players);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.size()))
                .collect(Collectors.toList());
    }
}
