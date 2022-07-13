package ladder.domain.second;

import ladder.domain.ConnectingStrategy;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderGame implements LadderCreator {
    private List<LadderLine> ladderLines;

    public LadderGame(List<LineCreator> ladderLines, ConnectingStrategy connectingStrategy) {
        this.ladderLines = new ArrayList<>();
        for (LineCreator lineCreator : ladderLines) {
            this.ladderLines.add((LadderLine) lineCreator);
        }
        create(connectingStrategy);
    }

    @Override
    public void create(ConnectingStrategy connectingStrategy) {
        for (LadderLine ladderLine : ladderLines) {
            ladderLine.connect(connectingStrategy);
        }
    }

    @Override
    public List<? extends LineCreator> getLines() {
        return ladderLines;
    }
}
