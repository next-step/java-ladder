package ladder.domain;

import ladder.strategy.LineStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {
    private static final int MIN_HEIGHT_OF_LADDER = 1;
    public static final int MIN_COUNT_OF_PARTICIPANTS = 1;

    public static List<Line> createLines(int heightOfLadder, int countOfParticipants, LineStrategy lineStrategy) {
        if (heightOfLadder < MIN_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT_OF_LADDER + "이상이어야 합니다.");
        }
        if (countOfParticipants < MIN_COUNT_OF_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자는 " + MIN_COUNT_OF_PARTICIPANTS + "명 이상이어야 합니다.");
        }

        List<Line> lines = IntStream.range(0, heightOfLadder)
                    .mapToObj(i -> createLine(countOfParticipants, lineStrategy))
                    .collect(Collectors.toList());
        return lines;
    }

    private static Line createLine(int countOfParticipants, LineStrategy lineStrategy) {
        return Line.from(lineStrategy.initialPoints(countOfParticipants));
    }
}
