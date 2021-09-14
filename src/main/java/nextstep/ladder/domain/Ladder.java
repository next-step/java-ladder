package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<LadderLine> ladderLines;

    public Ladder(LadderGenerator ladderGenerator, int playerCount, int ladderHeight) {
        validLadderHeight(ladderHeight);
        this.ladderLines = createLadderLine(ladderGenerator, playerCount, ladderHeight);
    }

    public List<LadderLine> createLadderLine(LadderGenerator ladderGenerator, int playerCount, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(index -> LadderLine.init(playerCount, ladderGenerator))
                .collect(Collectors.toList());
    }

    public int climbLadder(int position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }

    private void validLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    public List<LadderLine> getLines() {
        return ladderLines;
    }
}
