package ladder.domain.first;

import ladder.domain.ConnectingStrategy;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLines implements LineCreator {
    private final int countOfLines;
    private final ConnectingLines connectingLines;

    public HorizontalLines(int countOfLines) {
        this(countOfLines, new ArrayList<>());
    }

    HorizontalLines(int countOfLines, ConnectingStrategy connectingStrategy) {
        this(countOfLines, new ArrayList<>());
        connect(connectingStrategy);
    }

    private HorizontalLines(int countOfLines, List<Boolean> connectingLines) {
        this(countOfLines, new ConnectingLines(connectingLines));
    }

    public HorizontalLines(int countOfLines, ConnectingLines connectingLines) {
        this.countOfLines = countOfLines;
        this.connectingLines = connectingLines;
    }

    @Override
    public void connect(ConnectingStrategy connectingStrategy) {
        for (int i = 0; i < countOfLines; i++) {
            connectingLines.connectLine(connectingStrategy, i);
        }
    }

    @Override
    public List<Boolean> getConnectingLines() {
        return connectingLines.getLines();
    }
}
