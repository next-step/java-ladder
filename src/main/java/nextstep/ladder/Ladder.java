package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Player> players;
    private final List<Line> lines;

    public Ladder(List<String> players, int height) {
        this.players = players.stream().map(Player::new).collect(Collectors.toList());
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.size()))
                .collect(Collectors.toList());
    }
}
