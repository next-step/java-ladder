package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Ladder ladder;
    private final List<Player> players;
    private final int height;

    public LadderGame(List<String> names, int height) {
        this.ladder = new Ladder();
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.height = height;
    }

    public Ladder run(LineGenerator lineGenerator) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(this.players.size(), lineGenerator))
                .collect(Collectors.toList());
        this.ladder = new Ladder(lines);
        return this.ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
