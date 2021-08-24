package ladder.domain.impl;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.LineCreator;

public class MyLadderCreator implements LadderCreator {

    private final LineCreator lineCreator;

    public MyLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int countOfPeople, int height) {
        return IntStream.range(0, height)
                .boxed()
                .map(h -> lineCreator.create(countOfPeople))
                .collect(Collectors.collectingAndThen(Collectors.toList(), MyLadder::of));
    }
}
