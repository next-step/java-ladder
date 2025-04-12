package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    public static final String INVALID_LADDER_SIZE_MESSAGE = "사다리 사이즈(높이,가로사이즈)는 1 이상이어야 합니다.";
    public static final String NOT_ALL_MATCH_LADDER_SIZE = "사다리 라인의 크기는 동일해야 합니다.";
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.validateLadderLines(ladderLines);

        this.ladderLines = ladderLines;
    }

    private void validateLadderLines(List<LadderLine> ladderLines) {
        if (ladderLines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LADDER_SIZE_MESSAGE);
        }

        int expectedLadderLineSize = ladderLines.get(0).size();
        boolean allMatch = ladderLines.stream()
                .allMatch(ladderLine -> ladderLine.size() == expectedLadderLineSize);

        if (!allMatch) {
            throw new IllegalArgumentException(NOT_ALL_MATCH_LADDER_SIZE);
        }
    }

    public List<LadderLine> getLines() {
        return ladderLines;
    }

    public static Ladder generate(int height, int ladderLineSize) {
        valid(height, ladderLineSize);
        List<LadderLine> ladderLines = generateLines(height, ladderLineSize);
        return new Ladder(ladderLines);
    }

    private static void valid(int height, int ladderLineSize) {
        if (height < 1 || ladderLineSize < 1) {
            throw new IllegalArgumentException(INVALID_LADDER_SIZE_MESSAGE);
        }
    }

    private static List<LadderLine> generateLines(int height, int ladderLineSize) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.generate(ladderLineSize));
        }
        return Collections.unmodifiableList(ladderLines);
    }
}
