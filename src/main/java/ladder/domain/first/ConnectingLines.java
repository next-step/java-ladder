package ladder.domain.first;

import ladder.domain.ConnectingStrategy;

import java.util.Collections;
import java.util.List;

class ConnectingLines {
    private static final boolean DEFAULT_VALUE = false;

    private List<Boolean> lines;

    ConnectingLines(List<Boolean> lines) {
        this.lines = lines;
    }

    void connectLine(ConnectingStrategy connectingStrategy, int index) {
        if (isFirstOrConnectableLine(index)) {
            lines.add(connectingStrategy.connectable());
            return;
        }
        lines.add(DEFAULT_VALUE);
    }

    private boolean isFirstOrConnectableLine(int index) {
        return index == 0 || !lines.get(index - 1);
    }

    List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
