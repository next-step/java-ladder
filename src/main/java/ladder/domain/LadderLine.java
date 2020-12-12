package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {

    private static final boolean BAR = true;
    private static final boolean BLANK = false;
    private final List<Boolean> points;

    public LadderLine(int participantsCount, LadderGenerateStrategy ladderGenerateStrategy) {
        this.points = InitializeLadder(participantsCount, ladderGenerateStrategy);
    }

    private List<Boolean> InitializeLadder(int participantsCount, LadderGenerateStrategy ladderGenerateStrategy) {
        int ladderLength = participantsCount * 2 - 1;
        return createPoints(ladderLength, ladderGenerateStrategy);
    }

    private List<Boolean> createPoints(int ladderLength, LadderGenerateStrategy ladderGenerateStrategy) {
        List<Boolean> result = initializePoints(ladderLength);

        result.set(2, ladderGenerateStrategy.isGenerating());
        for (int index = 3; index < ladderLength; index += 2) {
            result.set(index, createPoint(result.get(index - 2), new RandomLadderGenerateStrategy()));
        }
        return result;
    }

    private Boolean createPoint(boolean previousLadder, LadderGenerateStrategy ladderGenerateStrategy) {
        if (!previousLadder) {
            return ladderGenerateStrategy.isGenerating();
        }
        return BLANK;
    }

    private List<Boolean> initializePoints(int ladderLength) {
        return IntStream.range(0, ladderLength)
                .mapToObj(index -> BAR)
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
