package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderCreator {
    private static final int FIRST = 0;
    private final LadderLineCreator ladderLineCreator;

    public LadderCreator(final LadderLineCreator ladderLineCreator) {
        this.ladderLineCreator = ladderLineCreator;
    }

    public Ladder create(final PositiveNumber ladderHeight, final PositiveNumber ladderWidth) {
        return new Ladder(createLadderLines(ladderHeight, ladderWidth));
    }

    private List<LadderLine> createLadderLines(
        final PositiveNumber ladderHeight,
        final PositiveNumber ladderWidth
    ) {
        return IntStream.range(FIRST, ladderHeight.intValue())
            .mapToObj(i -> ladderLineCreator.create(ladderWidth))
            .collect(Collectors.toUnmodifiableList());
    }
}
