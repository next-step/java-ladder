package ladder.domain.line;

import ladder.domain.player.Players;
import ladder.domain.strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> lines;

    private Ladder(Players players, Height height, PointStrategy pointStrategy) {
        this.lines = createLines(players, height, pointStrategy);
    }

    public static Ladder of(Players players, Height height, PointStrategy pointStrategy) {
        return new Ladder(players, height, pointStrategy);
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private List<LadderLine> createLines(Players players, Height height, PointStrategy pointStrategy) {
        return Stream.generate(() -> LadderLine.of(players.size(), pointStrategy))
                .limit(height.getSize())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder that = (Ladder) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
