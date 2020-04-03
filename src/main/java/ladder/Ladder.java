package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(final List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder newInstance(final int memberCount, final int height) {
        List<LadderLine> ladders = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.newInstance(memberCount))
                .collect(Collectors.toList());
        return new Ladder(ladders);
    }
}
