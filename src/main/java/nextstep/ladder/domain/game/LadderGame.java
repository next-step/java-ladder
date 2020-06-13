package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.Objects;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        if(Objects.isNull(ladder)) {
            throw new IllegalArgumentException("Ladder is null.");
        }
        this.ladder = ladder;
    }

    public LadderGameResult play(List<User> users) {
        return null;
    }
}
