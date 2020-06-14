package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO_HEIGHT = 0;

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder create(int memberCount, int ladderHeight) {
        List<LadderLine> lines = IntStream.range(ZERO_HEIGHT, ladderHeight)
            .mapToObj(i -> LadderLine.create(memberCount))
            .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
