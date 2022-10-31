package ladder;

import java.util.List;

public class Ladder {

    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(List<Row> rows) {
        return new Ladder(rows);
    }

    public List<Row> getLadderLines() {
        return rows;
    }

    public LadderResult play(int people) {
        LadderResult result = LadderResult.of(people);
        // index, position

        for (int index = 0; index < people; index++) {
            int destination = descending(index);
            result.put(index, destination);
        }
        return result;
    }

    private int descending(int index) {
        int position = index;
        for (Row row : rows) {
            position = getNextPosition(row, position);
        }

        return position;
    }

    private int getNextPosition(Row row, int position) {
        if (row.move(position)) {
            return position + 1;
        }

        if (position > 0 && row.move(position - 1)) {
            return position - 1;
        }

        return position;
    }
}
