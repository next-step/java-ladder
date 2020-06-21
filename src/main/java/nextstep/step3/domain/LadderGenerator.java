package nextstep.step3.domain;

import nextstep.step3.domain.strategy.RandomDrawLineStrategy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGenerator {
    private Ladder ladder;

    public LadderGenerator(int userCount, int ladderHeightCount) {
        ladder = new Ladder(Stream.generate(() -> new Line(userCount, new RandomDrawLineStrategy()))
                .limit(ladderHeightCount)
                .collect(Collectors.toList()));
    }

    public Ladder getLadder() {
        return ladder;
    }
}
