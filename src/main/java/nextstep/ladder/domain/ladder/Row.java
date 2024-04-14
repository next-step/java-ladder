package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final LinkedList<Direction> rungs = new LinkedList<>();

    public Row(Count playersCount, RungGenerateStrategy strategy) {
        this.rungs.addAll(generateDirections(playersCount, strategy));
        this.rungs.add(generateLastDirection());
    }

    private List<Direction> generateDirections(Count playersCount, RungGenerateStrategy strategy) {
        return Stream.iterate(Direction.NONE.generate(strategy),
                        previousRung -> previousRung.generate(strategy))
                .limit(playersCount.value() - 1)
                .collect(Collectors.toList());
    }

    private Direction generateLastDirection() {
        return rungs.getLast().generateLast();
    }

    public List<Direction> rungs() {
        return Collections.unmodifiableList(rungs);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        return rungs.get(columnIndex.value()).nextColumnIndex(columnIndex);
    }

}
