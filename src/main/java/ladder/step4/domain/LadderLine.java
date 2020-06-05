package ladder.step4.domain;

import ladder.step4.domain.strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLine {
    private final List<LadderPoint> lines;

    private LadderLine(List<LadderPoint> lines) {
        this.lines = lines;
    }

    public static LadderLine of(int countOfPerson, DirectionStrategy strategy) {
        final List<LadderPoint> ladderLine = new ArrayList<>();
        Direction prev = Direction.EMPTY;
        for (int i = 0; i < countOfPerson; i++) {
            Direction direction = prev = strategy.create(prev);
            ladderLine.add(LadderPoint.of(i, direction));
        }
        return new LadderLine(ladderLine);
    }

    public Stream<LadderPoint> stream() {
        return lines.stream();
    }

    public LadderPoint get (int index) {
      return lines.get(index);
    }
}
