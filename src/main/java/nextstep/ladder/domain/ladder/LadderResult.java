package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.user.User;


public class LadderResult {
    private final User user;
    private final Result result;

    public LadderResult(User user, Result result) {
        this.user = user;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public Result getResult() {
        return result;
    }
}
