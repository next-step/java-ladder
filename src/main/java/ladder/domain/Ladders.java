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
        List<Line> lines = IntStream.range(0, ladderHeight.getValue())
                .mapToObj(index -> Line.initLine(ladderWidth, directionMakingStrategy))
                .collect(Collectors.toList());
        return new Ladders(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}