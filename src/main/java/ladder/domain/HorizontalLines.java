package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalLines {
    private static final boolean DEFAULT_VALUE = false;

    private final List<Boolean> horizontalLines;

    HorizontalLines() {
        this(new ArrayList<>());
    }

    public HorizontalLines(List<Boolean> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public void connect(int countOfLines, ConnectingStrategy connectingStrategy) {
        for (int i = 0; i < countOfLines; i++) {
            connectLine(connectingStrategy, i);
        }
    }

    private void connectLine(ConnectingStrategy connectingStrategy, int index) {
        if (isFirstOrConnectableLine(index)) {
            horizontalLines.add(connectingStrategy.connectable());
            return;
        }
        horizontalLines.add(DEFAULT_VALUE);
    }

    private boolean isFirstOrConnectableLine(int index) {
        return index == 0 || !horizontalLines.get(index - 1);
    }

    public List<Boolean> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
