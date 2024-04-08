package nextstep.ladder.result;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.Users;

import java.util.List;

public class LadderResult {
    private final Users users;
    private final Ladder ladder;

    public LadderResult(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public List<String> getUserNames() {
        return users.getUserNames();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
