package ladder.domain;

import ladder.strategy.GeneratorStrategy;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_COUNT_OF_PARTICIPANT = 2;
    private static final int MIN_HEIGHT = 1;

    private final List<LadderLine> ladderLines;
    private final int height;

    public Ladder(int countOfParticipant, int height, GeneratorStrategy movingStrategy) {
        validate(countOfParticipant, height);
        this.height = height;
        this.ladderLines = IntStream.range(0, height)
                .mapToObj(index -> LadderLine.init(countOfParticipant, movingStrategy))
                .collect(Collectors.toList());
    }

    private static void validate(final int countOfParticipant, final int height) {
        if (countOfParticipant < MIN_COUNT_OF_PARTICIPANT) {
            throw new IllegalArgumentException("참가자는 최소 두 명 이상 입니다.");
        }
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 최소 높이는 1 입니다.");
        }
    }

    public int findPrizeIndex(int position) {
        AtomicInteger index = new AtomicInteger();
        return IntStream.range(0, height)
                .map(i -> ladderLines.get(i).move(position))
                .reduce((first, second) -> ladderLines.get(index.incrementAndGet()).move(first))
                .orElse(0);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(this.ladderLines);
    }

}
