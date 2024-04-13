package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResults;
import nextstep.ladder.domain.result.Results;

import java.util.ArrayList;
import java.util.List;
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

    public List<Row> rows() {
        return this.values;
    }

    public GameResults gameResults(Players players, Results results) {
        return players.values().stream()
                .collect(GameResults::new,
                        (gameResults, player) -> gameResults.add(player, results.findBy(moveFrom(player.index()))),
                        GameResults::addAll);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        return values.stream()
                .reduce(columnIndex, (currentIdx, row) -> row.moveFrom(currentIdx), (resultA, resultB) -> resultB);
    }
}
