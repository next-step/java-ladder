package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private static final int FIRST_ROW = 0;
    private static final int FIRST_COLUMN = 0;
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

    public Map<Integer, Integer> searchLine() {
        return IntStream.range(0, getCountOfColumn()).boxed()
                .collect(Collectors.toMap(Integer::intValue, this::getDestination));
    }

    private int getDestination(int startColumn) {
        Position currentPosition = Position.builder()
                .row(FIRST_ROW)
                .column(startColumn)
                .build();
        do {
            LadderDirection direction = LadderDirection.valueOf(this, currentPosition);
            currentPosition = direction.move.apply(currentPosition);
        } while (!onDestination(currentPosition));

        return currentPosition.getColumn();
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getCountOfColumn() {
        return rows.get(FIRST_ROW).getSize();
    }

    public boolean onDestination(Position currentPosition) {
        return currentPosition.getRow() == rows.size();
    }

    public boolean onFirstColumn(Position currentPosition) {
        return currentPosition.getColumn() == FIRST_COLUMN;
    }

    public boolean onLastColumn(Position currentPosition) {
        return currentPosition.getColumn() + 1 == getCountOfColumn();
    }

    public boolean checkLine(Position position) {
        return rows.get(position.getRow()).hasLine(position.getColumn());
    }

}
