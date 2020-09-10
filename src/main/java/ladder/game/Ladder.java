package ladder.game;

import ladder.domain.rule.DrawRule;
import ladder.tdd.LadderLine;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> ladderLines;
    private final int columnCount;
    private final DrawRule drawRule;

    @Builder
    public Ladder(int rowCount, int columnCount, DrawRule drawRule) {
        this.ladderLines = initLadder(rowCount, columnCount, drawRule);
        this.columnCount = columnCount;
        this.drawRule = drawRule;
    }

    private List<LadderLine> initLadder(int rowCount, int columnCount, DrawRule drawRule) {
        return Stream.generate(() -> LadderLine.init(columnCount, drawRule))
                .limit(rowCount)
                .collect(Collectors.toList());
    }

    public int getCountOfColumn() {
        return this.columnCount;
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines;
    }

    public int searchFinalPosition(int startingPoint) {
        int currentPosition = startingPoint;
        for (LadderLine line : ladderLines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

}
