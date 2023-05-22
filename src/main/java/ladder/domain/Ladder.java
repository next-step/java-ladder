package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public List<LadderRow> rows;

    public Ladder(int height, int countOfPlayers) {
        rows = generateRows(height, countOfPlayers);
    }

    private List<LadderRow> generateRows(int height, int countOfPlayers) {
        final List<LadderRow> newRows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            newRows.add(new LadderRow(countOfPlayers - 1));
        }

        return newRows;
    }

    public int height() {
        return rows.size();
    }


}
