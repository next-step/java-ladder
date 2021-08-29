package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {
    private final List<Line> lines;

    private Ladders(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladders initLadders(LadderWidth ladderWidth, LadderHeight ladderHeight, DirectionMakingStrategy directionMakingStrategy) {
        return IntStream.range(0, ladderHeight.getValue())
                .mapToObj(index -> Line.initLine(ladderWidth, directionMakingStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladders::new));
    }

    public List<Line> getLines() {
        return lines;
    }

    public LadderWidth getLadderWidth() {
        Line firstLine = lines.get(0);
        return firstLine.getLadderWidth();
    }

    public LadderHeight getLadderHeight() {
        return new LadderHeight(lines.size());
    }
}