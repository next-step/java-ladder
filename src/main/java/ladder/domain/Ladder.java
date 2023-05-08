package ladder.domain;

import ladder.control.Preferences;

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
        return IntStream.range(0, row)
                .mapToObj(rowIndex -> renderingRow(rowIndex, column))
                .collect(Collectors.toList());
    }

    private String renderingRow(int rowIndex, int columnRange) {
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
