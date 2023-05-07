package ladder.domain;

import ladder.control.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ladder {
    private final int column;
    private final int row;
    private final Lines lines;
    private final Pillars pillars;

    public Ladder(int column, int row) {
        this.column = column;
        this.row = row;
        this.pillars = new Pillars(column, row);
        this.lines = new Lines(column, row, Preferences.lineCount(row));
    }

    public List<String> rendering() {
        List<String> strings = new ArrayList<>();
        StringBuilder lineBuilder;
        for(int i = 0; i< column; i++) {
            lineBuilder = new StringBuilder();
            for(int j = 0; j< row; j++ ) {
                lineBuilder.append("|");
                if (lines.existLine(i, j)) {
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
