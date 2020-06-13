package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.Objects;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        if(Objects.isNull(ladder)) {
            throw new IllegalArgumentException("Ladder is null.");
        }
        this.ladder = ladder;
    }
}
