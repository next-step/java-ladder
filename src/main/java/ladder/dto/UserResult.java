package ladder.dto;

import ladder.domain.Result;
import ladder.domain.User;

public class UserResult {

    private final User user;

    private final Result result;

    public UserResult(User user, Result result) {
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


