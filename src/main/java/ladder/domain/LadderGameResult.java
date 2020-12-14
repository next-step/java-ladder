package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResult {
    private final Ladder ladder;
    private final List<Integer> result;

    public LadderGameResult(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.result = getResult(ladderResult);
    }

    private List<Integer> getResult(LadderResult ladderResult) {
        return ladder.run().stream().collect(Collectors.toList());
    }

}
