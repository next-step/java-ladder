package ladder.domain;

import ladder.control.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            strings.add(renderingRow(rowIndex,column));
        }
        return strings;
    }

    private String renderingRow(int rowIndex,int columnRange) {
        return IntStream.range(0, columnRange)
                .mapToObj(columnIndex -> pixelRendering(columnIndex, rowIndex))
                .collect(Collectors.joining());
    }

    private String pixelRendering(int columnIndex, int rowIndex) {
        return Preferences.pillarShape().concat(lineShape(columnIndex, rowIndex));
    }

    private String lineShape(int columnIndex, int rowIndex) {
        return lines.existLine(columnIndex, rowIndex) ? Preferences.allocatedLineShape() : Preferences.emptyLineShape();
    }
}
