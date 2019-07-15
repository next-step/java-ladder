package ladder.domain;

import java.util.stream.IntStream;

public class Ladder2Result {
    private final Ladder2 ladder;
    private final Names names;

    public Ladder2Result(Ladder2 ladder, Names names) {
        this.ladder = ladder;
        this.names = names;
    }

    public int result(int index) {
        if (index == -1) {
            return -1;
        }
        return IntStream.range(0, ladder.height())
                .reduce(index, (resultIndex, current) -> resultIndex = ladder.getLadderLineByLevel(current).move(resultIndex));
    }

    public int resultOf(String name) {
        return result(names.indexOf(name));
    }
}
