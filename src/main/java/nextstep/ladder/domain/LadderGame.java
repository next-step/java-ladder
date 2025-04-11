package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String REGEX = ",";

    private final List<Player> players;
    private final Lines lines;

    public LadderGame(String players, int ladderHeight) {
        this.players = createPlayers(players);
        this.lines = new Lines(createLines(ladderHeight));
    }

    private List<Player> createPlayers(String players) {
        return Arrays.stream(players.split(REGEX))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private List<Line> createLines(int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> new Line(players.size(), new RandomGeneratorStrategy()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
