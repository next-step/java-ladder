package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder buildLadder(PlayersGroup playersGroup, int ladderHeight,
                                     DrawingLineStrategy drawingLineStrategy) {
        int playerCounts = playersGroup.getPlayerCounts();
        List<Line> ladder = Stream.generate(() -> Line.drawLine(playerCounts, drawingLineStrategy))
                .limit(ladderHeight)
                .collect(Collectors.toList());
        return new Ladder(ladder);
    }

    public int climb(int index) {
        for (Line line : lines) {
            index = line.movePointOnLine(index);
        }
        return index;
    }

    public List<List<Direction>> getLadderBluePrint() {
        return lines.stream()
                .map(Line::getPointDirections)
                .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        return lines.size();
    }
}
