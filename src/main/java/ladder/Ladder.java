package ladder;

import java.util.List;

public class Ladder {

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getLadderLines() {
        return rows;
    }

    public LadderResult play(int CountOfPeople) {
        LadderResult result = LadderResult.of(CountOfPeople);

        for (int index = 0; index < CountOfPeople; index++) {
            Position destination = descending(index);
            result.put(index, destination);
        }
        return result;
    }

    private Position descending(int index) {
        Position position = new Position(index);
        for (Row row : rows) {
            position = getNextPosition(row, position);
        }

        return position;
    }

    private Position getNextPosition(Row row, Position position) {
        return row.move(position);
    }
}
