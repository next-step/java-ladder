package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Ladder ladder;
    private final List<Integer> ladderResult;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
        this.ladderResult = start();
    }

    private List<Integer> start() {
        return IntStream.range(0, ladder.getLadderWidth())
                .mapToObj(ladder::getLastPosition)
                .collect(Collectors.toList());
    }

    public List<Integer> getLadderResult() {
        return ladderResult;
    }
}
