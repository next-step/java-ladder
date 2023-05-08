package ladder.domain;

import ladder.control.Preferences;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int column;
    private final int row;
    private final Lines lines;

    public Ladder(int column, int row) {
        this.column = column;
        this.row = row;
        this.lines = Lines.of(column, row, Preferences.createLineCount(column, row));
    }

    public List<String> rendering() {
        List<String> strings = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            StringBuilder lineBuilder;
            lineBuilder = new StringBuilder();
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {


                lineBuilder.append("|");
                if (lines.existLine(columnIndex, rowIndex)) {
                    lineBuilder.append("------");
                } else {
                    lineBuilder.append("      ");
                }
            }
            strings.add(lineBuilder.toString());
        }
        return strings;
    }
}
