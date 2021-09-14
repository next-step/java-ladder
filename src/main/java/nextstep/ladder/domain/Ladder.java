package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(int playerCount, int ladderHeight) {
        validLadderHeight(ladderHeight);
        LadderGenerator ladderLinesGenerator = LadderGenerateFactory.findGenerator();
        lines = ladderLinesGenerator.generate(ladderHeight, playerCount);

    }

    private void validLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
