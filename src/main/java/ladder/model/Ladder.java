package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.toList;

public class Ladder {
    static final int GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT = 1;
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int FIRST_INDEX = 0;
    private static final int SINGLE_LINE_COUNT = 1;
    private static final int ZERO = 0;

    private final List<LadderLine> lines;

    public Ladder(int playerCount, int ladderHeight) {
        validateMinLadderHeight(ladderHeight);

        int pointCount = playerCount - GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT;
        LadderLinesGenerator ladderLinesGenerator = LadderLineGeneratorFactory.findGenerator(ladderHeight, pointCount);
        lines = ladderLinesGenerator.generate(ladderHeight, pointCount);

        validateNotExistEmptyVerticalInterval(lines);
    }

    Ladder(List<LadderLine> lines) {
        validateMinLadderHeight(lines.size());
        validateNotExistEmptyVerticalInterval(lines);
        this.lines = lines;
    }

    private void validateMinLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    private void validateNotExistEmptyVerticalInterval(List<LadderLine> lines) {
        if (lines.size() == SINGLE_LINE_COUNT) {
            return;
        }

        LadderLine firstLine = lines.get(FIRST_INDEX);

        IntStream.range(FIRST_INDEX, firstLine.pointCount())
                .forEach(pointIndex -> {
                    List<Boolean> verticalLine = lines.stream()
                            .map(line -> line.getPoint(pointIndex))
                            .collect(toList());

                    if (verticalLine.contains(TRUE)) {
                        return;
                    }

                    throw new IllegalArgumentException("사다리 게임 시스템의 내부 문제가 발생했습니다. 관리자에게 문의하세요.");
                });
    }

    List<LadderLine> getLines() {
        return lines;
    }

    int playerCount() {
        if (lines.isEmpty()) {
            return ZERO;
        }
        LadderLine firstLine = lines.get(FIRST_INDEX);
        return firstLine.pointCount() + GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT;
    }

    int findResultIndex(int playerIndex) {
        for (LadderLine line : lines) {
            playerIndex = line.findPlayerIndexAfterCrossingLine(playerIndex);
        }
        return playerIndex;
    }
}
