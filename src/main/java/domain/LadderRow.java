package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final List<Boolean> columns = new ArrayList<>();

    public LadderRow(int width) {
        for (int i = 0; i < width - 1; i++) {
            columns.add(Math.random() < 0.5);
        }
    }

    public List<Boolean> getColumns() {
        return columns;
    }
}
