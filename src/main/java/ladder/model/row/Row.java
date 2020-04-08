package ladder.model.row;

import ladder.model.player.Position;
import ladder.randomgenerator.BooleanGenerator;

import java.util.HashMap;
import java.util.Map;

public class Row {
    private Map<Position, Boolean> row;

    public Row(Map<Position, Boolean> row) {
        this.row = row;
    }

    public static Row create(int playerCount) {
        Map<Position, Boolean> row = new HashMap<>();

        boolean prev = false;
        for (int i = 0; i < playerCount - 1; i++) {
            boolean currentBoolean = findNextBoolean(prev);
            row.put(new Position(i), currentBoolean);
            prev = currentBoolean;
        }

        return new Row(row);
    }

    public boolean getRowElement(Position position) {
        return row.get(position);
    }

    public int getLastLocationValue() {
        return row.size();
    }

    private static boolean findNextBoolean(boolean prev) {
        return BooleanGenerator.getNextBoolean(prev);
    }
}