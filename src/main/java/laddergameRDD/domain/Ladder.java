package laddergameRDD.domain;

import laddergameRDD.engine.SelectStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder = new ArrayList<>();

    public Ladder(int rowCount, int columnCount, SelectStrategy selectStrategy) {
        for (int i = 0; i < rowCount; ++i) {
            ladder.add(new Row(columnCount, selectStrategy));
        }
    }

    public int play(int sourceIndex) {
        int destinationIndex = sourceIndex;
        for (Row row: ladder) {
            destinationIndex = row.moveDown(destinationIndex);
        }
        return destinationIndex;
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
