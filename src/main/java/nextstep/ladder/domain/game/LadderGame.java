package nextstep.ladder.domain.game;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderConnectionConditional;
import nextstep.ladder.domain.user.LadderGameUserStorage;

public class LadderGame {
    private final LadderConnectionConditional conditional;

    public LadderGame(LadderConnectionConditional conditional) {
        this.conditional = conditional;
    }

    public Ladder createLadder(final LadderGameUserStorage ladderGameUserStorage, final int maxHeight) {
        return Ladder.of(ladderGameUserStorage.count(), conditional, maxHeight);
    }

    public LadderGameResult execute(final Ladder ladder, final LadderGameUserStorage users,
                                    final int maxPoint, final LadderGamePrize prize) {
        return LadderGameResult.of(ladder, users, maxPoint, prize);
    }
}
