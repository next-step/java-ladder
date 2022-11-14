package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderCreatorImpl implements LadderCreator {
    private final LadderLineCreator ladderLineCreator;

    public LadderCreatorImpl(final LadderLineCreator ladderLineCreator) {
        this.ladderLineCreator = ladderLineCreator;
    }

    @Override
    public Ladder create(final PositiveNumber ladderHeight, final PositiveNumber ladderWidth) {
        return new Ladder(createLadderLines(ladderHeight, ladderWidth));
    }

    private List<LadderLine> createLadderLines(
        final PositiveNumber ladderHeight,
        final PositiveNumber ladderWidth
    ) {
        final List<LadderLine> result = new ArrayList<>();
        for (PositiveNumber i = PositiveNumber.ONE;
            i.isLessThanOrEquals(ladderHeight);
            i = i.plus(PositiveNumber.ONE)){
            result.add(ladderLineCreator.create(ladderWidth));
        }
        return Collections.unmodifiableList(result);
    }
}
