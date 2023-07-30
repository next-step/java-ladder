package nextstep.ladder.domain;

import java.util.Objects;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public MoveResult gameStart(int playerIndex) {
        return ladder.movePlayer(playerIndex);
    }

    public MoveResult gameStart() {
        return ladder.movePlayer();
    }
}
