package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderRow> rows;

    public Ladder(int height, int countOfPlayers) {
        rows = generateRows(height, countOfPlayers);
    }

    public List<LadderRow> getRows() {
        return rows;
    }

    private List<LadderRow> generateRows(int height, int countOfPlayers) {
        final List<LadderRow> newRows = new ArrayList();

        for (int i=0; i<height; i++) {
            newRows.add(new LadderRow(countOfPlayers - 1));
        }

        return  newRows;
    }

    public int size() {
        return rows.size();
    }
}
