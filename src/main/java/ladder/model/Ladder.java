package ladder.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final int GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT = 1;
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<LadderLine> lines;

    public Ladder(int playerCount, int ladderHeight) {
        validateMinLadderHeight(ladderHeight);
        lines = generateLines(ladderHeight, playerCount - GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT);
    }

    private void validateMinLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    private List<LadderLine> generateLines(int ladderLineCount, int pointCount) {
        return Stream.generate(() -> LadderLine.of(pointCount))
                .limit(ladderLineCount)
                .collect(toList());
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
