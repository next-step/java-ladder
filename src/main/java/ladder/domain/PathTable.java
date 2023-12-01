package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PathTable {
    private final List<Row> rows;

    private PathTable(List<Row> rows) {
        this.rows = rows;
    }

    public static PathTable of(List<Line> lines) {
        return new PathTable(lineToRow(lines));
    }

    private static List<Row> lineToRow(List<Line> lines) {
        return lines.stream()
                .map(line -> Row.of(line.paths()))
                .collect(Collectors.toList());
    }

    public void navigate(Player player) {
        rows.stream()
                .forEach(row -> row.navigate(player));
    }
}
