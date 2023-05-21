package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<LadderRow> ladderRows;

    public Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    public String drawLadder() {
        return ladderRows.stream()
                .map(LadderRow::drawLadderRow)
                .collect(Collectors.joining("\n"));
    }
}
