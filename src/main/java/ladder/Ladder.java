package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }


    public static Ladder of(int countOfColumn, int ladderHeight) {
        List<LadderLine> ladderLines = IntStream.range(0, ladderHeight)
                                                .mapToObj(index -> LadderLine.of(countOfColumn))
                                                .collect(Collectors.toList());

        return new Ladder(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
