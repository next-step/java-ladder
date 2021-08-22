package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final int GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT = 1;
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int FIRST_INDEX = 0;
    private static final int SINGLE_LINE_COUNT = 1;

    private final List<LadderLine> lines;

    public Ladder(int playerCount, int ladderHeight) {
        validateMinLadderHeight(ladderHeight);

        int pointCount = playerCount - GAP_BETWEEN_PLAYER_COUNT_AND_POINT_COUNT;
        lines = generateLines(ladderHeight, pointCount);

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
        int pointCount = firstLine.getPointCount();

        IntStream.range(FIRST_INDEX, pointCount)
                .forEach(pointIndex -> {
                    List<Boolean> verticalLine = lines.stream()
                            .map(line -> line.getPoint(pointIndex))
                            .collect(toList());

                    if (verticalLine.contains(TRUE)) {
                        return;
                    }

                    throw new IllegalArgumentException("빈 가로 구간이 존재하면 안됩니다.");
                });
    }

    public static List<LadderLine> generateLines(int ladderLineCount, int pointCount) {
        if (ladderLineCount < pointCount) {
            return shuffled(generateLinesWithLadderLineCountLessThanPointCount(ladderLineCount, pointCount));
        }
        return shuffled(generateLinesWithLadderLineCountEqualOrMoreThanPointCount(ladderLineCount, pointCount));
    }

    private static List<LadderLine> generateLinesWithLadderLineCountLessThanPointCount(int ladderLineCount,
                                                                                       int pointCount) {
        return IntStream.range(FIRST_INDEX, ladderLineCount)
                .mapToObj(index -> {
                    List<Integer> truePointIndices = new ArrayList<>();
                    for (int truePointIndex = index; truePointIndex < pointCount; truePointIndex += ladderLineCount) {
                        truePointIndices.add(truePointIndex);
                    }
                    return LadderLine.of(pointCount, truePointIndices);
                })
                .collect(toList());
    }

    private static List<LadderLine> generateLinesWithLadderLineCountEqualOrMoreThanPointCount(int ladderLineCount,
                                                                                              int pointCount) {
        List<Integer> truePointIndices = IntStream.range(FIRST_INDEX, pointCount)
                .boxed()
                .collect(toList());

        return IntStream.range(FIRST_INDEX, ladderLineCount)
                .mapToObj((index) -> {
                    int truePointIndex;
                    if (index < pointCount) {
                        truePointIndex = truePointIndices.get(index);
                        return LadderLine.of(pointCount, Collections.singletonList(truePointIndex));
                    }
                    return LadderLine.of(pointCount);
                })
                .collect(toList());
    }

    private static List<LadderLine> shuffled(List<LadderLine> lines) {
        Collections.shuffle(lines);
        return lines;
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
