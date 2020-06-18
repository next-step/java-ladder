package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(Players players, Height height, PointGenerationStrategy strategy) {
        this.ladderLines = createLadder(players, height, strategy);
    }

    private List<LadderLine> createLadder(Players players, Height height, PointGenerationStrategy strategy) {
        int countOfPlayers = players.getPlayersCount();

        return IntStream.range(0, height.getHeight())
                .mapToObj(num -> new LadderLine(countOfPlayers, strategy))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
