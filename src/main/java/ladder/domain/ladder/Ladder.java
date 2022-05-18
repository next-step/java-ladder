package ladder.domain.ladder;

import ladder.domain.point.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int INITIAL_HEIGHT = 0;

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        validate(rows);
        this.rows = new ArrayList<>(rows);
    }

    private void validate(List<Row> rows) {
        if (rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("rows는 빈 값일 수 없습니다.");
        }
    }

    public Position trace(Position position) {
        Position movingPosition = position;
        for (Row row : rows) {
            movingPosition = row.trace(movingPosition);
        }
        return movingPosition;
    }

    public static Ladder generateByWidthAndHeight(int width, int height) {
        return new Ladder(
                IntStream.range(INITIAL_HEIGHT, height)
                        .mapToObj(i -> Row.generateByWidth(width))
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
