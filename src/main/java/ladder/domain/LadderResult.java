package ladder.domain;

import java.util.stream.IntStream;

public class LadderResult {
    private final Ladder ladder;
    private final Names names;

    public LadderResult(Ladder ladder, Names names) {
        this.ladder = ladder;
        this.names = names;
    }

    public int result(int index) {
        return IntStream.range(0, ladder.height())
                .reduce(index, (resultIndex, current) -> resultIndex = ladder.linesByLevel(current).move(resultIndex));
    }
}
