package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int numberOfColumns;
    private final List<LadderLineConnections> connectionsByHeight;

    public Ladder(int numberOfColumns) {
        this(numberOfColumns, new ArrayList<>());
    }

    public Ladder(int numberOfColumns, List<LadderLineConnections> connectionsByHeight) {
        this.numberOfColumns = numberOfColumns;
        this.connectionsByHeight = connectionsByHeight;
    }

    public void addLine() {
        connectionsByHeight.add(LadderLineConnections.from(numberOfColumns - 1));
    }

    public LadderLineConnections getConnectionsByHeight(int indexOfHeight) {
        return connectionsByHeight.get(indexOfHeight);
    }

    public int getValueOfHeight() {
        return connectionsByHeight.size();
    }

}
