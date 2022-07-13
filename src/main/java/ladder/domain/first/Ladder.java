package ladder.domain.first;

import ladder.domain.ConnectingStrategy;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class Ladder implements LadderCreator {
    private List<HorizontalLines> verticalLines;

    public Ladder(List<LineCreator> verticalLines, ConnectingStrategy connectingStrategy) {
        this.verticalLines = new ArrayList<>();
        for (LineCreator verticalLine : verticalLines) {
            this.verticalLines.add((HorizontalLines) verticalLine);
        }
        create(connectingStrategy);
    }

    @Override
    public void create(ConnectingStrategy connectingStrategy) {
        for (LineCreator verticalLine : verticalLines) {
            verticalLine.connect(connectingStrategy);
        }
    }

    public List<HorizontalLines> getLines() {
        return verticalLines;
    }
}
