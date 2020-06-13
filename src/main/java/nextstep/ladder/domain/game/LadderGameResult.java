package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.User;

import java.util.List;

public class LadderGameResult {
    private final List<User> users;

    public LadderGameResult(List<User> users) {
        this.users = users;
    }
}
