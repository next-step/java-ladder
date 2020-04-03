package ladder.model;

import ladder.booleangenerator.NextBooleanGenerator;

import java.util.HashMap;
import java.util.Map;

public class Row {
    private Map<Integer, Boolean> row;

    public Row(Map<Integer, Boolean> row) {
        this.row = row;
    }

    public static Row create(int playerCount) {
        Map<Integer, Boolean> row = new HashMap<>();

        boolean prev = false;
        for (int i = 1; i <= playerCount - 1; i++) {
            boolean currentBoolean = findNextBoolean(prev);
            row.put(i, currentBoolean);
            prev = currentBoolean;
        }

        return new Row(row);
    }

    public boolean getRowElement(int index) {
        return row.get(index);
    }

    private static boolean findNextBoolean(boolean prev) {
        return NextBooleanGenerator.generate(prev);
    }

    public Map<Integer, Boolean> getRow() {
        return row;
    }

    public int getSize(){
        return row.size();
    }
}
