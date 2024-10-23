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

    public Ladder makeLadder(int height, LineGenerator lineGenerator) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(this.playerGroup.getPlayers().size(), lineGenerator))
                .collect(Collectors.toList());
        this.ladder = new Ladder(lines);
        return this.ladder;
    }

    public LadderResult makeLadderResult(List<Prize> prizes) {
        if (this.playerGroup.getPlayers().size() != prizes.size()) {
            throw new IllegalArgumentException("Number of players does not match");
        }

        List<Prize> finalPrizes = IntStream.range(0, this.playerGroup.getSize())
                .mapToObj(i -> prizes.get(this.ladder.move(i)))
                .collect(Collectors.toList());

        return LadderResult.of(this.playerGroup.getPlayers(), finalPrizes);
    }

    public List<Player> getPlayers() {
        return playerGroup.getPlayers();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
