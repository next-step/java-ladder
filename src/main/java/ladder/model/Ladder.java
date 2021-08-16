package ladder.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<LadderLine> lines;

    Ladder(int playerCount, int ladderHeight) {
        validateMinLadderHeight(ladderHeight);
        this.lines = generateLines(ladderHeight, playerCount - 1);
    }

    private List<LadderLine> generateLines(int ladderLineCount, int pointCount) {
        return Stream.generate(() -> new LadderLine(pointCount))
                .limit(ladderLineCount)
                .collect(toList());
    }

    private void validateMinLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }
}
