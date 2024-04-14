package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final LinkedList<Rung> rungs = new LinkedList<>();

    public Row(Count playersCount, RungGenerateStrategy strategy) {
        this.rungs.addAll(generateRungs(playersCount, strategy));
        this.rungs.add(generateLastRung());
    }

    private List<Rung> generateRungs(Count playersCount, RungGenerateStrategy strategy) {
        return Stream.iterate(Rung.empty().generate(strategy),
                        previousRung -> previousRung.generate(strategy))
                .limit(playersCount.value() - 1)
                .collect(Collectors.toList());
    }

    private Rung generateLastRung() {
        return rungs.getLast().generate(() -> false);
    }

    public List<Rung> rungs() {
        return Collections.unmodifiableList(rungs);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        return rungs.get(columnIndex.value()).moveFrom(columnIndex);
    }

}
