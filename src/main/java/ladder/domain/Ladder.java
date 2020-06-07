package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder buildLadder(PlayersGroup playersGroup, int ladderHeight) {
        int playerCounts = playersGroup.getPlayerCounts();
        List<Line> ladder = Stream.generate(() -> Line.drawLine(playerCounts))
                .limit(ladderHeight)
                .collect(Collectors.toList());
        return new Ladder(ladder);
    }

    public List<List<Boolean>> getLadderBluePrint() {
        return ladder.stream()
                .map(Line::getLinePositions)
                .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        return ladder.size();
    }
}
