package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int FIRST_ROW = 0;
    private final List<Row> rows;

    @Builder
    public Ladder(int rowCount, int columnCount) {
       this.rows = initLadder(rowCount, columnCount);
    }

    private List<Row> initLadder(int rowCount, int columnCount) {
        return Stream.generate(() -> Row.of(columnCount))
                .limit(rowCount)
                .collect(Collectors.toList());
    }

    public void drawLine(DrawRule drawRule) {
        rows.stream().forEach(row -> row.drawLine(drawRule));
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getCountOfColumn() {
        return rows.get(FIRST_ROW).getSize();
    }

}
