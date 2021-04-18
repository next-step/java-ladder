package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LadderCreator {

    private static final int START_INCLUSIVE = 0;

    private static final class LadderCreateModuleHolder {
        private static final LadderCreator LADDER_CREATOR = new LadderCreator();
    }

    public LadderCreator() {
    }

    public static final LadderCreator getInstance() {
        return LadderCreateModuleHolder.LADDER_CREATOR;
    }

    public final Ladder create(LadderCreationInformation creationInformation, LineGenerateStrategy strategy) {
        LineCreator lineCreator = LineCreator.getInstance();
        return Ladder.from(IntStream.range(START_INCLUSIVE, creationInformation.height())
                .mapToObj(i -> lineCreator.create(creationInformation.width(), strategy))
                .collect(Collectors.toList())
        );
    }
}
