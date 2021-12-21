package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private static final String EXCEPTION_MESSAGE_POSITION = "위치가 정확하지 않습니다.";
    private static final long MIN_DISTINCT_POINT_COUNT = 1L;
    private static final int MIN_POSITION = 0;

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        validateLadder(ladderLines);
        this.ladderLines = ladderLines;
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

    public int getPosition(int position) {
        validatePosition(position);
        for (LadderLine ladderLine : ladderLines) {
//            Direction direction = Direction.valueOf(ladderLine.isLine(position), ladderLine.isNextLine(position));
//            position += direction.getMovePosition();
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
}
