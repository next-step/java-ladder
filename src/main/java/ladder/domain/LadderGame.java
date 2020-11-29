package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;

    private LadderGame(final Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderGame of(final int userCount, final int ladderHeight) {
        final Ladder ladder = Ladder.of(userCount, ladderHeight);
        return new LadderGame(ladder);
    }

    public List<LadderLine> getLadderLine() {
        return ladder.getLadderLines();
    }
}
