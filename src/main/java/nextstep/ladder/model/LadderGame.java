package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Ladder ladder;
    private PlayerGroup playerGroup;

    public LadderGame(List<String> names) {
        this.ladder = new Ladder();
        this.playerGroup = PlayerGroup.of(names);
    }

    public Ladder run(int height, LineGenerator lineGenerator) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(this.playerGroup.getPlayers().size(), lineGenerator))
                .collect(Collectors.toList());
        this.ladder = new Ladder(lines);
        return this.ladder;
    }

    public List<Player> getPlayers() {
        return playerGroup.getPlayers();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
