package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Rung> rungs = new ArrayList<>();

    public Row(Count playersCount, RungGenerateStrategy strategy) {
        this.rungs.addAll(generateRungs(playersCount, strategy));
    }

    private List<Rung> generateRungs(Count playersCount, RungGenerateStrategy strategy) {
        return Stream.iterate(Rung.EMPTY.generate(strategy),
                        previousRung -> previousRung.generate(strategy))
                .limit(playersCount.subtract(1).value())
                .collect(Collectors.toList());
    }

    public List<Rung> rungs() {
        return Collections.unmodifiableList(rungs);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        if (!columnIndex.equals(rungs.size()) && isConnected(columnIndex)) {
            return columnIndex.next();
        }

        final ColumnIndex beforeIndex = columnIndex.before();
        if (columnIndex.isNotFirst() && isConnected(beforeIndex)) {
            return beforeIndex;
        }

        return columnIndex;
    }

    public boolean isConnected(ColumnIndex columnIndex) {
        return rungs.get(columnIndex.value()).exist();
    }
}
