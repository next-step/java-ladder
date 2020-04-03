package ladder.model;

import java.util.Map;

public class Row {
    private Map<Integer, Boolean> row;

    public Row(Map<Integer, Boolean> row) {
        this.row = row;
    }

    public static Row create(int playerCount) {
        return null;
    }

    public boolean getRowElement(int index) {
        return row.get(index);
    }
}
