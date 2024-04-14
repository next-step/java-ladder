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
        this.rungs.addAll(generateDirections(playersCount, strategy));
        this.rungs.add(generateLastDirection());
    }

    private List<Rung> generateDirections(Count playersCount, RungGenerateStrategy strategy) {
        return Stream.iterate(Rung.NONE.generate(strategy),
                        previousRung -> previousRung.generate(strategy))
                .limit(playersCount.value() - 1)
                .collect(Collectors.toList());
    }

    private Rung generateLastDirection() {
        return rungs.getLast().generateLast();
    }

    public List<Rung> rungs() {
        return Collections.unmodifiableList(rungs);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        return rungs.get(columnIndex.value()).nextColumnIndex(columnIndex);
    }

}
