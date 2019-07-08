package ladder.domain;

import ladder.common.PositiveNumber;
import ladder.common.RandomStrategy;
import ladder.domain.model.*;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultLadderLineFactory implements LadderLineFactory {

    private final RandomStrategy randomStrategy;

    public DefaultLadderLineFactory(RandomStrategy randomStrategy) {
        this.randomStrategy = randomStrategy;
    }

    @Override
    public LadderLines create(PositiveNumber countOfUsers, PositiveNumber height) {
        return LadderLines.of(LongStream.range(0, height.get())
                .mapToObj(index -> LadderLine.of(randomStrategy, countOfUsers))
                .collect(Collectors.toList()));
    }
}
