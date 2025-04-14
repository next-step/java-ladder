package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows = new ArrayList<>();

    public Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladderRows.add(new LadderRow(width));
        }
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }

}
