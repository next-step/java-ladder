package ladder.domain.row;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.ladder.Ladder.INITIAL_HEIGHT;

public class Rows {
    private final List<Row> rows;

    public Rows(List<Row> rows) {
        validate(rows);
        this.rows = new ArrayList<>(rows);
    }

    private void validate(List<Row> rows) {
        if (rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("rows는 빈 값일 수 없습니다.");
        }
    }

    public static Rows generateByWidthAndHeight(int ladderWidth, int ladderHeight) {
        return new Rows(
                IntStream.range(INITIAL_HEIGHT, ladderHeight)
                        .mapToObj(i -> Row.generateByWidth(ladderWidth))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Row::toString)
                .collect(Collectors.joining("\n"));

    }
}
