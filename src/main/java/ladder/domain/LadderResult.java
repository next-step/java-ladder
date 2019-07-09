package ladder.domain;

import java.util.stream.IntStream;

public class LadderResult {
    private final Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
    }

    public int result(int index) {
        return IntStream.range(0, ladder.height())
                .reduce(index, (resultIndex, current) -> resultIndex = ladder.linesByLevel(current).move(resultIndex));
    }
}
