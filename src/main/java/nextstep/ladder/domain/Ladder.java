package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final String EXCEPTION_MESSAGE_POSITION = "위치가 정확하지 않습니다.";
    private static final long MIN_DISTINCT_POINT_COUNT = 1L;
    private static final int MIN_POSITION = 0;

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        validateLadder(ladderLines);
        this.ladderLines = ladderLines;
    }

    public static Ladder of(Members members, LadderLayer ladderLayer, PointStrategy pointStrategy) {
        List<LadderLine> ladderLines = Stream.generate(() -> LadderLine.of(members.countOfMember(), pointStrategy))
                .limit(ladderLayer.getLayer())
                .collect(Collectors.toList());
        return new Ladder(ladderLines);
    }

    private void validateLadder(List<LadderLine> lines) {
        long distinctPointCount = lines.stream()
                                            .map(ladderLine -> ladderLine.getPoints().size())
                                            .distinct()
                                            .count();
        if (distinctPointCount != MIN_DISTINCT_POINT_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int move(int position) {
        validatePosition(position);
        for (LadderLine line : ladderLines) {
            position = line.move(position);
        }
        return position;
    }

    private void validatePosition(int position) {
        if (ladderLines.size() < position || MIN_POSITION > position) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_POSITION);
        }
    }

    public List<LadderLine> getLines() {
        return ladderLines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
