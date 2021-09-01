package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int SINGLE_LINE_COUNT = 1;
    private static final int LAST_VERTICAL_LINE_COUNT = 1;
    private static final int FIRST_INDEX = 0;
    private static final int ZERO = 0;

    private final List<LadderLine> lines;

    public Ladder(int playerCount, int ladderHeight) {
        validateMinLadderHeight(ladderHeight);

        LadderLinesGenerator ladderLinesGenerator = LadderLineGeneratorFactory.findGenerator(ladderHeight, playerCount);
        lines = ladderLinesGenerator.generate(ladderHeight, playerCount);

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
        int pointCountExcludingLastPoint = firstLine.pointCount() - LAST_VERTICAL_LINE_COUNT;

        IntStream.range(FIRST_INDEX, pointCountExcludingLastPoint)
                .forEach(pointIndex -> {
                    List<LadderPoint> verticalLine = lines.stream()
                            .map(line -> line.getPoint(pointIndex))
                            .collect(toList());

                    boolean existVerticalLine = verticalLine.stream()
                            .anyMatch(LadderPoint::isRight);

                    if (existVerticalLine) {
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
        return firstLine.pointCount();
    }

    int findResultIndex(int playerIndex) {
        for (LadderLine line : lines) {
            playerIndex = line.findPlayerIndexAfterCrossingLine(playerIndex);
        }
        return playerIndex;
    }
}
