package ladder.domain;

import ladder.common.PositiveNumber;
import ladder.common.RandomStrategy;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.ladderline.LadderProxy;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultLadderLineFactory implements LadderLineFactory {

    private final RandomStrategy randomStrategy;

    public DefaultLadderLineFactory(RandomStrategy randomStrategy) {
        this.randomStrategy = randomStrategy;
    }

    @Override
    public LadderLines create(PositiveNumber countOfUsers, PositiveNumber height) {
        return LadderProxy.createLadderLines(LongStream.range(0, height.get())
                .mapToObj(index -> LadderProxy.createLadderLine(randomStrategy, countOfUsers))
                .collect(Collectors.toList()));
    }
}
