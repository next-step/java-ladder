package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder buildLadder(PlayersGroup playersGroup, int ladderHeight,
                                     DrawingLineStrategy drawingLineStrategy) {
        int playerCounts = playersGroup.getPlayerCounts();
        List<LadderLine> ladder = Stream.generate(() -> LadderLine.drawLine(playerCounts, drawingLineStrategy))
                .limit(ladderHeight)
                .collect(Collectors.toList());
        return new Ladder(ladder);
    }

    public int climb(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.movePointOnLine(index);
        }
        return index;
    }

    public List<List<Direction>> getLadderBluePrint() {
        return ladderLines.stream()
                .map(LadderLine::getPointDirections)
                .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        return ladderLines.size();
    }
}
