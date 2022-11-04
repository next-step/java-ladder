package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int maxHeight) {
        return Stream.generate(() -> LadderLine.init(countOfPerson))
                .limit(maxHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public int getLadderEndIdx(int idx) {
        List<LadderLine> lines = this.getLines();
        for (LadderLine line : lines) {
            idx = line.move(idx);
        }
        return idx;
    }
}
