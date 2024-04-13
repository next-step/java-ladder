package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Row> values = new ArrayList<>();

    public Ladder(Height height, Count playersCount, RungGenerateStrategy strategy) {
        this(Stream.generate(() -> new Row(playersCount, strategy))
                .limit(height.value())
                .collect(Collectors.toList()));
    }

    public Ladder(List<Row> values) {
        assertRowsNotEmpty(values);

        this.values.addAll(values);
    }

    private void assertRowsNotEmpty(List<Row> rows) {
        if (rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("사다리 행은 비어있을 수 없습니다.");
        }
    }

    public Height height() {
        return new Height(this.values.size());
    }

    public void forEach(Consumer<Row> action) {
        values.forEach(action);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        return values.stream()
                .reduce(columnIndex, (currentIdx, row) -> row.moveFrom(currentIdx), (resultA, resultB) -> resultB);
    }
}
