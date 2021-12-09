package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int sizeOfPerson, int height) {
        List<LadderLine> ladderLines = IntStream.of(height)
                .boxed()
                .map(x -> LadderLine.init(sizeOfPerson))
                .collect(Collectors.toList());
        return new Ladder(ladderLines);
    }
}
