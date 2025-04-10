package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Players players;
    private final Lines lines;

    public Ladder(List<String> players, int height) {
        this.players = new Players(players);
        this.lines = new Lines(height, players.size());
    }
}
