package nextstep.refactoring.ladder.concrete;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderCreator;
import nextstep.refactoring.ladder.engine.LineCreator;

public class LadderCreatorImpl implements LadderCreator {

    private final LineCreator lineCreator;

    public LadderCreatorImpl(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int height, int width) {
        return Stream.generate(() -> lineCreator.create(width))
                     .limit(height)
                     .collect(collectingAndThen(toList(), LadderImpl::new));
    }
}
