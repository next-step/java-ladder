package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public List<LadderRow> rows;

    public Ladder(int height, int countOfPlayers) {
        rows = generateRows(height, countOfPlayers);
    }

    public boolean hasLine(int height, int width) {
        return this.rows.get(height).hasLine(width);
    }

    public int move(int index) {
        int position = index;
        for (LadderRow row : rows) {
            position = MovingStrategy.move(row, position);
        }
        return position;
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

    public List<LadderRow> getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }

        Ladder ladder = (Ladder) o;

        return rows.equals(ladder.rows);
    }

    @Override
    public int hashCode() {
        return rows.hashCode();
    }
}
