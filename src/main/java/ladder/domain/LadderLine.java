package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {

    private static final boolean BAR = true;
    private static final boolean BLANK = false;
    private static final int FIRST_LADDER_INDEX = 1;
    private static final int SECOND_LADDER_INDEX = 3;
    private final List<Boolean> points;

    public LadderLine(int sizeOfLadder, LadderGenerateStrategy ladderGenerateStrategy) {
        this.points = InitializeLadder(sizeOfLadder, ladderGenerateStrategy);
    }

    private List<Boolean> InitializeLadder(int sizeOfLadder, LadderGenerateStrategy ladderGenerateStrategy) {
        return createPoints(sizeOfLadder, ladderGenerateStrategy);
    }

    private List<Boolean> createPoints(int ladderLength, LadderGenerateStrategy ladderGenerateStrategy) {
        List<Boolean> result = initializePoints(ladderLength);

        result.set(FIRST_LADDER_INDEX, ladderGenerateStrategy.isGenerating());
        for (int index = SECOND_LADDER_INDEX; index < ladderLength; index += 2) {
            int previousLadderIndex = index - 2;
            Boolean point = createPoint(result.get(previousLadderIndex), new RandomLadderGenerateStrategy());
            result.set(index, point);
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
