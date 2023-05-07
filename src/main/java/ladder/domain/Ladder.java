package ladder.domain;

import ladder.control.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ladder {
    private final int column;
    private final int row;
    private final Lines lines;

    public Ladder(int column, int row) {
        this.column = column;
        this.row = row;
        this.lines = Lines.of(column, row, Preferences.lineCount(row));
    }

    public List<String> rendering() {
        List<String> strings = new ArrayList<>();
        StringBuilder lineBuilder;
        for(int columnIndex = 0; columnIndex< column; columnIndex++) {
            lineBuilder = new StringBuilder();
            for(int rowIndex = 0; rowIndex< row; rowIndex++ ) {
                lineBuilder.append("|");
                if (lines.existLine(columnIndex, rowIndex)) {
                    lineBuilder.append("------");
                }
                else {
                    lineBuilder.append("      ");
                }
            }
            strings.add(lineBuilder.toString());
        }
        return strings;
    }
}
